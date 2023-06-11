package com.klotski.klotski.view;

import javafx.scene.control.Button;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class QuitAlert {

    /*
     * main method that created the Alert definition and defines the layout
     **/
    public static void display(String title, String message){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL); //so that user interactions with other windows are blocked
        window.setTitle(title);

        Label label = new Label();
        label.setText(message); //add message to the quit window

        //create components to display
        Button quitButton = new Button("Quit");
        Button cancelButton = new Button("Cancel");

        AnchorPane layout = new AnchorPane();//we always need a layout

        layout.setPrefSize(260, 130);

        label.setLayoutX(40);// Center the label horizontally
        label.setLayoutY(30);// Position the label at the top

        // Position the buttons
        quitButton.setLayoutX(180);
        quitButton.setLayoutY(80);
        cancelButton.setLayoutX(40);
        cancelButton.setLayoutY(80);

        //add display components to the main layout
        layout.getChildren().addAll(label, quitButton, cancelButton); //Add buttons to the window

        //defines buttons actions
        quitButton.setOnAction(e ->  System.exit(0)); //close game
        cancelButton.setOnAction(e -> window.close()); //close AlertBox

        Scene scene = new Scene(layout); //make scene
        window.setScene(scene); //add scene to the window
        window.showAndWait();
    }
}

