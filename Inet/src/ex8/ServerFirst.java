package ex8;

import java.io.*;
import java.net.*;

public class ServerFirst {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket clientAccepted = null;
        ObjectInputStream sois = null;
        ObjectOutputStream soos = null;

        try {
            serverSocket = new ServerSocket(25);
            System.out.println("at IP = " + InetAddress.getLocalHost().getHostAddress());
            System.out.println("at port = " + serverSocket.getLocalPort());

            clientAccepted = serverSocket.accept();
            System.out.println("connection established....");
            System.out.println("with IP = " + clientAccepted.getInetAddress());
            System.out.println("at port = " + clientAccepted.getPort());
            sois = new ObjectInputStream(clientAccepted.getInputStream());
            soos = new ObjectOutputStream(clientAccepted.getOutputStream());

            String clientMessageRecieved = (String) sois.readObject();
            while (!clientMessageRecieved.equals("quite")) {
                System.out.println("message recieved:" + clientMessageRecieved);
                clientMessageRecieved = clientMessageRecieved.toUpperCase();
                soos.writeObject(clientMessageRecieved);
                clientMessageRecieved = (String) sois.readObject();
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (sois != null) sois.close();
                if (soos != null) soos.close();
                if (clientAccepted != null) clientAccepted.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
