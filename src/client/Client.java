package client;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

public class Client extends Application {
    private ChatUI chatUI;
    private BufferedReader reader;
    private PrintWriter writer;
    private String userName;
    private Socket socket;

    @Override
    public void start(Stage primaryStage) {
        LoginUI loginUI = new LoginUI(username -> {
            this.userName = username;
            try {
                socket = new Socket("localhost", 12345);
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
                writer.println(userName);

                chatUI = new ChatUI(writer, userName, socket, reader);
                chatUI.start(new Stage());

                listenForMessages();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        loginUI.start(primaryStage);
    }

    private void listenForMessages() {
        new Thread(() -> {
            try {
                String msg;
                while ((msg = reader.readLine()) != null) {
                    String finalMsg = msg;
                    Platform.runLater(() -> chatUI.appendMessage(finalMsg));
                }
            } catch (IOException e) {
                Platform.runLater(() -> chatUI.appendMessage("Disconnected from server."));
            }
        }).start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
