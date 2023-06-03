package com.klotski.klotski.model;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class AlertBox {
    public static void display(String title, String message){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL); //so that user interactions with other windows are blocked
        window.setTitle(title);

        Label label = new Label();
        label.setText(message); //add message to the quit window

        Button quitButton = new Button("Quit");
        Button abortButton = new Button("Abort");

        AnchorPane layout = new AnchorPane();//we always need a layout

        layout.setPrefSize(260, 130);

        label.setLayoutX(40);// Center the label horizontally
        label.setLayoutY(30);// Position the label at the top

        // Position the buttons
        quitButton.setLayoutX(180);
        quitButton.setLayoutY(80);
        abortButton.setLayoutX(40);
        abortButton.setLayoutY(80);

        layout.getChildren().addAll(label, quitButton, abortButton); //Add buttons to the window


        quitButton.setOnAction(e ->  Platform.exit()); //close game
        abortButton.setOnAction(e -> window.close()); //close AlertBox

        Scene scene = new Scene(layout); //make scene
        window.setScene(scene); //add scene to the window
        window.showAndWait();
    }
}

