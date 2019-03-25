package io.netifi.proteus.quickstart.service;

import com.google.protobuf.Empty;
import io.netifi.proteus.quickstart.service.protobuf.ReadTransactedResponse;
import io.netifi.proteus.quickstart.service.protobuf.TransactedChannelService;
import io.netifi.proteus.quickstart.service.protobuf.TransactedRequest;
import io.netty.buffer.ByteBuf;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoProcessor;

import java.util.concurrent.atomic.AtomicInteger;

public class DefaultTransactedChannelService implements TransactedChannelService {
  private AtomicInteger currentValue;
  private MonoProcessor<Void> activeTransaction;
  
  public DefaultTransactedChannelService() {
    this.currentValue = new AtomicInteger();
  }
  
  @Override
  public Mono<Empty> transactedChannel(final Publisher<TransactedRequest> messages, final ByteBuf metadata) {
    MonoProcessor<Void> transaction;
    boolean active = true;
    
    synchronized (this) {
      if (activeTransaction == null) {
        activeTransaction = MonoProcessor.create();
        active = false;
      }
      transaction = activeTransaction;
    }
    
    if (active) {
      return transaction.then(Mono.defer(() -> transactedChannel(messages, metadata)));
    } else {
      AtomicInteger newValue = new AtomicInteger(currentValue.get());
      return Flux
        .from(messages)
        .doOnNext(transactedRequest -> {
          if (transactedRequest.hasAdd()) {
            int delta = transactedRequest.getAdd().getDelta();
            System.out.println("adding " + delta);
            newValue.addAndGet(delta);
          } else if (transactedRequest.hasSub()) {
            int delta = transactedRequest.getSub().getDelta();
            System.out.println("subtracting " + delta);
            newValue.addAndGet(-delta);
          } else {
            throw new IllegalStateException("did not have add or sub messages");
          }
        })
        .doOnComplete(() -> {
          currentValue.set(newValue.intValue());
          synchronized (DefaultTransactedChannelService.this) {
            activeTransaction = null;
          }
        })
        .ignoreElements()
        .thenReturn(Empty.getDefaultInstance());
    }
    
  }
  
  @Override
  public Mono<ReadTransactedResponse> readTransacted(Empty message, ByteBuf metadata) {
    return Mono.just(ReadTransactedResponse.newBuilder().setValue(currentValue.get()).build());
  }
}
