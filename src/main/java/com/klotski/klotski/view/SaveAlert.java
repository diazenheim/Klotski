package com.klotski.klotski.view;

import com.klotski.klotski.controller.MatchController;
import com.klotski.klotski.model.Match;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SaveAlert {


    private static Match match;
    public static void display(String title, String message, boolean quit){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL); //so that user interactions with other windows are blocked
        window.setTitle(title);

        //get Match
        match = Match.getMatch();

        //create objects to display
        Label label = new Label();
        label.setText(message); //add message to the quit window
        TextField matchNameInput = new TextField();
        matchNameInput.setText(match.getMatchName());

        Button saveButton = new Button("Save");
        Button cancelButton = new Button("Cancel");

        AnchorPane layout = new AnchorPane();//we always need a layout

        label.setLayoutX(40);// Center the label horizontally
        label.setLayoutY(30);// Position the label at the top

        // Position the buttons
        matchNameInput.setLayoutX(40);
        matchNameInput.setLayoutY(50);
        cancelButton.setLayoutX(40);
        cancelButton.setLayoutY(80);
        saveButton.setLayoutX(180);
        saveButton.setLayoutY(80);

        //if the Alert has been raised after pressing quit is required the possibility to Not Save adding Don't save button
        if (quit){
            layout.setPrefSize(440, 130);
            //create don't save Button

            Button dontSaveButton = new Button("Don't Save");
            dontSaveButton.setLayoutX(320);
            dontSaveButton.setLayoutY(80);
            //close game without saving
            dontSaveButton.setOnAction(e -> Platform.exit());

            layout.getChildren().addAll(label, matchNameInput, saveButton, cancelButton, dontSaveButton); //Add buttons to the window
        } else {
            layout.setPrefSize(260, 130);
            layout.getChildren().addAll(label, matchNameInput, saveButton, cancelButton); //Add buttons to the window
        }

        //close alert
        cancelButton.setOnAction(e -> window.close()); //close AlertBox
        saveButton.setOnAction(e ->
        {
            try {
                //save match the exit game or close alert
                match.setMatchName(matchNameInput.getText());
                MatchController.saveMatch();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            if (quit) {
                Platform.exit();
            } else{
                window.close();
            }
        });

        Scene scene = new Scene(layout); //make scene
        window.setScene(scene); //add scene to the window
        window.showAndWait();
    }
}

