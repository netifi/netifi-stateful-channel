package io.netifi.proteus.quickstart.service.protobuf;

/**
 */
@javax.annotation.Generated(
    value = "by RSocket RPC proto compiler",
    comments = "Source: io/netifi/proteus/quickstart/service/protobuf/service.proto")
public interface TransactedChannelService {
  String SERVICE = "io.netifi.proteus.quickstart.service.TransactedChannelService";
  String METHOD_TRANSACTED_CHANNEL = "TransactedChannel";
  String METHOD_READ_TRANSACTED = "ReadTransacted";

  /**
   */
  reactor.core.publisher.Mono<com.google.protobuf.Empty> transactedChannel(org.reactivestreams.Publisher<io.netifi.proteus.quickstart.service.protobuf.TransactedRequest> messages, io.netty.buffer.ByteBuf metadata);

  /**
   */
  reactor.core.publisher.Mono<io.netifi.proteus.quickstart.service.protobuf.ReadTransactedResponse> readTransacted(com.google.protobuf.Empty message, io.netty.buffer.ByteBuf metadata);
}
