package ex1;

import java.net.*;

class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);
        address = InetAddress.getByName("www.gmail.com");
        System.out.println(address);
        InetAddress addressSecond = InetAddress.getByName("www.youtube.com");
        System.out.println(addressSecond);
        System.out.println();

        InetAddress[] addressArraySec = InetAddress.getAllByName("www.youtube.com");
        for (InetAddress value : addressArraySec) System.out.println(value);

        InetAddress[] addressArrayMailRu = InetAddress.getAllByName("www.mail.ru");
        for (InetAddress inetAddress : addressArrayMailRu)
            System.out.println(inetAddress);
    }
}
