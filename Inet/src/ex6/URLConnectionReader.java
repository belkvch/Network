package ex6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class URLConnectionReader {
    public static void main(String[] args) throws Exception {
        URL oracle = new URL("https://docs.oracle.com/javase/tutorial/collections/index.html");
        URLConnection urlConnection = oracle.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String inputLine;
        while ((inputLine = bufferedReader.readLine()) != null)
            System.out.println(inputLine);
        bufferedReader.close();
    }
}
