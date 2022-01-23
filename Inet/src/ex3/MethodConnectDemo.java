package ex3;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

class MethodConnectDemo {
    public static void main(String[] args) throws Exception {
        InetAddress addr = InetAddress.getByName("java.sun.com");
        int port = 80;
        SocketAddress socketAddress = new InetSocketAddress(addr, port);
        Socket sock = new Socket();
        sock.connect(socketAddress);
        System.out.println("Соединение done? " + sock.isConnected());
    }
}
