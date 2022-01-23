package ex4;

import java.net.*;
import java.io.*;

class Whois {
    public static void main(String[] args) throws Exception {
        int c;
        Socket s = new Socket("whois.verisign-grs.com", 43);
        InputStream socketInputStream = s.getInputStream();
        OutputStream socketOutputStream = s.getOutputStream();
        String str = (args.length == 0 ? "GOOGLE.COM" : args[0]) + "\n";
        byte buf[] = str.getBytes();
        socketOutputStream.write(buf);
        while ((c = socketInputStream.read()) != -1) {
            System.out.print((char) c);
        }
        s.close();
    }
}
