package Services;

import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import proto.ChatGrpc;
import proto.ChatOuterClass;

import java.io.FileWriter;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;


public class Chat extends ChatGrpc.ChatImplBase {
    private ChatOuterClass.ChatLog currentMessage = ChatOuterClass.ChatLog.newBuilder().build();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("UTC"));
    private HashSet<String> onlineUsers = new HashSet<String>();

    private void logMessage(String log) {

        try {
            String filename = "log.txt";
            FileWriter fw = new FileWriter(filename, true);
            fw.write(log);
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write(ChatOuterClass.ChatLog request, StreamObserver<Empty> responseObserver) {
        currentMessage = ChatOuterClass.ChatLog.newBuilder().setMessage(request.getMessage()).setTime(request.getTime()).setName(request.getName()).setRecipient(request.getRecipient()).build();

        if (request.getRecipient() != "" && onlineUsers.contains(request.getRecipient())) {
            logMessage("[" + formatter.format(Instant.ofEpochSecond(request.getTime().getSeconds(), request.getTime().getNanos()))
                    + "] \"" + request.getName() + "\" whispered to " + request.getRecipient() + ": " + "\"" + request.getMessage() + "\"" + "\n");
        } else {
            logMessage("[" + formatter.format(Instant.ofEpochSecond(request.getTime().getSeconds(), request.getTime().getNanos()))
                    + "] \"" + request.getName() + "\" typed: " + "\"" + request.getMessage() + "\"" + "\n");
        }

        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void subscribe(Empty request, StreamObserver<ChatOuterClass.ChatLog> responseObserver) {
        ChatOuterClass.ChatLog.Builder response = ChatOuterClass.ChatLog.newBuilder().setName(currentMessage.getName()).setMessage(currentMessage.getMessage()).setTime(currentMessage.getTime()).setRecipient(currentMessage.getRecipient());
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void logIn(ChatOuterClass.User request, StreamObserver<Empty> responseObserver) {
        System.out.println("[" + formatter.format(Instant.now()) + "] \"" + request.getName() + "\" logged in");
        logMessage("[" + formatter.format(Instant.now()) + "] \"" + request.getName() + "\" logged in\n");

        if (onlineUsers.contains(request.getName())) {
            Status status = Status.INVALID_ARGUMENT.withDescription("Username already taken! Choose another one.");
            responseObserver.onError(status.asRuntimeException());
        }
        onlineUsers.add(request.getName());

        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void logOut(ChatOuterClass.User request, StreamObserver<Empty> responseObserver) {
        System.out.println("[" + formatter.format(Instant.now()) + "] \"" + request.getName() + "\" logged out");
        logMessage("[" + formatter.format(Instant.now()) + "] \"" + request.getName() + "\" logged out\n");

        onlineUsers.remove(request.getName());

        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void online(Empty request, StreamObserver<ChatOuterClass.User> responseObserver) {
        if (onlineUsers.size() == 1) {
            Status status = Status.NOT_FOUND.withDescription("There are no other users online");
            responseObserver.onError(status.asRuntimeException());
        }
        onlineUsers.forEach(user -> responseObserver.onNext(ChatOuterClass.User.newBuilder().setName(user).build()));
        responseObserver.onCompleted();
    }
}
