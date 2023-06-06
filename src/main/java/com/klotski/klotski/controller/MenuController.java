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
    public static void Quit() {
        match = Match.getMatch();
        if (!match.isSaved()) {
            SaveAlert.display("Save match", "Do you want to save before?", true);
        } else{
            QuitAlert.display("Quit window", "Are you sure you want to quit?");
        }
    }
    public static void Save() throws Exception {
        SaveAlert.display("Save match", "Give a name to your name", false);
    }
    public static void loadMatch() throws Exception {
        LoadMatchAlert.display("Load match", "Select the match you want to load", "saved");
    }
    public static void Back() {
        match = Match.getMatch();
        if(match.getCurrentIndex() == 0 ){
            return;
        }
        ArrayList<Move> moves = match.getMovesList();

        Move move = moves.get(moves.size()-1);
        int pieceIndex = move.getPieceIndex();
        Button piecebutton = PieceController.getPieceButton(pieceIndex);
        System.out.println(piecebutton);
        double newX = move.getOldX();
        double newY = move.getOldY();
        piecebutton.setLayoutX(newX);
        piecebutton.setLayoutY(newY);
        match.RemoveLastMove(moves.size()-1);
    }
    public static void reset() throws Exception {
        /*match = Match.getMatch();
        ArrayList<Move> moves = match.getMovesList();
        for (int i= moves.size()-1;i >= 0; i--) {
            Move move = moves.get(i);
            int pieceIndex = move.getPieceIndex();
            Button piecebutton = PieceController.getPieceButton(pieceIndex);

            double newX = move.getOldX();
            double newY = move.getOldY();
            piecebutton.setLayoutX(newX);
            piecebutton.setLayoutY(newY);
        }*/
        match.reset();
    }
}
