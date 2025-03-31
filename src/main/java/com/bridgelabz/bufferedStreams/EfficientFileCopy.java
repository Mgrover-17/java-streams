package com.bridgelabz.bufferedStreams;

import java.io.*;

public class EfficientFileCopy {
    public static void main(String[] args) {
        try(
                BufferedInputStream reader=new BufferedInputStream(new FileInputStream("C:\\Users\\Manvi\\Desktop\\bridgelabz-workspace\\java-streams\\src\\main\\java\\com\\bridgelabz\\bufferedStreams\\input"));
                BufferedOutputStream writer=new BufferedOutputStream(new FileOutputStream("C:\\Users\\Manvi\\Desktop\\bridgelabz-workspace\\java-streams\\output"));
                ){
            int data;
            byte buffer[]=new byte[4096];
            while((data=reader.read(buffer))!=-1){
                writer.write(buffer,0,data);
            }
            System.out.println("file copied using buffered streams.");
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
