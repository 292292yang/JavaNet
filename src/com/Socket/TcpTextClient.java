package com.Socket;

import java.io.*;
import java.net.Socket;

public class TcpTextClient {
    public static void main(String[] args) {
        try{
            Socket s = new Socket("219.216.110.61",10005);
            BufferedReader bufr = new BufferedReader(new FileReader("UdpSend.java"));
            PrintWriter bufw = new PrintWriter(s.getOutputStream(),true);
            String data = null;
            while((data=bufr.readLine())!=null){
                bufw.println(data);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
