package ex10;

import java.net.*;
import java.io.*;

public class UDPServer {
    public final static int DEFAULT_PORT = 8001;
    public final String VERSION_CMD = "VERSION";
    public final String QUITE_CMD = "QUITE";
    public final byte[] VERSION = "V2.0".getBytes();
    public final byte[] UNKNOWN_CMD = "Unknown command".getBytes();

    public void runServer() throws IOException {
        try (DatagramSocket datagramSocket = new DatagramSocket(DEFAULT_PORT)) {
            boolean stopFlag = false;
            System.out.println("UDPServer: Started on " + InetAddress.getLocalHost().getHostAddress() + " : " + datagramSocket.getLocalPort());
            while (!stopFlag) {
                byte[] buf = new byte[512];
                DatagramPacket recvPacket = new DatagramPacket(buf, buf.length);
                datagramSocket.receive(recvPacket);
                String cmd = new String(recvPacket.getData()).trim(); //метод trim возвращает копию строки с пропущенными начальными и конечными пробелами (т.е. удаляет пробелы в начале и конце строки)
                System.out.println("UDPServer: Command: " + cmd);
                DatagramPacket sendPacket = new DatagramPacket(buf, 0, recvPacket.getAddress(), recvPacket.getPort());
                int n = 0;//количество байт в ответе
                if (cmd.equals(VERSION_CMD)) {
                    n = VERSION.length;
                    System.arraycopy(VERSION, 0, buf, 0, n);
                } else if (cmd.equals(QUITE_CMD)) {
                    stopFlag = true;//остановка сервера
                } else {
                    n = UNKNOWN_CMD.length;
                    System.arraycopy(UNKNOWN_CMD, 0, buf, 0, n);
                }
                sendPacket.setData(buf);
                sendPacket.setLength(n);
                datagramSocket.send(sendPacket);
            }
            System.out.println("UDPServer: Stopped");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            UDPServer udpSvr = new UDPServer();
            udpSvr.runServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
