package com.Socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

class Send implements Runnable{
    private DatagramSocket sendScoket;
    public Send(DatagramSocket sendScoket){
        this.sendScoket = sendScoket;
    }

    @Override
    public void run() {
        try{
            Scanner scan = new Scanner(System.in);
            while(scan.hasNext()){
                byte[] buf = scan.next().getBytes();
                DatagramPacket dp = new DatagramPacket(buf,buf.length, InetAddress.getByName("219.216.110.50"),10001);
                sendScoket.send(dp);
            }
            sendScoket.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

class Receive implements Runnable{
    private DatagramSocket receiveScoket;
    public Receive(DatagramSocket receiveScoket){
        this.receiveScoket = receiveScoket;
    }

    @Override
    public void run() {
        try{
            while(true){
                byte[] buf = new byte[1024];
                DatagramPacket dp = new DatagramPacket(buf,buf.length);
                receiveScoket.receive(dp);
                String ip =  dp.getAddress().getHostAddress();
                String data = new String(dp.getData(),0,dp.getLength());
                System.out.println(ip + "::" + data);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

public class UdpChatDemo {
    public static void main(String[] args) {
        try{
            DatagramSocket sendScoket = new DatagramSocket();
            DatagramSocket receiveScoket = new DatagramSocket(10001);
            new Thread(new Send(sendScoket)).start();
            new Thread(new Receive(receiveScoket)).start();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
