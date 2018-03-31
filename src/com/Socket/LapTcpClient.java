package com.Socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class LapTcpClient {
    public static void main(String[] args) throws Exception{
        Socket s = new Socket("219.216.110.61",10008);
        OutputStream os = s.getOutputStream();
        InputStream is = s.getInputStream();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()){
            String str = scan.next();
            if("over".equals(str)) break;
            os.write(str.getBytes());
            os.flush();
            byte[] buf = new byte[1024];
            int len = is.read(buf);
            System.out.println(new String(buf,0,buf.length));
        }
        os.close();
        s.close();
    }
}
