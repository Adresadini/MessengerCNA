import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import proto.ChatGrpc;
import proto.ChatOuterClass;
import com.google.protobuf.Empty;

import java.time.Instant;
import java.util.Scanner;

import com.google.protobuf.Timestamp;

public class Main
{
    public static Scanner sc = new Scanner(System.in);


    public static void main(String[] args)
    {
        ManagedChannel channel = ManagedChannelBuilder.forAddress
                ("localhost", 8999).usePlaintext().build();

        ChatGrpc.ChatStub chatStub = ChatGrpc.newStub(channel);

        Thread t = new Thread()
        {
            public void run()
            {
                while (true)
                {
                    chatStub.subscribe(
                            Empty.newBuilder().build(),
                            new StreamObserver<ChatOuterClass.ChatLog>()
                            {
                                @Override
                                public void onNext(ChatOuterClass.ChatLog chatLog)
                                {
                                    if (chatLog.getMessage() != null)
                                        System.out.println(chatLog.getName() + ": " + chatLog.getMessage());
                                }

                                @Override
                                public void onError(Throwable throwable)
                                {
                                    System.out.println("Error: " + throwable.getMessage());
                                }

                                @Override
                                public void onCompleted()
                                {
                                }
                            }
                    );
                }
            }
        };
        t.start();


        System.out.print("Select a name: ");
        String name = sc.nextLine();
        chatStub.logIn(
                ChatOuterClass.User.newBuilder().setName(name).build(),
                new StreamObserver<Empty>()
                {
                    @Override
                    public void onNext(Empty empty)
                    {
                        System.out.println("You have successfully logged in!");
                    }

                    @Override
                    public void onError(Throwable throwable)
                    {
                        System.out.println("Error: " + throwable.getMessage());
                    }

                    @Override
                    public void onCompleted()
                    {

                    }
                }
        );

        System.out.print("Message: ");
        String message = sc.nextLine();


        Instant time = Instant.now();
        Timestamp currentTime = Timestamp.newBuilder().setSeconds(time.getEpochSecond())
                .setNanos(time.getNano()).build();


        chatStub.write(
                ChatOuterClass.ChatLog.newBuilder().setName(name).setMessage(message).setTime(currentTime).build(),
                new StreamObserver<Empty>()
                {
                    @Override
                    public void onNext(Empty empty)
                    {
                        System.out.println("You have successfully logged in!");
                    }

                    @Override
                    public void onError(Throwable throwable)
                    {
                        System.out.println("Error: " + throwable.getMessage());
                    }

                    @Override
                    public void onCompleted()
                    {

                    }
                }
        );


        channel.shutdown();
    }
}
