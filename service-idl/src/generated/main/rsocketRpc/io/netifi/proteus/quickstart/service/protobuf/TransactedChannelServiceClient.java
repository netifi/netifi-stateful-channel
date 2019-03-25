package io.netifi.proteus.quickstart.service.protobuf;

@javax.annotation.Generated(
    value = "by RSocket RPC proto compiler",
    comments = "Source: io/netifi/proteus/quickstart/service/protobuf/service.proto")
@io.rsocket.rpc.annotations.internal.Generated(
    type = io.rsocket.rpc.annotations.internal.ResourceType.CLIENT,
    idlClass = TransactedChannelService.class)
public final class TransactedChannelServiceClient implements TransactedChannelService {
  private final io.rsocket.RSocket rSocket;
  private final java.util.function.Function<? super org.reactivestreams.Publisher<com.google.protobuf.Empty>, ? extends org.reactivestreams.Publisher<com.google.protobuf.Empty>> transactedChannel;
  private final java.util.function.Function<? super org.reactivestreams.Publisher<io.netifi.proteus.quickstart.service.protobuf.ReadTransactedResponse>, ? extends org.reactivestreams.Publisher<io.netifi.proteus.quickstart.service.protobuf.ReadTransactedResponse>> readTransacted;
  private final java.util.function.Function<java.util.Map<String, String>, java.util.function.Function<? super org.reactivestreams.Publisher<com.google.protobuf.Empty>, ? extends org.reactivestreams.Publisher<com.google.protobuf.Empty>>> transactedChannelTrace;
  private final java.util.function.Function<java.util.Map<String, String>, java.util.function.Function<? super org.reactivestreams.Publisher<io.netifi.proteus.quickstart.service.protobuf.ReadTransactedResponse>, ? extends org.reactivestreams.Publisher<io.netifi.proteus.quickstart.service.protobuf.ReadTransactedResponse>>> readTransactedTrace;

  public TransactedChannelServiceClient(io.rsocket.RSocket rSocket) {
    this.rSocket = rSocket;
    this.transactedChannel = java.util.function.Function.identity();
    this.readTransacted = java.util.function.Function.identity();
    this.transactedChannelTrace = io.rsocket.rpc.tracing.Tracing.trace();
    this.readTransactedTrace = io.rsocket.rpc.tracing.Tracing.trace();
  }

  public TransactedChannelServiceClient(io.rsocket.RSocket rSocket, io.micrometer.core.instrument.MeterRegistry registry) {
    this.rSocket = rSocket;
    this.transactedChannel = io.rsocket.rpc.metrics.Metrics.timed(registry, "rsocket.client", "service", TransactedChannelService.SERVICE, "method", TransactedChannelService.METHOD_TRANSACTED_CHANNEL);
    this.readTransacted = io.rsocket.rpc.metrics.Metrics.timed(registry, "rsocket.client", "service", TransactedChannelService.SERVICE, "method", TransactedChannelService.METHOD_READ_TRANSACTED);
    this.transactedChannelTrace = io.rsocket.rpc.tracing.Tracing.trace();
    this.readTransactedTrace = io.rsocket.rpc.tracing.Tracing.trace();
  }


  public TransactedChannelServiceClient(io.rsocket.RSocket rSocket, io.opentracing.Tracer tracer) {
    this.rSocket = rSocket;
    this.transactedChannel = java.util.function.Function.identity();
    this.readTransacted = java.util.function.Function.identity();
    this.transactedChannelTrace = io.rsocket.rpc.tracing.Tracing.trace(tracer, TransactedChannelService.METHOD_TRANSACTED_CHANNEL, io.rsocket.rpc.tracing.Tag.of("rsocket.service", TransactedChannelService.SERVICE), io.rsocket.rpc.tracing.Tag.of("rsocket.rpc.role", "client"), io.rsocket.rpc.tracing.Tag.of("rsocket.rpc.version", ""));
    this.readTransactedTrace = io.rsocket.rpc.tracing.Tracing.trace(tracer, TransactedChannelService.METHOD_READ_TRANSACTED, io.rsocket.rpc.tracing.Tag.of("rsocket.service", TransactedChannelService.SERVICE), io.rsocket.rpc.tracing.Tag.of("rsocket.rpc.role", "client"), io.rsocket.rpc.tracing.Tag.of("rsocket.rpc.version", ""));
  }


  public TransactedChannelServiceClient(io.rsocket.RSocket rSocket, io.micrometer.core.instrument.MeterRegistry registry, io.opentracing.Tracer tracer) {
    this.rSocket = rSocket;
    this.transactedChannel = io.rsocket.rpc.metrics.Metrics.timed(registry, "rsocket.client", "service", TransactedChannelService.SERVICE, "method", TransactedChannelService.METHOD_TRANSACTED_CHANNEL);
    this.readTransacted = io.rsocket.rpc.metrics.Metrics.timed(registry, "rsocket.client", "service", TransactedChannelService.SERVICE, "method", TransactedChannelService.METHOD_READ_TRANSACTED);
    this.transactedChannelTrace = io.rsocket.rpc.tracing.Tracing.trace(tracer, TransactedChannelService.METHOD_TRANSACTED_CHANNEL, io.rsocket.rpc.tracing.Tag.of("rsocket.service", TransactedChannelService.SERVICE), io.rsocket.rpc.tracing.Tag.of("rsocket.rpc.role", "client"), io.rsocket.rpc.tracing.Tag.of("rsocket.rpc.version", ""));
    this.readTransactedTrace = io.rsocket.rpc.tracing.Tracing.trace(tracer, TransactedChannelService.METHOD_READ_TRANSACTED, io.rsocket.rpc.tracing.Tag.of("rsocket.service", TransactedChannelService.SERVICE), io.rsocket.rpc.tracing.Tag.of("rsocket.rpc.role", "client"), io.rsocket.rpc.tracing.Tag.of("rsocket.rpc.version", ""));
  }

