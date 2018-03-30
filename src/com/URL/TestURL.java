package com.URL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class TestURL {
    public static void main(String[] args) {
        try{
            URL url = new URL("http://47.94.148.26/html/phpmyadmin/");
            //InputStream is = url.openStream();
            URLConnection uc = url.openConnection();
            InputStream is = uc.getInputStream();
            InputStreamReader isr = new InputStreamReader(is,"utf-8");
            BufferedReader br = new BufferedReader(isr);
            while(br.readLine()!=null){
                String data = br.readLine();
                System.out.println(data);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
