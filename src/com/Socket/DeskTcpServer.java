package com.Socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class DeskTcpServer {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(10008);
        Socket s = ss.accept();
        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip+".....connected");
        InputStream is = s.getInputStream();
        OutputStream os = s.getOutputStream();
        byte[] buf = new byte[1024];
        int len = 0;
        while((len=is.read(buf))!=-1){
            String str = new String(buf,0,buf.length);
            System.out.println(str);
            os.write(("what you say....."+str).getBytes());
        }
        is.close();
        os.close();
        s.close();
        ss.close();

    }
}
