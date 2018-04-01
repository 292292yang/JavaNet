package com.Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class IEServer {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(11000);
        Socket s = ss.accept();
        System.out.println(s.getInetAddress().getHostAddress()+"...connected");

        //BufferedReader bufin = new BufferedReader(new FileReader(new File("D:\\demo.html")));
        PrintWriter pwout = new PrintWriter(s.getOutputStream(),true);

        pwout.println("HTTP/1.1 200 OK");
        pwout.println("<!doctype>\n");

        pwout.println("<h1>this is my webpage5</h1>");


        s.close();
        ss.close();
    }
}
