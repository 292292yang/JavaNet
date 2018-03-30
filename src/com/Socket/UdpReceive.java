package com.Socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceive {
    public static void main(String[] args) {
        try{
            //建立socket服务
            DatagramSocket ds = new DatagramSocket(10000);
            while (true){
                //新建数据包对象，用于接收传过来的数据
                byte[] buf = new byte[1024];
                DatagramPacket dp = new DatagramPacket(buf,buf.length);
                ds.receive(dp);
                String data = new String(dp.getData(),0,dp.getLength());
                System.out.println(data);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
