package io.netifi.proteus.quickstart.client;

import io.netifi.proteus.Proteus;
import io.netifi.proteus.quickstart.service.protobuf.Request;
import io.netifi.proteus.quickstart.service.protobuf.StatefulChannelServiceClient;
import io.netifi.proteus.rsocket.ProteusSocket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Starts the Proteus Quickstart Client
 */
public class Main {
  private static final Logger logger = LogManager.getLogger(Main.class);
  
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
    
    // Create Client to Communicate with the StatefulChannelService (included example service)
    StatefulChannelServiceClient client = new StatefulChannelServiceClient(conn);
    
    
    Flux<Request> requestFlux = Flux
                                  .interval(Duration.ofMillis(250))
                                  .onBackpressureDrop(aLong -> System.out.println("DROPPPED -> " + aLong))
                                  .map(l -> Request.newBuilder()
                                              .setNumber(ThreadLocalRandom.current()
                                                           .nextInt())
                                              .build());
    
    client.statefulChannel(requestFlux).doOnNext(response -> System.out.println(response.getTotal()))
      .blockLast();
  }
}
