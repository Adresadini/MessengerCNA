import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import proto.ChatGrpc;
import proto.ChatOuterClass;
import com.google.protobuf.Empty;
import java.util.Scanner;

public class Main
{

    public static void displayOptions()
    {
        System.out.println("1) Login");
        System.out.println("2) Write a message");
        System.out.println("3) Refresh to see if you have any messages");
        System.out.println("0) Exit");
    }

    public static void main(String[] args)
    {
        ManagedChannel channel = ManagedChannelBuilder.forAddress
                ("localhost", 8999).usePlaintext().build();

        ChatGrpc.ChatStub chatStub = ChatGrpc.newStub(channel);

        displayOptions();

        int option = -1;
        while (option != 0)
        {

            System.out.print("Choose an option: ");
            Scanner sc = new Scanner(System.in);
            option = sc.nextInt();

            switch (option)
            {
                case 1:
                    Scanner read = new Scanner(System.in);
                    System.out.print("Select a name: ");
                    String nume = read.nextLine();
                    System.out.print("Introduceti CNP: ");
                    String CNP = read.nextLine();

                    chatStub.logIn(
                            ChatOuterClass.User.newBuilder().setName(nume),
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
                    break;
            }
        }
    }
}
