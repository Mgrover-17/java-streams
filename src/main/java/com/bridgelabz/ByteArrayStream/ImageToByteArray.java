package com.bridgelabz.ByteArrayStream;

import java.io.*;

public class ImageToByteArray {
    public static void main(String[] args) {
        String inputFilePath = "C:\\Users\\Manvi\\Desktop\\bridgelabz-workspace\\java-streams\\src\\main\\java\\com\\bridgelabz\\ByteArrayStream\\input.png";  // Path to the original image
        String outputFilePath = "C:\\Users\\Manvi\\Desktop\\bridgelabz-workspace\\java-streams\\output.png"; // Path for the converted image

        try {
            // Convert image to byte array
            byte[] imageBytes = imageToByteArray(inputFilePath);

            // Convert byte array back to image
            byteArrayToImage(imageBytes, outputFilePath);

            // Verify file integrity
            verifyFiles(inputFilePath, outputFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to convert image to byte array
    public static byte[] imageToByteArray(String filePath) throws IOException {
        File file = new File(filePath);
        try (FileInputStream fis = new FileInputStream(file);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        }
    }

    // Method to convert byte array back to an image
    public static void byteArrayToImage(byte[] imageBytes, String outputFilePath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(outputFilePath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }

    // Method to verify if the original and new image files are identical
    public static void verifyFiles(String originalPath, String newPath) throws IOException {
        File originalFile = new File(originalPath);
        File newFile = new File(newPath);

        if (originalFile.length() == newFile.length()) {
            System.out.println("Success: The original and converted images are identical.");
        } else {
            System.out.println("Error: The images are different in size.");
        }
    }
}
