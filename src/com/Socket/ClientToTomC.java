package com.Socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientToTomC {
    public static void main(String[] args) throws Exception{
        Socket s = new Socket("219.216.110.61",8080);
        PrintWriter pw = new PrintWriter(s.getOutputStream(),true);

        pw.println("GET /myweb/demo.html HTTP/1.1");
        pw.println("Host: 219.216.110.61:11000");
        //pw.println("Accept: */*");
        pw.println("Connection: closed");

        pw.println();
        pw.println();

        BufferedReader bufin = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String data = null;
        while((data=bufin.readLine())!=null){
            System.out.println(data);
        }
    }
}
