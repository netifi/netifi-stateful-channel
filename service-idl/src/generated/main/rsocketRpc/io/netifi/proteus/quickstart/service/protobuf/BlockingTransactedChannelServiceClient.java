package io.netifi.proteus.quickstart.service.protobuf;

@javax.annotation.Generated(
    value = "by RSocket RPC proto compiler (version 0.2.12)",
    comments = "Source: io/netifi/proteus/quickstart/service/protobuf/service.proto")
@io.rsocket.rpc.annotations.internal.Generated(
    type = io.rsocket.rpc.annotations.internal.ResourceType.CLIENT,
    idlClass = BlockingTransactedChannelService.class)
public final class BlockingTransactedChannelServiceClient implements BlockingTransactedChannelService {
  private final io.netifi.proteus.quickstart.service.protobuf.TransactedChannelServiceClient delegate;

  public BlockingTransactedChannelServiceClient(io.rsocket.RSocket rSocket) {
    this.delegate = new io.netifi.proteus.quickstart.service.protobuf.TransactedChannelServiceClient(rSocket);
  }

  public BlockingTransactedChannelServiceClient(io.rsocket.RSocket rSocket, io.micrometer.core.instrument.MeterRegistry registry) {
    this.delegate = new io.netifi.proteus.quickstart.service.protobuf.TransactedChannelServiceClient(rSocket, registry);
  }

  @io.rsocket.rpc.annotations.internal.GeneratedMethod(returnTypeClass = com.google.protobuf.Empty.class)
  public com.google.protobuf.Empty transactedChannel(Iterable<io.netifi.proteus.quickstart.service.protobuf.TransactedRequest> messages) {
    return transactedChannel(messages, io.netty.buffer.Unpooled.EMPTY_BUFFER);
  }

  @java.lang.Override
  @io.rsocket.rpc.annotations.internal.GeneratedMethod(returnTypeClass = com.google.protobuf.Empty.class)
  public com.google.protobuf.Empty transactedChannel(Iterable<io.netifi.proteus.quickstart.service.protobuf.TransactedRequest> messages, io.netty.buffer.ByteBuf metadata) {
    return delegate.transactedChannel(reactor.core.publisher.Flux.defer(() -> reactor.core.publisher.Flux.fromIterable(messages)), metadata).block();
  }

  @io.rsocket.rpc.annotations.internal.GeneratedMethod(returnTypeClass = io.netifi.proteus.quickstart.service.protobuf.ReadTransactedResponse.class)
  public io.netifi.proteus.quickstart.service.protobuf.ReadTransactedResponse readTransacted(com.google.protobuf.Empty message) {
    return readTransacted(message, io.netty.buffer.Unpooled.EMPTY_BUFFER);
  }

  @java.lang.Override
  @io.rsocket.rpc.annotations.internal.GeneratedMethod(returnTypeClass = io.netifi.proteus.quickstart.service.protobuf.ReadTransactedResponse.class)
  public io.netifi.proteus.quickstart.service.protobuf.ReadTransactedResponse readTransacted(com.google.protobuf.Empty message, io.netty.buffer.ByteBuf metadata) {
    return delegate.readTransacted(message, metadata).block();
  }

}

