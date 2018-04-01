package com.Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class DeskTcpServer {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(10009);

        while(true){
            Socket s = ss.accept();
            Thread newthread = new Thread(new myTcpThread(s));
            newthread.start();
        }
    }
}

class myTcpThread implements Runnable{
    private Socket s;
    public myTcpThread(Socket s){
        this.s = s;
    }
    @Override
    public void run()  {
        try{
            String ip = s.getInetAddress().getHostAddress();
            System.out.println(ip+".....connected");
            BufferedReader bufsin = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader bufin = new BufferedReader(new InputStreamReader(s.getInputStream()));
            BufferedWriter bufout = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            String data = null;
            while((data=bufin.readLine())!=null){
                System.out.println("Client:"+data);
                String saytoClient = bufsin.readLine();
                //System.out.println("Server:"+saytoClient);
                bufout.write(saytoClient);
                bufout.newLine();
                bufout.flush();
            }
            bufout.close();
            bufin.close();
            s.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
