package ex5;

import java.net.*;

public class URLDemo {
    public static void main(String[] args) throws MalformedURLException {
        URL wikiURL = new URL("https://ru.wikipedia.org/wiki");
        System.out.println("Пpoтoкoл:" + wikiURL.getProtocol());
        System.out.println("Пopт:" + wikiURL.getPort());
        System.out.println("Xocт:" + wikiURL.getHost());
        System.out.println("Фaйл:" + wikiURL.getFile());
        System.out.println("Пoлнaя форма:" + wikiURL.toExternalForm());
    }
}
