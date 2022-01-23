package ex9;

import java.io.IOException;
import java.net.*;

public class MultiThreadServerMain {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8071, 10, InetAddress.getLocalHost());
            System.out.println("initialized: " + server.getInetAddress() + "," + server.getLocalPort());
            while (true) {
                Socket socket = server.accept();
                System.out.println(socket.getInetAddress() + " connected" + "," + socket.getPort());
                ServerThread thread = new ServerThread(socket);
                thread.start();// запуск потока
                System.out.println(socket.getInetAddress() + " No " + ServerThread.getCounter() + " started");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
