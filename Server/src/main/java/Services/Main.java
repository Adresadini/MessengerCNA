package Services;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        try {

            Server server = ServerBuilder.forPort(8999).addService(new Chat()).build();

            server.start();

            System.out.println("Server started at " + server.getPort());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("UTC"));

            try {
                String filename = "log.txt";
                FileWriter fw = new FileWriter(filename, true);
                fw.write("[" + formatter.format(Instant.now()) + "] SERVER STARTED\n");
                fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            server.awaitTermination();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e);
        }
    }
}
