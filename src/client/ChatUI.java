package client;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatUI extends Application {
    private PrintWriter writer;
    private String userName;
    private TextArea chatArea;
    private Socket socket;
    private BufferedReader reader;

    public ChatUI(PrintWriter writer, String userName, Socket socket, BufferedReader reader) {
        this.writer = writer;
        this.userName = userName;
        this.socket = socket;
        this.reader = reader;
    }

    public void appendMessage(String message) {
        chatArea.appendText(message + "\n");
    }

    @Override
    public void start(Stage stage) {
        chatArea = new TextArea();
        chatArea.setEditable(false);

        TextField inputField = new TextField();
        inputField.setPromptText("Type your message...");

        Button sendBtn = new Button("Send");

        sendBtn.setOnAction(e -> {
            String msg = inputField.getText();
            if (!msg.isEmpty()) {
                String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
                String formattedMsg = "[" + time + "] " + userName + ": " + msg;
                writer.println(formattedMsg);
                inputField.clear();
            }
        });

        VBox layout = new VBox(10, chatArea, new HBox(10, inputField, sendBtn));
        layout.setPadding(new Insets(10));
        Scene scene = new Scene(layout, 400, 300);
        stage.setTitle("Chat - " + userName);
        stage.setScene(scene);
        stage.show();
    }
}
