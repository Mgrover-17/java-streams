package com.bridgelabz.LargeFile;

import java.io.*;

public class ReadFileLineByLine {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Manvi\\Desktop\\bridgelabz-workspace\\java-streams\\src\\main\\java\\com\\bridgelabz\\LargeFile\\largefile";
        readErrorLines(filePath);
    }

    public static void readErrorLines(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}

