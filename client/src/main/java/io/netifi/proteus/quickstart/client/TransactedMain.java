package io.netifi.proteus.quickstart.client;

import com.google.protobuf.Empty;
import io.netifi.proteus.Proteus;
import io.netifi.proteus.quickstart.service.protobuf.TransactedChannelServiceClient;
import io.netifi.proteus.quickstart.service.protobuf.TransactedRequest;
import io.netifi.proteus.rsocket.ProteusSocket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Starts the Proteus Quickstart Client
 */
public class TransactedMain {
  private static final Logger logger = LogManager.getLogger(TransactedMain.class);
  
  public static void main(String... args) {
    
    // Build Netifi Proteus Connection
    Proteus netifi =
      Proteus.builder()
        .group("quickstart.clients")                    // Group name of client
        .destination("client " + System.currentTimeMillis())                         // Name of this client instance
        .accessKey(9007199254740991L)
        .accessToken("kTBDVtfRBO4tHOnZzSyY5ym2kfY=")
        .host("localhost")                              // Proteus Broker Host
        .port(8001)                                     // Proteus Broker Port
        .build();
    
    // Connect to Netifi Proteus Platform
    ProteusSocket conn = netifi.group("quickstart.services.helloservices");
    
    TransactedChannelServiceClient client = new TransactedChannelServiceClient(conn);
    
    client
      .readTransacted(Empty.getDefaultInstance())
      .doOnNext(response -> {
        System.out.println("first value equals -> " + response.getValue());
      })
      .block();
    
    Flux<TransactedRequest> request = Flux
                                        .range(1, 10)
                                        .flatMap(integer -> {
                                          if (integer % 2 == 0) {
                                            return Mono.empty();
                                          } else {
                                            return client
                                                     .readTransacted(Empty.getDefaultInstance())
                                                     .doOnNext(response -> {
                                                       System.out.println("value equals -> " + response.getValue());
                                                     })
                                                     .thenReturn(integer);
                                          }
                                        })
                                        .map(integer -> {
                                          TransactedRequest.Builder builder = TransactedRequest.newBuilder();
                                          if (integer % 2 == 0) {
                                            System.out.println("ADD");
                                            builder
                                              .setAdd(TransactedRequest
                                                        .Add.newBuilder()
                                                        .setDelta(ThreadLocalRandom.current().nextInt(0, 100))
                                                        .build());
                                          } else {
                                            System.out.println("SUB");
                                            builder
                                              .setSub(TransactedRequest
                                                        .Sub.newBuilder()
                                                        .setDelta(ThreadLocalRandom.current().nextInt(0, 100))
                                                        .build());
                                          }
        
                                          return builder.build();
                                        });
    
    client
      .transactedChannel(request)
      .block();
    
    
    client
      .readTransacted(Empty.getDefaultInstance())
      .doOnNext(response -> {
        System.out.println("last value equals -> " + response.getValue());
      })
      .block();
    
    
  }
}
