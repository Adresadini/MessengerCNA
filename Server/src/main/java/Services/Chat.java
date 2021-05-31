package Services;

import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import proto.ChatGrpc;
import proto.ChatOuterClass;


public class Chat extends ChatGrpc.ChatImplBase
{
    ChatOuterClass.ChatLog currentMessage = ChatOuterClass.ChatLog.newBuilder().build();

    @Override
    public void write(ChatOuterClass.ChatLog request, StreamObserver<Empty> responseObserver)
    {
        currentMessage = request;
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void subscribe(Empty request, StreamObserver<ChatOuterClass.ChatLog> responseObserver)
    {
        ChatOuterClass.ChatLog.Builder response = ChatOuterClass.ChatLog.newBuilder().setName(currentMessage.getName()).setMessage(currentMessage.getMessage()).setTime(currentMessage.getTime());
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
        System.out.println(response.getMessage());

    }

    @Override
    public void logIn(ChatOuterClass.User request, StreamObserver<Empty> responseObserver)
    {
        System.out.println(request.getName() + " logged in");
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }
}
