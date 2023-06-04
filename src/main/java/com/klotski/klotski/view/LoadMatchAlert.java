package com.klotski.klotski.view;

import com.klotski.klotski.controller.MatchController;
import com.klotski.klotski.model.Match;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

public class LoadMatchAlert {


    private static Match match;
    private static Stage window;
    private static AnchorPane layout;
    private static ListView<HBoxCell> list;
    private static Button cancelButton;
    private static String loadLocation;
    private static String emptyListpPlaceholder;
    private static String cancelButtonText;
    private static double labelPrefHeight;
    private static String loadType;

    public static void display(String title, String message, String loadTypeLocal) throws Exception {
        window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL); //so that user interactions with other windows are blocked
        window.setTitle(title);

        if (loadTypeLocal == "configuration"){
            loadLocation = MatchController.configurationLocation;
            emptyListpPlaceholder = "No Configuration available!";
            cancelButtonText = "Default";
            labelPrefHeight = 60;
            loadType = loadTypeLocal;
        } else if (loadTypeLocal == "saved"){
            loadLocation = MatchController.savedLocation;
            emptyListpPlaceholder = "No saved matches!";
            cancelButtonText = "Cancel";
            labelPrefHeight = 30;
            loadType = loadTypeLocal;
        } else{
            throw new Exception("No other load type supported, choose between 'configuration' or 'saved'. Given: " + loadTypeLocal);
        }

        match = Match.getMatch();

        list = getListObject();

        Label label = new Label();
        label.setText(message); //add message to the quit window

        cancelButton = new Button(cancelButtonText);

        layout = new AnchorPane();//we always need a layout

        label.setLayoutX(40);// Center the label horizontally
        label.setLayoutY(30);// Position the label at the top
        label.setPrefHeight(labelPrefHeight);

        // Position the items
        list.setLayoutX(40);
        list.setLayoutY(label.getLayoutY() + label.getPrefHeight() + 10);

        cancelButton.setLayoutX(40);
        cancelButton.setLayoutY( list.getLayoutY() + list.getPrefHeight() + 10);
        System.out.println(list.getPrefHeight());

        layout.setPrefSize(440, 130);
        layout.getChildren().addAll(label, list, cancelButton); //Add buttons to the window

        //close alert
        cancelButton.setOnAction(e -> window.close()); //close AlertBox

        Scene scene = new Scene(layout); //make scene
        window.setScene(scene); //add scene to the window
        window.showAndWait();
    }

    private static ListView<HBoxCell> getListObject(){
        //create list that will contain the HBox that will compose the listView
        ArrayList<HBoxCell> hBoxList = new ArrayList<HBoxCell>();

        //get list of existing files
        File folder = new File(loadLocation);
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                hBoxList.add(new HBoxCell(file.getName()));
            }
        }
        ListView<HBoxCell> list = new ListView<>();

        if (hBoxList.size() == 0){
            list.setPlaceholder(new Label(emptyListpPlaceholder));
            list.setPrefHeight(35);
        } else {
            list.setPrefHeight(35 * hBoxList.size());
            ObservableList<HBoxCell> items = FXCollections.observableArrayList(hBoxList);
            list.setItems(items);
        }

        return list;
    }

    //utility method to refresh the list when a match is deleted
    private static void refreshList(){
        layout.getChildren().remove(list);
        ListView<HBoxCell> list = getListObject();
        layout.getChildren().add(list);
        //reconfigure layout
        list.setLayoutX(40);
        list.setLayoutY(50);
        cancelButton.setLayoutY( list.getLayoutY() + list.getPrefHeight() + 10);
        //trick found online to refresh the view
        window.setHeight(window.getHeight() + 0.001);
    }


    //create item object Component to create the list
    public static class HBoxCell extends HBox {
        Label label = new Label();
        Button loadButton = new Button();
        Button deleteButton = new Button();


        HBoxCell(String labelText) {
            super();

            label.setText(labelText);
            label.setMaxWidth(Double.MAX_VALUE);
            HBox.setHgrow(label, Priority.ALWAYS);


            loadButton.setText("Load");
            loadButton.setOnAction(e -> {
                try {
                    //load match
                    MatchController.loadMatch(labelText, loadType);
                    System.out.println(labelText + " loaded");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                window.close();
            });
            //create Delete Button only for Saved Matches. Do not allow to delete configurations.
            if (loadType == "saved") {
                deleteButton.setText("Delete");
                deleteButton.setOnAction(e -> {
                    try {
                        //save match the exit game or close alert
                        File matchToDelete = new File(MatchController.savedLocation + labelText);
                        if (matchToDelete.delete()) {
                            System.out.println("Deleted the file: " + matchToDelete.getName());
                        } else {
                            System.out.println("Failed to delete the file.");
                        }
                        refreshList();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                });


                this.getChildren().addAll(label, loadButton, deleteButton);

            } else{
                deleteButton = null;

                this.getChildren().addAll(label, loadButton);
            }

        }
    }
}

