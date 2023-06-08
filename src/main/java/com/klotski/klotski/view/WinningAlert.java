package com.klotski.klotski.view;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import static com.klotski.klotski.controller.MenuController.reset;

public class WinningAlert {
    public static void display(String title, String message){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL); //so that user interactions with other windows are blocked
        window.setTitle(title);

        Label label = new Label();
        label.setText(message); //add message to the quit window

        Button resetButton = new Button("reset");

        AnchorPane layout = new AnchorPane();//we always need a layout

        layout.setPrefSize(260, 130);
        label.setStyle("-fx-font: 24 arial;");
        label.setLayoutX(80);// Center the label horizontally
        label.setLayoutY(30);// Position the label at the top

        // Position the button
        resetButton.setLayoutX(110);
        resetButton.setLayoutY(100);

        layout.getChildren().addAll(label, resetButton); //Add button to the window


        resetButton.setOnAction(e -> {  window.close();
            try {
                reset();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }); //close AlertBox

        Scene scene = new Scene(layout); //make scene
        window.setScene(scene); //add scene to the window
        window.showAndWait();

    }

}
