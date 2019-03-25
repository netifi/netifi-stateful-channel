package io.netifi.proteus.quickstart.service.protobuf;

/**
 */
@javax.annotation.Generated(
    value = "by RSocket RPC proto compiler (version 0.2.12)",
    comments = "Source: io/netifi/proteus/quickstart/service/protobuf/service.proto")
public interface BlockingTransactedChannelService {
  String SERVICE_ID = "io.netifi.proteus.quickstart.service.TransactedChannelService";
  String METHOD_TRANSACTED_CHANNEL = "TransactedChannel";
  String METHOD_READ_TRANSACTED = "ReadTransacted";

  /**
   */
  com.google.protobuf.Empty transactedChannel(Iterable<io.netifi.proteus.quickstart.service.protobuf.TransactedRequest> messages, io.netty.buffer.ByteBuf metadata);

  /**
   */
  io.netifi.proteus.quickstart.service.protobuf.ReadTransactedResponse readTransacted(com.google.protobuf.Empty message, io.netty.buffer.ByteBuf metadata);
}
