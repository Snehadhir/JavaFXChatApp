package server;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    private static Set<ClientHandler> clients = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) {
        System.out.println("Server running on port 12345...");
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            while (true) {
                Socket socket = serverSocket.accept();
                ClientHandler handler = new ClientHandler(socket, clients);
                clients.add(handler);
                new Thread(handler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
