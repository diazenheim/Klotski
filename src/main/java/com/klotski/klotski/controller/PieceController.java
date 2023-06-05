package com.klotski.klotski.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.klotski.klotski.model.Match;
import com.klotski.klotski.model.Move;
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
    private static double x;
    private static double y;
    // counter of the moves
    public static int counter;

    private static Match match;
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
            if (axes == 0) {
                if (toCheck.getLayoutX() == (selected.getLayoutX()) + selected.getWidth()) {

                    if ((selected.getLayoutY() == toCheck.getLayoutY()) || ((toCheck.getLayoutY() + toCheck.getHeight()) - 100 == selected.getLayoutY()) || selected.getLayoutY() + selected.getHeight() - 100 == toCheck.getLayoutY()) {
                        return false;
                    }
                }
            }
            else if(axes == 1) {
                if (selected.getLayoutY() == toCheck.getLayoutY() + toCheck.getHeight()) {
                    if ((selected.getLayoutX() == toCheck.getLayoutX()) || (toCheck.getLayoutX() + toCheck.getWidth() - 100 == selected.getLayoutX()) || selected.getLayoutX() + selected.getWidth() - 100 == toCheck.getLayoutX()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    // all the movement are controlled by increasing or decreasing (by 100) of the variable X and Y(The Y axis is inverted) after checking the moves is valid.
    public static void MoveUp() throws Exception {
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
    public static void MoveDown() throws Exception {
        if(approving(1,1)) {
            double oldX = piece.getLayoutX();
            double oldY = piece.getLayoutY();
            if(piece.getLayoutY() + piece.getHeight() != 500) {
                piece.setLayoutY(y += 100);
                counter +=1;
                match.getMatch().addMove(createMoveObject(counter - 1, piece, oldX, oldY));
            }
        }
    }
    public static void MoveRight() throws Exception { //move
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
    public static void MoveLeft() throws Exception {
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
    @FXML
    public static void Swipe(MouseEvent mouseEvent) throws Exception {
        double previousX = x;
        double x = mouseEvent.getSceneX();
        double previousY = y;
        double y = mouseEvent.getSceneY();


        if (x < (previousX)) {
            MoveLeft();

        } else if (x > (previousX + 230)) {
            MoveRight();
        }

        if (y < (previousY+50)) {
            MoveUp();

        } else if (y > (previousY + 250)) {
            MoveDown();
        }
    }

    @FXML
    public static void Keyboard(KeyEvent keyEvent) throws Exception {
        KeyCode kc = keyEvent.getCode();
        if (kc == KeyCode.UP) {
            MoveUp();
        } else if (kc == KeyCode.RIGHT) {
            MoveRight();
        } else if (kc == KeyCode.DOWN) {
            MoveDown();
        } else if (kc == KeyCode.LEFT) {
            MoveLeft();
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
