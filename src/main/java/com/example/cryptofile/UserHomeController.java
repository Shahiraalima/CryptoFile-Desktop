package com.example.cryptofile;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class UserHomeController {
    @FXML private Label welcomeLabel;


    public void setName(String currentUser) {
        welcomeLabel.setText("Welcome back, " + currentUser.split(" ")[0] + "!");
    }
}