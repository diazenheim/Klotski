package com.klotski.klotski.controller;

import com.klotski.klotski.model.AlertBox;
import javafx.event.ActionEvent;

public class MenuController {
    public void select(ActionEvent e ) {
        System.out.println("s");
    }

    public static void Quit() {
        AlertBox.display("Quit window", "Are you sure you want to quit?");
        //System.out.println("Hai clickato il bottone Quit");
    }
}
