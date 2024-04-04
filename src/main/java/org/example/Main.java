package org.example;

import org.example.server.DictionaryServer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main method started");
        if (args.length != 2) {
            System.err.println("Bad usage: java DictionaryServer <port number> <pool size>");
            System.exit(1);
        }
        int port = Integer.parseInt(args[0]);
        int poolSize = Integer.parseInt(args[1]);

        System.out.println("Starting server on port " + port + " with pool size " + poolSize);
        try {
            DictionaryServer server = new DictionaryServer(port, poolSize);
            System.out.println("Server created");
            server.start();
            System.out.println("Server started");
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}