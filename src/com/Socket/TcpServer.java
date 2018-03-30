package com.Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(10004);
            Socket s = ss.accept();
            String ip = s.getInetAddress().getHostAddress();
            System.out.println(ip+"......connected");
            BufferedReader bufin = new BufferedReader(new InputStreamReader(s.getInputStream()));
            BufferedWriter bufOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            String data = null;
            while((data=bufin.readLine())!=null){
                System.out.println(data);
                bufOut.write(data.toUpperCase());
                bufOut.newLine();
                bufOut.flush();
            }
            s.close();
            ss.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
