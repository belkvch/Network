package ex8;

import java.io.*;
import java.net.*;

public class ClientFirst {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (Socket clientSocket = new Socket("127.0.0.1", 25)) {
            System.out.println("connection established....");
            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
            ObjectOutputStream coos = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream cois = new ObjectInputStream(clientSocket.getInputStream());
            System.out.println("Enter string to send to server \n\t('quite' − programme terminate)");
            String clientMessage = stdin.readLine();
            System.out.println("you've entered: " + clientMessage);
            while (!clientMessage.equals("quite")) {
                coos.writeObject(clientMessage);
                System.out.println("~server~: " + cois.readObject());
                System.out.println("---------------------------");
                clientMessage = stdin.readLine();
                System.out.println("you've entered: " + clientMessage);
            }
        }

    }
}
