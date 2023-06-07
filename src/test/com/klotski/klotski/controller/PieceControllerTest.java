package com.klotski.klotski.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PieceControllerTest {
    public Button[] pieces;
    public Button piece;

    @BeforeEach
    public void setUp() {
        pieces = new Button[3];
        for (int i = 0; i < pieces.length; i++) {
            pieces[i] = new Button("Piece " + i);
        }
        piece = pieces[1];
    }

    @Test
    public void testSelection() {
        ActionEvent actionEvent = new ActionEvent(null, null);

        assertNull(piece.getStyle());

        PieceController.selection(actionEvent);

        assertNull(piece.getStyle());

        piece = pieces[0];
        PieceController.selection(actionEvent);

        assertEquals("-fx-background-color: RED", piece.getStyle());

        piece = pieces[2];
        PieceController.selection(actionEvent);

        assertEquals("-fx-background-color: BLUE", piece.getStyle());
    }

    @Test
    public void testApproving() {
        PieceController.piece = pieces[0];
        pieces[0].setLayoutX(100);
        pieces[0].setLayoutY(100);

        assertFalse(PieceController.approving(0, 0));
        assertFalse(PieceController.approving(1, 0));
        assertFalse(PieceController.approving(0, 1));
        assertFalse(PieceController.approving(1, 1));

        pieces[0].setLayoutX(200);

        assertTrue(PieceController.approving(0, 0));
        assertFalse(PieceController.approving(1, 0));
        assertFalse(PieceController.approving(0, 1));
        assertFalse(PieceController.approving(1, 1));

        pieces[0].setLayoutX(100);
        pieces[0].setLayoutY(200);

        assertFalse(PieceController.approving(0, 0));
        assertFalse(PieceController.approving(1, 0));
        assertFalse(PieceController.approving(0, 1));
        assertFalse(PieceController.approving(1, 1));

        pieces[0].setLayoutY(100);

        assertFalse(PieceController.approving(0, 0));
        assertTrue(PieceController.approving(1, 0));
        assertFalse(PieceController.approving(0, 1));
        assertFalse(PieceController.approving(1, 1));
    }

    // Aggiungi altri test per gli altri metodi della classe PieceController

}