  @io.rsocket.rpc.annotations.internal.GeneratedMethod(returnTypeClass = com.google.protobuf.Empty.class)
  public reactor.core.publisher.Mono<com.google.protobuf.Empty> transactedChannel(org.reactivestreams.Publisher<io.netifi.proteus.quickstart.service.protobuf.TransactedRequest> messages) {
    return transactedChannel(messages, io.netty.buffer.Unpooled.EMPTY_BUFFER);
  }

  @java.lang.Override
  @io.rsocket.rpc.annotations.internal.GeneratedMethod(returnTypeClass = com.google.protobuf.Empty.class)
  public reactor.core.publisher.Mono<com.google.protobuf.Empty> transactedChannel(org.reactivestreams.Publisher<io.netifi.proteus.quickstart.service.protobuf.TransactedRequest> messages, io.netty.buffer.ByteBuf metadata) {
  java.util.Map<String, String> map = new java.util.HashMap<>();
    return rSocket.requestChannel(reactor.core.publisher.Flux.from(messages).map(
      new java.util.function.Function<com.google.protobuf.MessageLite, io.rsocket.Payload>() {
        private final java.util.concurrent.atomic.AtomicBoolean once = new java.util.concurrent.atomic.AtomicBoolean(false);

        @java.lang.Override
        public io.rsocket.Payload apply(com.google.protobuf.MessageLite message) {
          io.netty.buffer.ByteBuf data = serialize(message);
          if (once.compareAndSet(false, true)) {
            final io.netty.buffer.ByteBuf metadataBuf = io.rsocket.rpc.frames.Metadata.encode(io.netty.buffer.ByteBufAllocator.DEFAULT, TransactedChannelService.SERVICE, TransactedChannelService.METHOD_TRANSACTED_CHANNEL, metadata);
            return io.rsocket.util.ByteBufPayload.create(data, metadataBuf);
          } else {
            return io.rsocket.util.ByteBufPayload.create(data);
          }
        }
      })).map(deserializer(com.google.protobuf.Empty.parser())).single().transform(transactedChannel).transform(transactedChannelTrace.apply(map));
  }

  @io.rsocket.rpc.annotations.internal.GeneratedMethod(returnTypeClass = io.netifi.proteus.quickstart.service.protobuf.ReadTransactedResponse.class)
  public reactor.core.publisher.Mono<io.netifi.proteus.quickstart.service.protobuf.ReadTransactedResponse> readTransacted(com.google.protobuf.Empty message) {
    return readTransacted(message, io.netty.buffer.Unpooled.EMPTY_BUFFER);
  }

  @java.lang.Override
  @io.rsocket.rpc.annotations.internal.GeneratedMethod(returnTypeClass = io.netifi.proteus.quickstart.service.protobuf.ReadTransactedResponse.class)
  public reactor.core.publisher.Mono<io.netifi.proteus.quickstart.service.protobuf.ReadTransactedResponse> readTransacted(com.google.protobuf.Empty message, io.netty.buffer.ByteBuf metadata) {
  java.util.Map<String, String> map = new java.util.HashMap<>();
    return reactor.core.publisher.Mono.defer(new java.util.function.Supplier<reactor.core.publisher.Mono<io.rsocket.Payload>>() {
      @java.lang.Override
      public reactor.core.publisher.Mono<io.rsocket.Payload> get() {
        final io.netty.buffer.ByteBuf data = serialize(message);
        final io.netty.buffer.ByteBuf tracing = io.rsocket.rpc.tracing.Tracing.mapToByteBuf(io.netty.buffer.ByteBufAllocator.DEFAULT, map);
        final io.netty.buffer.ByteBuf metadataBuf = io.rsocket.rpc.frames.Metadata.encode(io.netty.buffer.ByteBufAllocator.DEFAULT, TransactedChannelService.SERVICE, TransactedChannelService.METHOD_READ_TRANSACTED, tracing, metadata);
        tracing.release();
        metadata.release();
        return rSocket.requestResponse(io.rsocket.util.ByteBufPayload.create(data, metadataBuf));
      }
    }).map(deserializer(io.netifi.proteus.quickstart.service.protobuf.ReadTransactedResponse.parser())).transform(readTransacted).transform(readTransactedTrace.apply(map));
  }

  private static io.netty.buffer.ByteBuf serialize(final com.google.protobuf.MessageLite message) {
    int length = message.getSerializedSize();
    io.netty.buffer.ByteBuf byteBuf = io.netty.buffer.ByteBufAllocator.DEFAULT.buffer(length);
    try {
      message.writeTo(com.google.protobuf.CodedOutputStream.newInstance(byteBuf.internalNioBuffer(0, length)));
      byteBuf.writerIndex(length);
      return byteBuf;
    } catch (Throwable t) {
      byteBuf.release();
      throw new RuntimeException(t);
    }
  }

  private static <T> java.util.function.Function<io.rsocket.Payload, T> deserializer(final com.google.protobuf.Parser<T> parser) {
    return new java.util.function.Function<io.rsocket.Payload, T>() {
      @java.lang.Override
      public T apply(io.rsocket.Payload payload) {
        try {
          com.google.protobuf.CodedInputStream is = com.google.protobuf.CodedInputStream.newInstance(payload.getData());
          return parser.parseFrom(is);
        } catch (Throwable t) {
          throw new RuntimeException(t);
        } finally {
          payload.release();
        }
      }
    };
  }
}
