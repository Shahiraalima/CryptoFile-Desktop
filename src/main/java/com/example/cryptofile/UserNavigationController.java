package com.example.cryptofile;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class UserNavigationController {

    @FXML
    private StackPane contentPane;

    @FXML
    public void initialize() {
        loadView("userHome.fxml");
    }

    private void loadView(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent view = loader.load();
            contentPane.getChildren().setAll(view);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void loadDashboard() {
        loadView("userHome.fxml");
    }
    @FXML
    public void loadEncryptFile() {
        loadView("encryptFile.fxml");
    }
    @FXML
    public void loadDecryptFile() {
        loadView("decryptFile.fxml");
    }
    @FXML
    public void loadActivityLogs() {
        loadView("activityLogs.fxml");
    }
    @FXML
    public void loadMyFiles() {
        loadView("myFiles.fxml");
    }
    @FXML
    public void loadProfile() {
        loadView("userProfile.fxml");
    }


}