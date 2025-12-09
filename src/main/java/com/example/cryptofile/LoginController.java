package com.example.cryptofile;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.security.PrivateKey;

public class LoginController {
    @FXML private BorderPane rootPane;
    @FXML private StackPane loginPane;
    @FXML private VBox loginVBox;

    @FXML private Label welcomeText;
    @FXML private Label loginLabel;

    @FXML private StackPane passwordPane;
    @FXML private TextField username, showPassword;
    @FXML private PasswordField password;
    @FXML private Button loginButton;
    @FXML private ToggleButton eyeButton;

    @FXML private HBox createAccountHBox;
    @FXML private Hyperlink registerLink;
    @FXML private Text message;

    @FXML
    private void initialize() {
        showPassword.textProperty().bindBidirectional(password.textProperty());
        eyeButton.setOnAction(event -> {togglePasswordVisibility();});

    }

    private void togglePasswordVisibility() {
        boolean visible = eyeButton.isSelected();
        password.setVisible(!visible);
        password.setManaged(!visible);
        showPassword.setVisible(visible);
        showPassword.setManaged(visible);
        if (visible) {
            showPassword.requestFocus();
            showPassword.positionCaret(showPassword.getText().length());
            eyeButton.setText("\uD83D\uDC41");
        }
        else {
            password.requestFocus();
            password.positionCaret(password.getText().length());
            eyeButton.setText("\uD83D\uDC41");
        }
    }








}
