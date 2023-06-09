package com.klotski.klotski.controller;

import com.klotski.klotski.model.Match;
import com.klotski.klotski.model.Solution;
import com.klotski.klotski.view.LoadMatchAlert;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;


import java.util.ArrayList;

import static com.klotski.klotski.controller.PieceController.*;

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

    Match match;
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
                "Choose the configuration to start with or leave the default one.", "configuration");
    }
    public void select(ActionEvent e) { //selecting the button to move
        selection(e);
    }
    // all the movements are controlled by increasing or decreasing (by 100) of the variable X and Y(The Y axis is inverted) after checking the moves is valid.
    public void MoveRight() throws Exception {
        PieceController.MoveRight();
        setCounter(PieceController.counter );
        match.setBestMoveResetfield(false);
    }
    public void MoveLeft() throws Exception {
        PieceController.MoveLeft();
        setCounter(PieceController.counter );
        match.setBestMoveResetfield(false);
    }
    public void MoveUp() throws Exception {
        PieceController.MoveUp();
        setCounter(PieceController.counter );
        match.setBestMoveResetfield(false);

    }
    public void MoveDown() throws Exception {
        PieceController.MoveDown();
        setCounter(PieceController.counter );
        match.setBestMoveResetfield(false);
    }
    public void saveMatch() throws Exception {
        MenuController.Save();
    }

    public void loadMatch() throws Exception {
        MenuController.loadMatch();
        setCounter(counter);
        //MatchController.loadSave();
    }

    public void BestMove() throws Exception {
        match = Match.getMatch();
        if (!match.isBestMoveReset()) {
            Back();
            return;
        }
        ArrayList<Solution> solutionList = match.getSolutionList();

        Solution solution = solutionList.get(counter);
        int pieceIndex = solution.getPieceIndex();
        Button piecebutton = PieceController.selection(pieceIndex);
        PieceController.selection(pieceIndex);
        switch (solution.getDirectionMove()){
            case "U":{
                MoveUp();
                match.setBestMoveResetfield(true);
                break;
            }
            case "D":{
                MoveDown();
                match.setBestMoveResetfield(true);
                break;
            }
            case "L":{
                MoveLeft();
                match.setBestMoveResetfield(true);
                break;
            }
            case "R":{
                MoveRight();
                match.setBestMoveResetfield(true);
                break;
            }
            default:{
                match.setBestMoveReset(true);
                System.out.println("should be true");
            }
        }
    }

    public void Quit() {
        MenuController.Quit();
    }

    public void Back() {
        MenuController.Back();
        if(counter!= 0) {
            counter--;
        }
        setCounter(counter);
    }
    public void Reset() throws Exception {
        MenuController.reset();
        PieceController.counter = 0;
        setCounter(counter);
    }
    public void Keyboard(KeyEvent keyEvent) throws Exception {
        PieceController.Keyboard(keyEvent);
        setCounter(PieceController.counter );
    }

    public void Swipe(MouseEvent mouseEvent) throws Exception {
        PieceController.Swipe(mouseEvent);
        setCounter(PieceController.counter );
    }

    public void setCounter(int counter){
        Count.setText("Counter: " + counter);
        match = Match.getMatch();
        match.setCurrentIndex(counter);
    }

}
