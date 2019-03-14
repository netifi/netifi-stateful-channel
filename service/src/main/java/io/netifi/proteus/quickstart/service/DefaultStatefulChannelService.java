package io.netifi.proteus.quickstart.service;

import io.netifi.proteus.quickstart.service.protobuf.Request;
import io.netifi.proteus.quickstart.service.protobuf.Response;
import io.netifi.proteus.quickstart.service.protobuf.StatefulChannelService;
import io.netty.buffer.ByteBuf;
import org.reactivestreams.Publisher;
import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class DefaultStatefulChannelService implements StatefulChannelService {
  private final DirectProcessor<Request> processor;
  
  private final Flux<Response> responseFlux;
  
  public DefaultStatefulChannelService() {
    this.processor = DirectProcessor.create();
    this.responseFlux = createResponseFlux();
  }
  
  private Flux<Response> createResponseFlux() {
    return processor
             .log()
             // map the requests to numbers
             .map(Request::getNumber)
             // add the numbers using scan - this will keep state
             .scan(0, (i1, i2) -> i1 + i2)
             // drop messages we don't want to sample
             .onBackpressureDrop()
             // sample ever second
             .sample(Duration.ofSeconds(1))
             // map the sampled result to a string
             .map(integer -> Response.newBuilder().setTotal("the current total is " + integer).build())
             // use publish and refCount to allow multiple subscribers
             .publish()
             .refCount();
  }
  
  @Override
  public Flux<Response> statefulChannel(Publisher<Request> messages, ByteBuf metadata) {
    // add the incoming channel to be processed, and limit stream to 8 at a time
    Flux.from(messages).limitRate(8).subscribe(processor::onNext);
    return responseFlux;
  }
  
}
