package server;

import java.io.*;
import java.net.Socket;
import java.util.Set;

public class ClientHandler implements Runnable {
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    private Set<ClientHandler> clients;
    private String userName;

    public ClientHandler(Socket socket, Set<ClientHandler> clients) {
        this.socket = socket;
        this.clients = clients;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
            userName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            String msg;
            while ((msg = reader.readLine()) != null) {
                broadcast(msg);
            }
        } catch (IOException e) {
            System.out.println(userName + " disconnected.");
        } finally {
            try {
                socket.close();
                clients.remove(this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void broadcast(String msg) {
        for (ClientHandler client : clients) {
            client.writer.println(msg);
        }
    }
}
