import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(3005);
        int count = 0;
        System.out.println("***Server has started!***");
        while (true) {
            count++;
            Socket socket = server.accept();
            System.out.println("Client " + count + " entered.");
            MyThread clientThread = new MyThread(socket, count);
            clientThread.start();
        }
    }
}
