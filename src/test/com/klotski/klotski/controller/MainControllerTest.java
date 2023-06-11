package com.klotski.klotski.controller;
import com.klotski.klotski.model.Match;
import com.klotski.klotski.view.LoadMatchAlert;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.klotski.klotski.controller.PieceController.counter;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MainControllerTest {

    private MainController mainController;

    private Text Count= new Text("Counter: 0");

    @BeforeEach
    public void setUp() {
        mainController = new MainController();
    }

    @Test
    public void testInitializeButtonArray() throws Exception {
        mainController.initializeButtonArray(false);
        assertNotNull(PieceController.pieces);
    }

    @Test
    public void testSetCounter() {
        Match match = new Match();
        mainController.match = match;

        int counter = 0;
        mainController.setCounter(counter,Count);

        assertEquals(counter, match.getCurrentIndex());
        assertEquals("Counter: " + counter, Count.getText());
    }

    // Aggiungi altri test per i metodi di MainController che desideri testare

    @Test
    public void reset() throws Exception {
        Match match = new Match();
        mainController.match = match;
        match.setConfiguration("Config 1");

        int counter = 0;
        match.setCurrentIndex(10);
        MenuController.reset();

        assertEquals(counter, match.getCurrentIndex());
    }


    @Test
    public void Back() {
        int counter = 0;
        mainController.Count = new Text();
        mainController.Count.setText("Counter: " + counter);
        PieceController.counter = 0;
        mainController.Back();
        assertEquals(0, PieceController.counter);
        }

}