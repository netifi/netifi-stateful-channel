package io.netifi.proteus.quickstart.service.protobuf;

/**
 */
@javax.annotation.Generated(
    value = "by RSocket RPC proto compiler (version 0.2.12)",
    comments = "Source: io/netifi/proteus/quickstart/service/protobuf/service.proto")
public interface BlockingStatefulChannelService {
  String SERVICE_ID = "io.netifi.proteus.quickstart.service.StatefulChannelService";
  String METHOD_STATEFUL_CHANNEL = "StatefulChannel";

  /**
   */
  Iterable<io.netifi.proteus.quickstart.service.protobuf.Response> statefulChannel(Iterable<io.netifi.proteus.quickstart.service.protobuf.Request> messages, io.netty.buffer.ByteBuf metadata);
}
