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
            URL url = new URL("http://ipgw.neu.edu.cn/srun_portal_pc.php?ac_id=1&");
            URLConnection conn = url.openConnection();
            System.out.println(conn);
            BufferedReader bufin = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String data = null;
            while((data=bufin.readLine())!=null){
                System.out.println(data);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
