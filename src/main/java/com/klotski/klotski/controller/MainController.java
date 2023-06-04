package com.klotski.klotski.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.klotski.klotski.model.Match;
import com.klotski.klotski.model.Move;
import com.klotski.klotski.view.LoadMatchAlert;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static com.klotski.klotski.controller.PieceController.*;
import static com.klotski.klotski.controller.MatchController.*;

public class MainController {
    //call the pieces through the ids from view.fxml in here
    @FXML
    public Button pc0,pc1,pc2,pc3,pc4,pc5,pc6,pc7,pc8,pc9;
    //call the text field to later modify for the counter
    @FXML
    public Text Count;

    //initialization of the Array used to ease methods of move
    @FXML
    public void initialize() throws Exception {
        initializeButtonArray();
    }
    public void initializeButtonArray() throws Exception {
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

        LoadMatchAlert.display("Load Configuration", "Warm welcome to our application!\n" +
                "Diana, Stefano, Tommaso and Silviu are hopeful you'll like it.\n" +
                "Choose the configuration to start with or leave the default one.", "configuration");
    }
    public void select(ActionEvent e) { //selecting the button to move
        selection(e);
    }
    // all the movements are controlled by increasing or decreasing (by 100) of the variable X and Y(The Y axis is inverted) after checking the moves is valid.
    public void MoveRight() throws Exception {
        PieceController.MoveRight();
        Count.setText("Counter: " + PieceController.counter );
    }
    public void MoveLeft() throws Exception {
        PieceController.MoveLeft();
        Count.setText("Counter: " + PieceController.counter );
    }
    public void MoveUp() throws Exception {
        PieceController.MoveUp();
        Count.setText("Counter: " + PieceController.counter );
    }
    public void MoveDown() throws Exception {
        PieceController.MoveDown();
        Count.setText("Counter: " + PieceController.counter );
    }
    public void saveMatch() throws Exception {
        MenuController.Save();
    }

    public void loadMatch() throws Exception {
        MenuController.loadMatch();
        //MatchController.loadSave();
    }

    public void BestMove() {
    }

    public void Quit() {
        MenuController.Quit();
    }

    public void Back() {
    }

    
    public void Keyboard(KeyEvent keyEvent) throws Exception {
        PieceController.Keyboard(keyEvent);
        Count.setText("Counter: " + PieceController.counter );
    }

    public void Swipe(MouseEvent mouseEvent) throws Exception {
        PieceController.Swipe(mouseEvent);
        Count.setText("Counter: " + PieceController.counter );
    }

}
