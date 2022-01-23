package ex2;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

class InetAddressDemo {
    public static void main(String[] args)  {
        try {
            InetAddress[] allByName = InetAddress.getAllByName("www.youtube.com");
            for (InetAddress inetAddress : allByName) {
                if (inetAddress instanceof Inet4Address) {
                    System.out.println("URN: " +
                            inetAddress.getHostName());
                    System.out.println("URL: " +
                            inetAddress.getHostAddress());
                    System.out.println("equals with www.mail.ru:"
                            + inetAddress.equals("www.mail.ru"));
                    System.out.println("is multicast address:" +
                            inetAddress.isMulticastAddress());
                    System.out.println("method toString:" +
                            inetAddress);
                    System.out.println();
                }
            }
            InetAddress group = InetAddress.getByName("224.0.0.255");
            System.out.println("URN: " + group.getHostName());
            System.out.println("URL: " + group.getHostAddress());
            System.out.println("equals   with   www.mail.ru:" + group.equals("www.mail.ru"));
            System.out.println("is    multicast    address:" + group.isMulticastAddress());
            System.out.println("method toString:" + group);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
