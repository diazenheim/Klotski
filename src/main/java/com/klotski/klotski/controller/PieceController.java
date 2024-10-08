package com.klotski.klotski.controller;

import com.klotski.klotski.model.Match;
import com.klotski.klotski.model.Move;
import com.klotski.klotski.view.WinningAlert;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


class PieceController {
    public static Button[] pieces; //array created to contain the 10 pieces, used in the methode approving to speed up the control of the position of each pieces
    public static Button piece;
    //variable for the moving of the pieces
    public static double x;
    public static double y;
    // counter of the moves
    public static int counter;

    private static Match match;
    //method used for the selection of the pieces you want to use, when the piece is clicked is selected
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


    /*
     * selection method overload
     * */
    public static Button selection(int pieceIndex){
        if(piece != null) {
            piece.setStyle(null);
        }

        piece = getPieceButton(pieceIndex);

        refresh();
        if(piece == pieces[0]){
            piece.setStyle("-fx-background-color: RED");
        }
        else {
            piece.setStyle("-fx-background-color: BLUE");
        }
        return  piece;
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
            if (axes == 0) {
                if (toCheck.getLayoutX() == (selected.getLayoutX()) + selected.getPrefWidth()) {

                    if ((selected.getLayoutY() == toCheck.getLayoutY()) || ((toCheck.getLayoutY() + toCheck.getPrefHeight()) - 100 == selected.getLayoutY()) || selected.getLayoutY() + selected.getPrefHeight() - 100 == toCheck.getLayoutY()) {
                        return false;
                    }
                }
            }
            else if(axes == 1) {
                if (selected.getLayoutY() == toCheck.getLayoutY() + toCheck.getPrefHeight()) {
                    if ((selected.getLayoutX() == toCheck.getLayoutX()) || (toCheck.getLayoutX() + toCheck.getPrefWidth() - 100 == selected.getLayoutX()) || selected.getLayoutX() + selected.getPrefWidth() - 100 == toCheck.getLayoutX()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    // all the movement are controlled by increasing or decreasing (by 100) of the variable X and Y(The Y axis is inverted) after checking the moves is valid.

    /*
     * moveUp method implementation
     * */
    public static void moveUp() throws Exception {
        if(approving(0,1)) {
            double oldX = piece.getLayoutX();
            double oldY = piece.getLayoutY();
            if (piece.getLayoutY() != 0) {
                piece.setLayoutY(y -= 100);
                counter +=1;
                match.getMatch().addMove(createMoveObject(counter - 1, piece, oldX, oldY));
            }
        }

    }

    /*
     * moveDown method implementation
     * */
    public static void moveDown() throws Exception {
        if(approving(1,1)) {
            double oldX = piece.getLayoutX();
            double oldY = piece.getLayoutY();
            if(piece.getLayoutY() + piece.getHeight() != 500) {
                piece.setLayoutY(y += 100);
                counter +=1;
                match.getMatch().addMove(createMoveObject(counter - 1, piece, oldX, oldY));
            }
            if(piece.getId() == pieces[0].getId() && piece.getLayoutX() == 100 && piece.getLayoutY() == 300){

                WinningAlert.display("YOU WIN","YOU WIN");
            }
        }
    }

    /*
     * moveRight method implementation
     * */
    public static void moveRight() throws Exception { //move
        if(approving(0,0)){
            double oldX = piece.getLayoutX();
            double oldY = piece.getLayoutY();
            if(piece.getLayoutX() + piece.getWidth() != 400) {
                piece.setLayoutX(x += 100);
                counter +=1;
                match.getMatch().addMove(createMoveObject(counter - 1, piece, oldX, oldY));
            }
        }
    }

    /*
     * moveLeft method implementation
     * */
    public static void moveLeft() throws Exception {
        if(approving(1,0)) {
            double oldX = piece.getLayoutX();
            double oldY = piece.getLayoutY();
            if (piece.getLayoutX() != 0) {
                piece.setLayoutX(x -= 100);
                counter +=1;
                match.getMatch().addMove(createMoveObject(counter - 1, piece, oldX, oldY));
            }
        }
    }
    //let use the mouse to move the pieces
    @FXML
    public static void swipe(MouseEvent mouseEvent) throws Exception {
        double previousX = x;
        double x = mouseEvent.getSceneX();
        double previousY = y;
        double y = mouseEvent.getSceneY();


        if (x < (previousX)) {
            moveLeft();
            match.setBestMoveResetfield(false);

        } else if (x > (previousX + 230)) {
            moveRight();
            match.setBestMoveResetfield(false);
        }

        if (y < (previousY+50)) {
            moveUp();
            match.setBestMoveResetfield(false);

        } else if (y > (previousY + 250)) {
            moveDown();
            match.setBestMoveResetfield(false);
        }
    }
    //let use the keyboard to move the pieces
    @FXML
    public static void keyboard (KeyEvent keyEvent) throws Exception {
        KeyCode kc = keyEvent.getCode();
        if (kc == KeyCode.UP) {
            moveUp();
            match.setBestMoveResetfield(false);
        } else if (kc == KeyCode.RIGHT) {
            moveRight();
            match.setBestMoveResetfield(false);
        } else if (kc == KeyCode.DOWN) {
            moveDown();
            match.setBestMoveResetfield(false);
        } else if (kc == KeyCode.LEFT) {
            moveLeft();
            match.setBestMoveResetfield(false);
        }
    }

    //create Move object to add to Match object to keep track of all moves
    private static Move createMoveObject(int moveIndex, Button button, double oldX, double oldY) throws Exception{
        var move = new Move();

        int pieceIndex = getPieceIndex(button);
        if (pieceIndex >= 0){

            move.setPieceIndex(pieceIndex);
            move.setMoveIndex(counter);
            move.setNewX(button.getLayoutX());
            move.setNewY(button.getLayoutY());
            move.setOldX(oldX);
            move.setOldY(oldY);
        } else{
            throw new Exception("Piece not found!");
        }
        //MatchController.getJsonString(move);

        return move;
    }

    //utility method to get the piece index in the array of pieces
    private static int getPieceIndex(Button button){
        for (int i = 0; i < pieces.length; i++){
            if (pieces[i] == button){
                return i;
            }
        }
        return -1;
    }
    //utility method to get the piece index in the array of pieces
    public static Button getPieceButton(int index){
        return pieces[index];
    }

    private static void klotskiLog(String string) {
        System.out.println(string);
    }

}
