package com.Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpTextSever {
    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(10005);
            Socket s = ss.accept();
            String ip = s.getInetAddress().getHostAddress();
            System.out.println(ip+"......connected");
            BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter bufOut = new PrintWriter(new FileWriter("demo.txt"),true);
            String data  = null;
            while((data=bufIn.readLine())!=null){
                bufOut.println(data);
            }
        }catch (Exception e){

        }
    }
}
