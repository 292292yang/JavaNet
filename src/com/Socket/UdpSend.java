package com.Socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpSend {
    public static void main(String[] args) {
        try{
            //建立socket服务
            DatagramSocket ds = new DatagramSocket();
            //打包数据，DatagramPocket
            Scanner scan = new Scanner(System.in);
            //键盘数据数据
            while (scan.hasNext()){
                byte[] buf = scan.next().getBytes();
                //打包数据并发送数据
                DatagramPacket dp = new DatagramPacket(buf,buf.length, InetAddress.getByName("219.216.110.50"),10000);
                ds.send(dp);
            }
            //关闭资源
            ds.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
