package io.netifi.proteus.quickstart.service.protobuf;

@javax.annotation.Generated(
    value = "by RSocket RPC proto compiler (version 0.2.12)",
    comments = "Source: io/netifi/proteus/quickstart/service/protobuf/service.proto")
@io.rsocket.rpc.annotations.internal.Generated(
    type = io.rsocket.rpc.annotations.internal.ResourceType.CLIENT,
    idlClass = BlockingStatefulChannelService.class)
public final class BlockingStatefulChannelServiceClient implements BlockingStatefulChannelService {
  private final io.netifi.proteus.quickstart.service.protobuf.StatefulChannelServiceClient delegate;

  public BlockingStatefulChannelServiceClient(io.rsocket.RSocket rSocket) {
    this.delegate = new io.netifi.proteus.quickstart.service.protobuf.StatefulChannelServiceClient(rSocket);
  }

  public BlockingStatefulChannelServiceClient(io.rsocket.RSocket rSocket, io.micrometer.core.instrument.MeterRegistry registry) {
    this.delegate = new io.netifi.proteus.quickstart.service.protobuf.StatefulChannelServiceClient(rSocket, registry);
  }

  @io.rsocket.rpc.annotations.internal.GeneratedMethod(returnTypeClass = io.netifi.proteus.quickstart.service.protobuf.Response.class)
  public  io.rsocket.rpc.BlockingIterable<io.netifi.proteus.quickstart.service.protobuf.Response> statefulChannel(Iterable<io.netifi.proteus.quickstart.service.protobuf.Request> messages) {
    return statefulChannel(messages, io.netty.buffer.Unpooled.EMPTY_BUFFER);
  }

  @java.lang.Override
  @io.rsocket.rpc.annotations.internal.GeneratedMethod(returnTypeClass = io.netifi.proteus.quickstart.service.protobuf.Response.class)
  public  io.rsocket.rpc.BlockingIterable<io.netifi.proteus.quickstart.service.protobuf.Response> statefulChannel(Iterable<io.netifi.proteus.quickstart.service.protobuf.Request> messages, io.netty.buffer.ByteBuf metadata) {
    reactor.core.publisher.Flux stream = delegate.statefulChannel(reactor.core.publisher.Flux.defer(() -> reactor.core.publisher.Flux.fromIterable(messages)), metadata);
    return new  io.rsocket.rpc.BlockingIterable<>(stream, reactor.util.concurrent.Queues.SMALL_BUFFER_SIZE, reactor.util.concurrent.Queues.small());
  }

}

