package ex7;

import java.net.*;
import java.io.*;
import java.util.Date;

public class URLConectionDemo {
    public static void main(String[] args) throws Exception {
        int с;
        URL wikiURL = new URL("https://ru.wikipedia.org");
        URLConnection wikiURLConnnection = wikiURL.openConnection();

        long d = wikiURLConnnection.getDate();
        if (d == 0) {
            System.out.println("Сведения о дате отсутствуют.");
        } else {
            System.out.println("Дaтa:" + new Date(d));
        }

        System.out.println("Тип содержимого:" + wikiURLConnnection.getContentType());
        d = wikiURLConnnection.getExpiration();
        if (d == 0) {
            System.out.println("Сведения о сроке действия отсутствуют.");
        } else {
            System.out.println("Срок действия истекает:" + new Date(d));
        }

        d = wikiURLConnnection.getLastModified();
        if (d == 0) {
            System.out.println("Сведения о дате последней модификации.");
        } else {
            System.out.println("Дата последней модификации:" + new Date(d));
        }

        long len = wikiURLConnnection.getContentLengthLong();
        if (len == -1) {
            System.out.println("Длинa содержимого недоступна.");
        } else {
            System.out.println("Длинa содержимого:" + len + " байт");
        }
        if (len != 0) {
            System.out.println(" ------Содержимое ------");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(wikiURLConnnection.getInputStream(), "UTF-8"));
            while (((с = bufferedReader.read()) != -1)) {
                System.out.print((char) с);
            }
            bufferedReader.close();
        } else {
            System.out.println("Coдepжимoe недоступно.");
        }
    }
}
