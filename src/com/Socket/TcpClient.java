package com.Socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TcpClient {
    public static void main(String[] args) {
        try{
            Socket s= new Socket("219.216.110.61",10004);
            //Scanner scan = new Scanner(System.in);
            BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufrout =new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            BufferedReader bufIn =new BufferedReader(new InputStreamReader(s.getInputStream()));
            String data = null;
            while((data=bufr.readLine())!=null){
                if("over".equals(data)){
                    break;
                }
                bufrout.write(data);
                bufrout.newLine();
                bufrout.flush();
                System.out.println(bufIn.readLine());
            }
            s.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

