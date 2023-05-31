package com.klotski.klotski.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class PieceController {
    //call the objects with id from view.fxml in here
    @FXML
    public Button pc0,pc1,pc2,pc3,pc4,pc5,pc6,pc7,pc8,pc9;
    @FXML
    private Text Count;
    // create variables used in the methods
    public Button[] pieces = new Button[10]; //array created to contain the 10 pieces, used in the methode approving to speed up the control of the position of each pieces
    private Button piece= null;//generic button
    private int counter; //counter for the moves made
    // used for taking the info of the position x and y of the selected button
    private double x;
    private double y;

    //Direct function
    public void select(ActionEvent e) { //selecting the button to move
        if(piece != null) {
            piece.setStyle(null);
        }

        piece = (Button) e.getSource();

        refresh();
        if(piece == pc0){
            pc0.setStyle("-fx-background-color: RED");
        }
        else {
            piece.setStyle("-fx-background-color: BLUE");
        }
    }
    // all the movement are controlled by increasing or decreasing (by 100) of the variable X and Y(The Y axis is inverted) after checking the moves is valid.
    public void MoveRight(ActionEvent e) { //move
        if(approving(0,0)){
            if(piece.getLayoutX() + piece.getWidth() != 400) {
                piece.setLayoutX(x += 100);
                counter +=1;
                Count.setText("Counter: " + counter );
            }
        }
    }
    public void MoveLeft(ActionEvent e) {
        if(approving(1,0)) {
            if (piece.getLayoutX() != 0) {
                piece.setLayoutX(x -= 100);
                counter +=1;
                Count.setText("Counter: " + counter );
            }
        }
    }
    public void MoveUp(ActionEvent e) {
        if(approving(0,1)) {
            if (piece.getLayoutY() != 0) {
                piece.setLayoutY(y -= 100);
                counter +=1;
                Count.setText("Counter: " + counter );
            }
        }
    }
    public void MoveDown(ActionEvent e) {
        if(approving(1,1)) {
            if(piece.getLayoutY() + piece.getHeight() != 500) {
                piece.setLayoutY(y += 100);
                counter +=1;
                Count.setText("Counter: " + counter );
            }
        }
    }
    public void Save(ActionEvent e) {
    }

    public void LoadSave(ActionEvent e) {
    }

    public void BestMove(ActionEvent e) {
    }

    public void Quit(ActionEvent e) {
    }

    public void Back(ActionEvent e) {
    }
    //indirect function

    //refresh allow uor variable x and y to start with the right starting X and Y of the button
    public void refresh(){ // refreshing the x and y variables, and inserting the pieces into the array
        x = piece.getLayoutX();
        y= piece.getLayoutY();
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
    private boolean approving(int a,int axes){ // control that there isn't another pieces in the way with the move axes refer to the x and y and a refers to right/left if is in the x axes and up/down if in the y axes
        if(piece == null){
            return false;
        }
        for (int i =0; i < 10;i++ ) {
            Button selected = piece;
            Button toCheck = pieces[i];
            if (a == 1) {
                selected = pieces[i];
                toCheck = piece;
            }
            if (axes == 0 && toCheck.getLayoutX() == (selected.getLayoutX()) + selected.getWidth()) {
                if ((selected.getLayoutY() == toCheck.getLayoutY()) || ((toCheck.getLayoutY() + toCheck.getHeight()) - 100 == selected.getLayoutY())) {
                    return false;
                }
            }
            else if (axes == 1 && selected.getLayoutY() == (toCheck.getLayoutY()) + toCheck.getHeight()) {
                if ((selected.getLayoutX() == toCheck.getLayoutX()) || (toCheck.getLayoutX() + toCheck.getWidth() - 100 == selected.getLayoutX())) {
                    return false;
                }
            }

        }
        return true;
    }


}