package ex10;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public void runClient() throws IOException {
        try (DatagramSocket s = new DatagramSocket()) {
            byte[] buf = new byte[512];
            System.out.println("UDPClient: Started");
            byte[] verCmd = "VERSION".getBytes();
            DatagramPacket sendPacket = new DatagramPacket(verCmd, verCmd.length, InetAddress.getByName("127.0.0.1"), 8001);
            s.send(sendPacket);
            DatagramPacket recvPacket = new DatagramPacket(buf, buf.length);
            s.receive(recvPacket);
            String version = new String(recvPacket.getData()).trim();
            System.out.println("UDPClient: Server Version: " + version);
            byte[] quitCmd = "QUITE".getBytes();
            sendPacket.setData(quitCmd);
            sendPacket.setLength(quitCmd.length);
            s.send(sendPacket); //послать данные серверу
             System.out.println("UDPClient: Ended");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            UDPClient client = new UDPClient();
            client.runClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
