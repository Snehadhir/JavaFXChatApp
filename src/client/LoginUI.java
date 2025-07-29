package client;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.function.Consumer;

public class LoginUI extends Application {
    private final Consumer<String> onLogin;

    public LoginUI(Consumer<String> onLogin) {
        this.onLogin = onLogin;
    }

    @Override
    public void start(Stage stage) {
        TextField nameField = new TextField();
        nameField.setPromptText("Enter username");

        Button loginBtn = new Button("Login");
        loginBtn.setOnAction(e -> {
            String username = nameField.getText();
            if (!username.isEmpty()) {
                onLogin.accept(username);
                stage.close();
            }
        });

        VBox layout = new VBox(10, nameField, loginBtn);
        layout.setPadding(new javafx.geometry.Insets(20));
        stage.setScene(new Scene(layout, 300, 150));
        stage.setTitle("Login");
        stage.show();
    }
}
