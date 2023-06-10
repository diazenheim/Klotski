package com.klotski.klotski.controller;

import com.klotski.klotski.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PieceControllerTest {
    public Button[] pieces;
    public Button piece;
    MainController main = new MainController();

    @BeforeEach
    public void setUp() throws Exception {
        main.initializeButtonArray(false);
        Platform.startup(() ->{

            Button[] pieces = PieceController.pieces;


            System.out.println(pieces[0]);
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

        });
    }

    @Test
    public void testSelection() {
        ActionEvent actionEvent = new ActionEvent(null, null);

        //assertNull(piece.getStyle());

        PieceController.selection(0);

        //assertNull(piece.getStyle());

        assertEquals("-fx-background-color: RED", piece.getStyle());

        PieceController.selection(1);

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