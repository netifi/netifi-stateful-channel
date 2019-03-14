package io.netifi.proteus.quickstart.service.protobuf;

@javax.annotation.Generated(
    value = "by RSocket RPC proto compiler",
    comments = "Source: io/netifi/proteus/quickstart/service/protobuf/service.proto")
@io.rsocket.rpc.annotations.internal.Generated(
    type = io.rsocket.rpc.annotations.internal.ResourceType.CLIENT,
    idlClass = StatefulChannelService.class)
public final class StatefulChannelServiceClient implements StatefulChannelService {
  private final io.rsocket.RSocket rSocket;
  private final java.util.function.Function<? super org.reactivestreams.Publisher<io.netifi.proteus.quickstart.service.protobuf.Response>, ? extends org.reactivestreams.Publisher<io.netifi.proteus.quickstart.service.protobuf.Response>> statefulChannel;
  private final java.util.function.Function<java.util.Map<String, String>, java.util.function.Function<? super org.reactivestreams.Publisher<io.netifi.proteus.quickstart.service.protobuf.Response>, ? extends org.reactivestreams.Publisher<io.netifi.proteus.quickstart.service.protobuf.Response>>> statefulChannelTrace;

  public StatefulChannelServiceClient(io.rsocket.RSocket rSocket) {
    this.rSocket = rSocket;
    this.statefulChannel = java.util.function.Function.identity();
    this.statefulChannelTrace = io.rsocket.rpc.tracing.Tracing.trace();
  }

  public StatefulChannelServiceClient(io.rsocket.RSocket rSocket, io.micrometer.core.instrument.MeterRegistry registry) {
    this.rSocket = rSocket;
    this.statefulChannel = io.rsocket.rpc.metrics.Metrics.timed(registry, "rsocket.client", "service", StatefulChannelService.SERVICE, "method", StatefulChannelService.METHOD_STATEFUL_CHANNEL);
    this.statefulChannelTrace = io.rsocket.rpc.tracing.Tracing.trace();
  }


  public StatefulChannelServiceClient(io.rsocket.RSocket rSocket, io.opentracing.Tracer tracer) {
    this.rSocket = rSocket;
    this.statefulChannel = java.util.function.Function.identity();
    this.statefulChannelTrace = io.rsocket.rpc.tracing.Tracing.trace(tracer, StatefulChannelService.METHOD_STATEFUL_CHANNEL, io.rsocket.rpc.tracing.Tag.of("rsocket.service", StatefulChannelService.SERVICE), io.rsocket.rpc.tracing.Tag.of("rsocket.rpc.role", "client"), io.rsocket.rpc.tracing.Tag.of("rsocket.rpc.version", ""));
  }


  public StatefulChannelServiceClient(io.rsocket.RSocket rSocket, io.micrometer.core.instrument.MeterRegistry registry, io.opentracing.Tracer tracer) {
    this.rSocket = rSocket;
    this.statefulChannel = io.rsocket.rpc.metrics.Metrics.timed(registry, "rsocket.client", "service", StatefulChannelService.SERVICE, "method", StatefulChannelService.METHOD_STATEFUL_CHANNEL);
    this.statefulChannelTrace = io.rsocket.rpc.tracing.Tracing.trace(tracer, StatefulChannelService.METHOD_STATEFUL_CHANNEL, io.rsocket.rpc.tracing.Tag.of("rsocket.service", StatefulChannelService.SERVICE), io.rsocket.rpc.tracing.Tag.of("rsocket.rpc.role", "client"), io.rsocket.rpc.tracing.Tag.of("rsocket.rpc.version", ""));
  }

  @io.rsocket.rpc.annotations.internal.GeneratedMethod(returnTypeClass = io.netifi.proteus.quickstart.service.protobuf.Response.class)
  public reactor.core.publisher.Flux<io.netifi.proteus.quickstart.service.protobuf.Response> statefulChannel(org.reactivestreams.Publisher<io.netifi.proteus.quickstart.service.protobuf.Request> messages) {
    return statefulChannel(messages, io.netty.buffer.Unpooled.EMPTY_BUFFER);
  }

  @java.lang.Override
  @io.rsocket.rpc.annotations.internal.GeneratedMethod(returnTypeClass = io.netifi.proteus.quickstart.service.protobuf.Response.class)
  public reactor.core.publisher.Flux<io.netifi.proteus.quickstart.service.protobuf.Response> statefulChannel(org.reactivestreams.Publisher<io.netifi.proteus.quickstart.service.protobuf.Request> messages, io.netty.buffer.ByteBuf metadata) {
  java.util.Map<String, String> map = new java.util.HashMap<>();
    return rSocket.requestChannel(reactor.core.publisher.Flux.from(messages).map(
      new java.util.function.Function<com.google.protobuf.MessageLite, io.rsocket.Payload>() {
        private final java.util.concurrent.atomic.AtomicBoolean once = new java.util.concurrent.atomic.AtomicBoolean(false);

        @java.lang.Override
        public io.rsocket.Payload apply(com.google.protobuf.MessageLite message) {
          io.netty.buffer.ByteBuf data = serialize(message);
          if (once.compareAndSet(false, true)) {
            final io.netty.buffer.ByteBuf metadataBuf = io.rsocket.rpc.frames.Metadata.encode(io.netty.buffer.ByteBufAllocator.DEFAULT, StatefulChannelService.SERVICE, StatefulChannelService.METHOD_STATEFUL_CHANNEL, metadata);
            return io.rsocket.util.ByteBufPayload.create(data, metadataBuf);
          } else {
            return io.rsocket.util.ByteBufPayload.create(data);
          }
        }
      })).map(deserializer(io.netifi.proteus.quickstart.service.protobuf.Response.parser())).transform(statefulChannel).transform(statefulChannelTrace.apply(map));
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
