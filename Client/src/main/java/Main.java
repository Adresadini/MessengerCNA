import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import proto.ChatGrpc;
import proto.ChatOuterClass;
import com.google.protobuf.Empty;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.google.protobuf.Timestamp;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void pauseFor(int millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress
                ("localhost", 8999).usePlaintext().build();

        ChatGrpc.ChatStub chatStub = ChatGrpc.newStub(channel);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("UTC"));

        System.out.print("What is your name: ");
        String name = sc.nextLine();

        chatStub.logIn(
                ChatOuterClass.User.newBuilder().setName(name).build(),
                new StreamObserver<Empty>() {
                    @Override
                    public void onNext(Empty empty) {
                        System.out.println("You have successfully logged in!");
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("Error: " + throwable.getMessage());
                        System.exit(-1);
                    }

                    @Override
                    public void onCompleted() {

                    }
                }
        );

        boolean isOpen = true;
        Thread t = new Thread() {
            public void run() {
                final String[] currentMessage = {""};
                while (isOpen) {
                    chatStub.subscribe(
                            Empty.newBuilder().build(),
                            new StreamObserver<ChatOuterClass.ChatLog>() {
                                @Override
                                public void onNext(ChatOuterClass.ChatLog chatLog) {
                                    if (!chatLog.getMessage().equals(currentMessage[0])) {
                                        currentMessage[0] = chatLog.getMessage();
                                        if (!chatLog.getMessage().isEmpty())
                                            System.out.println("[" + formatter.format(Instant.ofEpochSecond(chatLog.getTime().getSeconds(), chatLog.getTime().getNanos()))
                                                    + "] " + chatLog.getName() + ": " + chatLog.getMessage());
                                    }

                                }

                                @Override
                                public void onError(Throwable throwable) {
                                    System.out.println("Error: " + throwable.getMessage());
                                }

                                @Override
                                public void onCompleted() {

                                }
                            }
                    );
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();

        while (isOpen) {

            String message = sc.nextLine();

            Instant time = Instant.now();
            Timestamp currentTime = Timestamp.newBuilder().setSeconds(time.getEpochSecond())
                    .setNanos(time.getNano()).build();

            if (message.charAt(0) == '/')
                switch (message.substring(1)) {
                    case "logout":
                        chatStub.logOut(
                                ChatOuterClass.User.newBuilder().setName(name).build(),
                                new StreamObserver<Empty>() {
                                    @Override
                                    public void onNext(Empty empty) {
                                        System.out.println("You have successfully logged out!");
                                    }

                                    @Override
                                    public void onError(Throwable throwable) {
                                        System.out.println("Error: " + throwable.getMessage());
                                    }

                                    @Override
                                    public void onCompleted() {

                                    }
                                }
                        );
                        pauseFor(10);
                        channel.shutdown();
                        System.exit(0);
                    case "online":
                        System.out.println("List of online users: ");
                        chatStub.online(
                            Empty.newBuilder().build(),
                            new StreamObserver<ChatOuterClass.User>() {
                                @Override
                                public void onNext(ChatOuterClass.User user) {
                                    System.out.println(user.getName());
                                }

                                @Override
                                public void onError(Throwable throwable) {
                                    System.out.println("Error: " + throwable.getMessage());
                                }

                                @Override
                                public void onCompleted() {

                                }
                            }
                    );

                    default:
                        System.out.println("Invalid Command!");
                }

            chatStub.write(
                    ChatOuterClass.ChatLog.newBuilder().setName(name).setMessage(message).setTime(currentTime).build(),
                    new StreamObserver<Empty>() {
                        @Override
                        public void onNext(Empty empty) {
                            System.out.println("Message sent!");
                        }

                        @Override
                        public void onError(Throwable throwable) {
                            System.out.println("Error: " + throwable.getMessage());
                        }

                        @Override
                        public void onCompleted() {

                        }
                    }
            );
        }

        channel.shutdown();
    }
}
