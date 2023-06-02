package com.klotski.klotski.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

class PiecesController {
    public static Button[] pieces; //array created to contain the 10 pieces, used in the methode approving to speed up the control of the position of each pieces
    public static Button piece;
    //variable for the moving of the pieces
    private static double x;
    private static double y;
    // counter of the moves
    public static int counter;

    //methode used for the selection of the pieces you want to use, when the piece is clicked is selected
    public static void selection(ActionEvent e){
        if(piece != null) {
            piece.setStyle(null);
        }

        piece = (Button) e.getSource();

        refresh();
        if(piece == pieces[0]){
            piece.setStyle("-fx-background-color: RED");
        }
        else {
            piece.setStyle("-fx-background-color: BLUE");
        }
    }
    //refresh allow uor variable x and y to start with the right starting X and Y of the button
    public static void refresh(){ // refreshing the x and y variables, and inserting the pieces into the array
        x= piece.getLayoutX();
        y= piece.getLayoutY();
    }
    //helping function to check if there the move is ok to be done
    public static boolean approving(int a,int axes){ // control that there isn't another pieces in the way with the move axes refer to the x and y and a refers to right/left if is in the x axes and up/down if in the y axes
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
    // all the movement are controlled by increasing or decreasing (by 100) of the variable X and Y(The Y axis is inverted) after checking the moves is valid.
    public static void MoveUp() {
        if(approving(0,1)) {
            if (piece.getLayoutY() != 0) {
                piece.setLayoutY(y -= 100);
                counter +=1;
            }
        }
    }
    public static void MoveDown() {
        if(approving(1,1)) {
            if(piece.getLayoutY() + piece.getHeight() != 500) {
                piece.setLayoutY(y += 100);
                counter +=1;
            }
        }
    }
    public static void MoveRight() { //move
        if(approving(0,0)){
            if(piece.getLayoutX() + piece.getWidth() != 400) {
                piece.setLayoutX(x += 100);
                counter +=1;
            }
        }
    }
    public static void MoveLeft() {
        if(approving(1,0)) {
            if (piece.getLayoutX() != 0) {
                piece.setLayoutX(x -= 100);
                counter +=1;}
        }
    }
}