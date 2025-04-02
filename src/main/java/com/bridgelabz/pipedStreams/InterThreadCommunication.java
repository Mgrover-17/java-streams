package com.bridgelabz.pipedStreams;

import java.io.*;

public class InterThreadCommunication {
    public static void main(String[] args) {
        processPipedStreams();
    }

    public static void processPipedStreams() {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            Thread writer = new Thread(() -> {
                try (pos) {
                    pos.write("Hello from Writer!".getBytes());
                    System.out.println("Writer: Data written.");
                } catch (IOException e) {
                    System.err.println("Writer Error: " + e.getMessage());
                }
            });

            Thread reader = new Thread(() -> {
                try (pis) {
                    byte[] buffer = new byte[1024];
                    int length = pis.read(buffer);
                    System.out.println("Reader: Received - " + new String(buffer, 0, length));
                } catch (IOException e) {
                    System.err.println("Reader Error: " + e.getMessage());
                }
            });

            reader.start();
            writer.start();

        } catch (IOException e) {
            System.err.println("Error setting up streams: " + e.getMessage());
        }
    }
}
