import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: chat.proto")
public final class ChatGrpc {

  private ChatGrpc() {}

  public static final String SERVICE_NAME = "Chat";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ChatOuterClass.ChatLog,
      com.google.protobuf.Empty> getWriteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Write",
      requestType = ChatOuterClass.ChatLog.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ChatOuterClass.ChatLog,
      com.google.protobuf.Empty> getWriteMethod() {
    io.grpc.MethodDescriptor<ChatOuterClass.ChatLog, com.google.protobuf.Empty> getWriteMethod;
    if ((getWriteMethod = ChatGrpc.getWriteMethod) == null) {
      synchronized (ChatGrpc.class) {
        if ((getWriteMethod = ChatGrpc.getWriteMethod) == null) {
          ChatGrpc.getWriteMethod = getWriteMethod = 
              io.grpc.MethodDescriptor.<ChatOuterClass.ChatLog, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Chat", "Write"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ChatOuterClass.ChatLog.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new ChatMethodDescriptorSupplier("Write"))
                  .build();
          }
        }
     }
     return getWriteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      ChatOuterClass.ChatLog> getSubscribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Subscribe",
      requestType = com.google.protobuf.Empty.class,
      responseType = ChatOuterClass.ChatLog.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      ChatOuterClass.ChatLog> getSubscribeMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, ChatOuterClass.ChatLog> getSubscribeMethod;
    if ((getSubscribeMethod = ChatGrpc.getSubscribeMethod) == null) {
      synchronized (ChatGrpc.class) {
        if ((getSubscribeMethod = ChatGrpc.getSubscribeMethod) == null) {
          ChatGrpc.getSubscribeMethod = getSubscribeMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, ChatOuterClass.ChatLog>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Chat", "Subscribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ChatOuterClass.ChatLog.getDefaultInstance()))
                  .setSchemaDescriptor(new ChatMethodDescriptorSupplier("Subscribe"))
                  .build();
          }
        }
     }
     return getSubscribeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ChatOuterClass.User,
      com.google.protobuf.Empty> getLogInMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LogIn",
      requestType = ChatOuterClass.User.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ChatOuterClass.User,
      com.google.protobuf.Empty> getLogInMethod() {
    io.grpc.MethodDescriptor<ChatOuterClass.User, com.google.protobuf.Empty> getLogInMethod;
    if ((getLogInMethod = ChatGrpc.getLogInMethod) == null) {
      synchronized (ChatGrpc.class) {
        if ((getLogInMethod = ChatGrpc.getLogInMethod) == null) {
          ChatGrpc.getLogInMethod = getLogInMethod = 
              io.grpc.MethodDescriptor.<ChatOuterClass.User, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Chat", "LogIn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ChatOuterClass.User.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new ChatMethodDescriptorSupplier("LogIn"))
                  .build();
          }
        }
     }
     return getLogInMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ChatOuterClass.User,
      com.google.protobuf.Empty> getLogOutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LogOut",
      requestType = ChatOuterClass.User.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ChatOuterClass.User,
      com.google.protobuf.Empty> getLogOutMethod() {
    io.grpc.MethodDescriptor<ChatOuterClass.User, com.google.protobuf.Empty> getLogOutMethod;
    if ((getLogOutMethod = ChatGrpc.getLogOutMethod) == null) {
      synchronized (ChatGrpc.class) {
        if ((getLogOutMethod = ChatGrpc.getLogOutMethod) == null) {
          ChatGrpc.getLogOutMethod = getLogOutMethod = 
              io.grpc.MethodDescriptor.<ChatOuterClass.User, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Chat", "LogOut"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ChatOuterClass.User.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new ChatMethodDescriptorSupplier("LogOut"))
                  .build();
          }
        }
     }
     return getLogOutMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ChatStub newStub(io.grpc.Channel channel) {
    return new ChatStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ChatBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ChatBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ChatFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ChatFutureStub(channel);
  }

  /**
   */
  public static abstract class ChatImplBase implements io.grpc.BindableService {

    /**
     */
    public void write(ChatOuterClass.ChatLog request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteMethod(), responseObserver);
    }

    /**
     */
    public void subscribe(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<ChatOuterClass.ChatLog> responseObserver) {
      asyncUnimplementedUnaryCall(getSubscribeMethod(), responseObserver);
    }

    /**
     */
    public void logIn(ChatOuterClass.User request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getLogInMethod(), responseObserver);
    }

    /**
     */
    public void logOut(ChatOuterClass.User request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getLogOutMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getWriteMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ChatOuterClass.ChatLog,
                com.google.protobuf.Empty>(
                  this, METHODID_WRITE)))
          .addMethod(
            getSubscribeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                ChatOuterClass.ChatLog>(
                  this, METHODID_SUBSCRIBE)))
          .addMethod(
            getLogInMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ChatOuterClass.User,
                com.google.protobuf.Empty>(
                  this, METHODID_LOG_IN)))
          .addMethod(
            getLogOutMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ChatOuterClass.User,
                com.google.protobuf.Empty>(
                  this, METHODID_LOG_OUT)))
          .build();
    }
  }

  /**
   */
  public static final class ChatStub extends io.grpc.stub.AbstractStub<ChatStub> {
    private ChatStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatStub(channel, callOptions);
    }

    /**
     */
    public void write(ChatOuterClass.ChatLog request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void subscribe(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<ChatOuterClass.ChatLog> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSubscribeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void logIn(ChatOuterClass.User request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLogInMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void logOut(ChatOuterClass.User request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLogOutMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ChatBlockingStub extends io.grpc.stub.AbstractStub<ChatBlockingStub> {
    private ChatBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.Empty write(ChatOuterClass.ChatLog request) {
      return blockingUnaryCall(
          getChannel(), getWriteMethod(), getCallOptions(), request);
    }

    /**
     */
    public ChatOuterClass.ChatLog subscribe(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getSubscribeMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty logIn(ChatOuterClass.User request) {
      return blockingUnaryCall(
          getChannel(), getLogInMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty logOut(ChatOuterClass.User request) {
      return blockingUnaryCall(
          getChannel(), getLogOutMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ChatFutureStub extends io.grpc.stub.AbstractStub<ChatFutureStub> {
    private ChatFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> write(
        ChatOuterClass.ChatLog request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ChatOuterClass.ChatLog> subscribe(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getSubscribeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> logIn(
        ChatOuterClass.User request) {
      return futureUnaryCall(
          getChannel().newCall(getLogInMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> logOut(
        ChatOuterClass.User request) {
      return futureUnaryCall(
          getChannel().newCall(getLogOutMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_WRITE = 0;
  private static final int METHODID_SUBSCRIBE = 1;
  private static final int METHODID_LOG_IN = 2;
  private static final int METHODID_LOG_OUT = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ChatImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ChatImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_WRITE:
          serviceImpl.write((ChatOuterClass.ChatLog) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_SUBSCRIBE:
          serviceImpl.subscribe((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<ChatOuterClass.ChatLog>) responseObserver);
          break;
        case METHODID_LOG_IN:
          serviceImpl.logIn((ChatOuterClass.User) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LOG_OUT:
          serviceImpl.logOut((ChatOuterClass.User) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ChatBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ChatBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ChatOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Chat");
    }
  }

  private static final class ChatFileDescriptorSupplier
      extends ChatBaseDescriptorSupplier {
    ChatFileDescriptorSupplier() {}
  }

  private static final class ChatMethodDescriptorSupplier
      extends ChatBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ChatMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ChatGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ChatFileDescriptorSupplier())
              .addMethod(getWriteMethod())
              .addMethod(getSubscribeMethod())
              .addMethod(getLogInMethod())
              .addMethod(getLogOutMethod())
              .build();
        }
      }
    }
    return result;
  }
}
