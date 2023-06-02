package com.klotski.klotski.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import static com.klotski.klotski.controller.PieceController.*;

public class MainController {
    //call the pieces through the ids from view.fxml in here
    @FXML
    public Button pc0,pc1,pc2,pc3,pc4,pc5,pc6,pc7,pc8,pc9;
    //call the text field to later modify for the counter
    @FXML
    public Text Count;
    //initiallization of the Array used to ease methods of move
    @FXML
    public void initialize(){
        initializeButtonArray();
    }
    public void initializeButtonArray() {
        pieces = new Button[10];
        pieces[0] = pc0;
        pieces[1] = pc1;
        pieces[2] = pc2;
        pieces[3] = pc3;
        pieces[4] = pc4;
        pieces[5] = pc5;
        pieces[6] = pc6;
        pieces[7] = pc7;
        pieces[8] = pc8;
        pieces[9] = pc9;
    }
    public void select(ActionEvent e) { //selecting the button to move
        selection(e);
    }
    // all the movement are controlled by increasing or decreasing (by 100) of the variable X and Y(The Y axis is inverted) after checking the moves is valid.
    public void MoveRight() {
        PieceController.MoveRight();
        Count.setText("Counter: " + PieceController.counter );
    }
    public void MoveLeft() {
        PieceController.MoveLeft();
        Count.setText("Counter: " + PieceController.counter );
    }
    public void MoveUp() {
        PieceController.MoveUp();
        Count.setText("Counter: " + PieceController.counter );
    }
    public void MoveDown() {
        PieceController.MoveDown();
        Count.setText("Counter: " + PieceController.counter );
    }
    public void Save() {
    }

    public void LoadSave() {
    }

    public void BestMove() {
    }

    public void Quit() {
        MenuController.Quit();
    }

    public void Back() {
    }


    public void keyboard(KeyEvent keyEvent) {

    }
}
