package com.klotski.klotski.controller;
import com.klotski.klotski.model.Match;
import com.klotski.klotski.view.LoadMatchAlert;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        mainController.initializeButtonArray();

        Button[] pieces = PieceController.pieces;

        assertNotNull(pieces);
        assertEquals(10, pieces.length);
        assertNotNull(pieces[0]);
        assertNotNull(pieces[1]);
        assertNotNull(pieces[2]);
        assertNotNull(pieces[3]);
        assertNotNull(pieces[4]);
        assertNotNull(pieces[5]);
        assertNotNull(pieces[6]);
        assertNotNull(pieces[7]);
        assertNotNull(pieces[8]);
        assertNotNull(pieces[9]);
    }

    @Test
    public void testSetCounter() {
        Match match = new Match();
        mainController.match = match;

        int counter = 0;
        mainController.setCounter(counter);

        assertEquals(counter, match.getCurrentIndex());
        assertEquals("Counter: " + counter, Count.getText());
    }

    // Aggiungi altri test per i metodi di MainController che desideri testare

}