package Services;

import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;

public class Chat extends ChatGrpc.ChatImplBase{
    ChatOuterClass.ChatLog currentMessage;
    @Override
    public void write(ChatOuterClass.ChatLog request, StreamObserver<Empty> responseObserver) {
        currentMessage=request;
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void subscribe(Empty request, StreamObserver<ChatOuterClass.ChatLog> responseObserver) {
        super.subscribe(request, responseObserver);
    }
}