package org.example.client;

import org.example.dictionary.SingletonDictionary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String word;
            while ((word = in.readLine()) != null) {

                if (!SingletonDictionary.getInstance().containsWord(word)) {
                    out.println("Word not found");
                    continue;
                }

                String definition = SingletonDictionary.getInstance().getTranslation(word);
                if (definition != null) {
                    out.println(definition);
                }
            }

        } catch (IOException e) {
            System.err.println("Error handling client: " + e.getMessage());
        }
    }
}