package com.bridgelabz.fileHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadAndWrite {
    public static void main(String[] args) {
        try(
            FileInputStream reader=new FileInputStream("C:\\Users\\Manvi\\Desktop\\bridgelabz-workspace\\java-streams\\src\\main\\java\\com\\bridgelabz\\fileHandling\\input");
            FileOutputStream writer=new FileOutputStream("C:\\Users\\Manvi\\Desktop\\bridgelabz-workspace\\java-streams\\src\\main\\java\\com\\bridgelabz\\fileHandling\\output.txt");
        ){
            int data;
            while((data=reader.read())!=-1){
                writer.write(data);
            }
            System.out.println("file copied");
        } catch (IOException e) {
            System.out.println("exception handled"+ e.getMessage());
        }
    }
}
