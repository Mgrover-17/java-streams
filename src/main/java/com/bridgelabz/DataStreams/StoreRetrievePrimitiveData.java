package com.bridgelabz.DataStreams;

import java.io.*;

public class StoreRetrievePrimitiveData {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\Manvi\\Desktop\\bridgelabz-workspace\\java-streams\\src\\main\\java\\com\\bridgelabz\\DataStreams\\students.txt";

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeInt(101);
            dos.writeUTF("Alice Johnson");
            dos.writeDouble(3.8);

            dos.writeInt(102);
            dos.writeUTF("Bob Smith");
            dos.writeDouble(3.5);

            System.out.println("Data stored successfully.");
        } catch (IOException e) {
            System.err.println("Error writing data: " + e.getMessage());
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            while (dis.available() > 0) {
                System.out.println("Roll No: " + dis.readInt() + ", Name: " + dis.readUTF() + ", GPA: " + dis.readDouble());
            }
        } catch (IOException e) {
            System.err.println("Error reading data: " + e.getMessage());
        }
    }
}

