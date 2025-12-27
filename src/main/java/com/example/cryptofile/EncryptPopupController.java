package com.example.cryptofile;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.io.File;

public class EncryptPopupController {
    @FXML private ListView<File> listView;
    @FXML private Button closeButton;

    private Label listFileName, listFileSize, greenTick, fileIcon;
    private HBox fileNameHBox, nameAndTick, sizeAndProgress, row;
    private VBox middleVbox;
    private ProgressBar progressBar;
    private Button deleteButton;


    public void loadListView(ObservableList<File> fileList){
        listView.setItems(fileList);
        customLIstView();
    }

    private void customLIstView(){
        listView.setCellFactory(param -> new ListCell<>(){
            @Override
            protected void updateItem(File item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                } else {
                    listFileName = new Label(item.getName());
                    listFileSize = new Label("(" + item.length()/1024 + " KB)"); //TODO: create function for file size

                    greenTick = new Label();
                    greenTick.setGraphic(Shared.createIcon("greenTick"));

                    fileNameHBox = new HBox();
                    fileNameHBox.getChildren().addAll(listFileName, listFileSize);

                    nameAndTick = new HBox();
                    nameAndTick.getChildren().addAll(fileNameHBox, greenTick);
                    HBox.setHgrow(fileNameHBox, Priority.ALWAYS);

                    progressBar = new ProgressBar();
                    progressBar.setMaxWidth(Double.MAX_VALUE);


                    middleVbox = new VBox();
                    middleVbox.getChildren().addAll(nameAndTick, progressBar);

                    fileIcon = new Label();
                    fileIcon.setGraphic(Shared.createIcon("fileIcon"));

                    deleteButton = new Button();
                    deleteButton.setGraphic(Shared.createIcon("deleteButton"));

                    row = new HBox();
                    row.getChildren().addAll(fileIcon, middleVbox, deleteButton);
                    HBox.setHgrow(middleVbox, Priority.ALWAYS);

                    allinOne();

                    setGraphic(row);

                    deleteButton.setOnAction(e -> {
                        //TODO: clicking on the delete button will stop any progress for the file. not removing the file from the list crossover the file
                    });
                }
            }
        } );
    }

    private void allinOne() {
        progressBar.getStyleClass().add("progressBar");
        greenTick.getStyleClass().add("greenTick");
        fileNameHBox.getStyleClass().add("fileNameHBox");
        middleVbox.getStyleClass().add("middleVbox");
        fileIcon.getStyleClass().add("fileIcon");
        deleteButton.getStyleClass().add("deleteButton");
        row.getStyleClass().add("row");
    }

    public void handleCloseButton() {

    }
}
