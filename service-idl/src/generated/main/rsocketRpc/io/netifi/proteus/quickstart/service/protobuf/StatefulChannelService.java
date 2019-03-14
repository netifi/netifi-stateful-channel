package io.netifi.proteus.quickstart.service.protobuf;

/**
 */
@javax.annotation.Generated(
    value = "by RSocket RPC proto compiler",
    comments = "Source: io/netifi/proteus/quickstart/service/protobuf/service.proto")
public interface StatefulChannelService {
  String SERVICE = "io.netifi.proteus.quickstart.service.StatefulChannelService";
  String METHOD_STATEFUL_CHANNEL = "StatefulChannel";

  /**
   * <pre>
   * Returns a Hello World Message
   * </pre>
   */
  reactor.core.publisher.Flux<io.netifi.proteus.quickstart.service.protobuf.Response> statefulChannel(org.reactivestreams.Publisher<io.netifi.proteus.quickstart.service.protobuf.Request> messages, io.netty.buffer.ByteBuf metadata);
}
