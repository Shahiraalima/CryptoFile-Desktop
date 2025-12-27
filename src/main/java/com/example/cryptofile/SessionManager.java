package com.example.cryptofile;

import javafx.scene.control.ListView;

import java.io.File;

public final class SessionManager {
    public SessionManager() {
    }

    public static UserInfo loggedInUser;

    public static ListView<File> currentFiles;
}
