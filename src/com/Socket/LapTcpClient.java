package com.Socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class LapTcpClient {
    public static void main(String[] args) throws Exception{
        Socket s = new Socket("219.216.110.61",10009);
        BufferedReader bufsin = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufin = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedWriter bufout = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        String str = null;
        while ((str=bufsin.readLine())!=null) {
            if("over".equals(str)) break;
            bufout.write(str);
            bufout.newLine();
            bufout.flush();
            System.out.println("Server:"+bufin.readLine());
        }

        bufout.close();
        bufin.close();
        s.close();
    }
}
