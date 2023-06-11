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
        initializeButtonArray(true);
    }

    /*
     * Initialization or the array of Buttons which reside in the board and refers to the pieces.
     **/
    Match match;
    public void initializeButtonArray(boolean loadAlert) throws Exception {
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

        if (loadAlert){
            LoadMatchAlert.display("Load Configuration", "Warm welcome to our application!\n" +
                    "Choose the configuration to start with or leave the default one.", "configuration");
        }
    }
    public void select(ActionEvent e) { //selecting the button to move
        selection(e);
    }
    /*
     * all the movements are controlled by increasing or decreasing (by 100) of the variable X and Y(The Y axis is inverted) after checking the moves is valid.
     *
     * MoveRight helper
     **/
    public void moveRight() throws Exception {
        PieceController.moveRight();
        setCounter(PieceController.counter, Count );
        match.setBestMoveResetfield(false);
    }

    /*
     * MoveLeft helper
     **/
    public void moveLeft() throws Exception {
        PieceController.moveLeft();
        setCounter(PieceController.counter, Count );
        match.setBestMoveResetfield(false);
    }

    /*
     * MoveUp helper
     **/
    public void moveUp() throws Exception {
        PieceController.moveUp();
        setCounter(PieceController.counter, Count );
        match.setBestMoveResetfield(false);

    }

    /*
     * MoveDown helper
     **/
    public void moveDown() throws Exception {
        PieceController.moveDown();
        setCounter(PieceController.counter, Count );
        match.setBestMoveResetfield(false);
    }

    /*
    * Save match helper
    **/
    public void saveMatch() {
        MenuController.save();
    }

    /*
    * Load match helper, calls loadMatch implementation and set the counter.
    * */
    public void loadMatch() throws Exception {
        MenuController.loadMatch();
        setCounter(counter, Count);
        //MatchController.loadSave();
    }

    /*
    *best move implementation, the method usess the 'bestMoveReset' attribute inside the match object
    *to know if proceed forward through solution array inside match o to go back
    **/

    public void bestMove() throws Exception {
        match = Match.getMatch();
        if (!match.isBestMoveReset()) {
            back();
            return;
        }
        ArrayList<Solution> solutionList = match.getSolutionList();

        Solution solution = solutionList.get(counter);
        int pieceIndex = solution.getPieceIndex();
        PieceController.selection(pieceIndex);
        switch (solution.getDirectionMove()){
            case "U":{
                moveUp();
                match.setBestMoveResetfield(true);
                break;
            }
            case "D":{
                moveDown();
                match.setBestMoveResetfield(true);
                break;
            }
            case "L":{
                moveLeft();
                match.setBestMoveResetfield(true);
                break;
            }
            case "R":{
                moveRight();
                match.setBestMoveResetfield(true);
                break;
            }
            default:{
                match.setBestMoveReset(true);
            }
        }
    }

    public void quit() {
        MenuController.quit();
    }

    public void back() {
        MenuController.back();
        if(counter!= 0) {
            counter--;
        }
        setCounter(counter, Count);
    }
    public void reset() throws Exception {
        MenuController.reset();
        PieceController.counter = 0;
        setCounter(counter, Count);
    }
    public void keyboard(KeyEvent keyEvent) throws Exception {
        PieceController.keyboard(keyEvent);
        setCounter(PieceController.counter,Count );
    }

    public void swipe(MouseEvent mouseEvent) throws Exception {
        PieceController.swipe(mouseEvent);
        setCounter(PieceController.counter,Count);
    }

    public void setCounter(int counter,Text count){
        count.setText("Counter: " + counter);
        match = Match.getMatch();
        match.setCurrentIndex(counter);
    }

}
