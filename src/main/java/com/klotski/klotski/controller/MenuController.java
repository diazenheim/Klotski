package com.klotski.klotski.controller;

import com.klotski.klotski.model.Match;
import com.klotski.klotski.view.LoadMatchAlert;
import com.klotski.klotski.view.QuitAlert;
import com.klotski.klotski.view.SaveAlert;
import javafx.event.ActionEvent;

public class MenuController {
    public void select(ActionEvent e ) {
        System.out.println("s");
    }
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
}
