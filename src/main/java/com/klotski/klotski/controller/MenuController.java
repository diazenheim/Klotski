package com.klotski.klotski.controller;

import com.klotski.klotski.model.Match;
import com.klotski.klotski.model.Move;
import com.klotski.klotski.view.LoadMatchAlert;
import com.klotski.klotski.view.QuitAlert;
import com.klotski.klotski.view.SaveAlert;
import javafx.scene.control.Button;


import java.util.ArrayList;

public class MenuController {
    private static Match match;


    /*
     * quit method helper
     * */
    public static void quit() {
        match = Match.getMatch();
        if (!match.isSaved()) {
            SaveAlert.display("Save match", "Do you want to save before?", true);
        } else{
            QuitAlert.display("Quit window", "Are you sure you want to quit?");
        }
    }

    /*
     * save method helper
     * */
    public static void save() {
        SaveAlert.display("Save match", "Give a name to your name", false);
    }

    /*
     * loadMatch method helper
     * */
    public static void loadMatch() throws Exception {
        LoadMatchAlert.display("Load match", "Select the match you want to load", "saved");
    }

    /*
     * back method implementation. Iterates backward on movesList array from match instance
     * */
    public static void back() {
        match = Match.getMatch();
        if(match.getCurrentIndex() == 0 ){
            return;
        }
        ArrayList<Move> moves = match.getMovesList();

        Move move = moves.get(moves.size()-1);
        int pieceIndex = move.getPieceIndex();
        Button piecebutton = PieceController.getPieceButton(pieceIndex);
        double newX = move.getOldX();
        double newY = move.getOldY();
        piecebutton.setLayoutX(newX);
        piecebutton.setLayoutY(newY);
        match.removeLastMove(moves.size()-1);
        PieceController.refresh();
    }

    /*
     * reset method helper
     * */
    public static void reset() throws Exception {
        match.reset();
    }

    /*
     * utility log method
     * */
    private static void klotskiLog(String string) {
        System.out.println(string);
    }

}
