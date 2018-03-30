package com.iostream;



import java.io.*;
import java.util.Scanner;

/**
 * 非纯文本数据不要用字符流
 */

public class IODemo {

    public static void main(String[] args) {
        //FileInputStreamTest();
        //FileReader();
        //FileOutputStreamTest();
        //FileWriterTest();
        //BufferedReaderTest();
        BufferedWriterTest();
    }

    public static void FileInputStreamTest(){
        FileInputStream fis = null;
        try{
            fis = new FileInputStream("D:\\1.txt");
            byte[] buf = new byte[1024];
            int len =0;
            while((len=fis.read(buf))!=-1){
                System.out.println(new String(buf,0,buf.length));
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            if(fis!=null){
                try{
                    fis.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void FileOutputStreamTest(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try{
            fis = new FileInputStream("D:\\3.JPG");
            fos = new FileOutputStream("D:\\5.JPG");
            byte[] buf = new byte[1024];
            int len = 0;
            while((len=fis.read(buf))!=-1){
                fos.write(buf,0,buf.length);
                fos.flush();
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            if(fos!=null){
                try{
                    fos.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void FileReaderTest(){
        FileReader fr = null;
        try{
             fr = new FileReader("D:\\1.txt");
             char[] buf = new char[32];

             int len = 0;
             while((len=fr.read(buf))!=-1){
                 System.out.println(new String(buf,0,buf.length));
             }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            if(fr!=null){
                try{
                    fr.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void FileWriterTest(){
        FileReader fr = null;
        FileWriter fw = null;
        try{
            fr = new FileReader("D:\\3.JPG");
            fw = new FileWriter("D:\\4.JPG");
            char[] buf = new char[1024];
            int len = 0;
            while((len=fr.read(buf))!=-1){
                fw.write(buf,0,buf.length);
            }

        }catch(IOException e){
            e.printStackTrace();
        }finally {
            if(fr!=null){
                try{
                    fr.close();
                    fw.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void BufferedReaderTest(){
        FileReader fr = null;
        BufferedReader br = null;

        try{
            fr = new FileReader("D:\\1.txt");
            br = new BufferedReader(fr);
            String s = null;
            while((s=br.readLine())!=null){
                System.out.println(s);
            }
            fr.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void BufferedWriterTest(){
        FileReader fr = null;
        FileWriter fw = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        try{
            fr = new FileReader("D:\\3.JPG");
            br = new BufferedReader(fr);
            fw = new FileWriter("D:\\6.JPG");
            bw = new BufferedWriter(fw);
            String str = null;
            while((str=br.readLine())!=null){
                bw.write(str);
                bw.newLine();
                bw.flush();
            }
            bw.close();
            br.close();
            fw.close();
            fr.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
