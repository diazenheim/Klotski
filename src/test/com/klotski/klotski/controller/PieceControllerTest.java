package com.klotski.klotski.controller;

import com.klotski.klotski.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PieceControllerTest {

    MainController mainController;


    @BeforeAll
    public static void setUpClass() {
        // Initialize JavaFX Toolkit
        Platform.startup(() -> {
            // Any JavaFX initialization or configuration can be done here
        });
    }

    @BeforeEach
    public void setUp() {
        mainController = new MainController();
    }

    @Test
    void testRefresh() throws Exception {
        mainController.initializeButtonArray(false);
        //assertNotNull(pieceController.piece);
        Button button = new Button();
        PieceController.piece = button;
        PieceController.refresh();
        assertNotNull(PieceController.piece);

    }

    @Test
    void testMoveUp() throws Exception {
        mainController.initializeButtonArray(false);
        Button button = new Button();
        PieceController.piece = button;
        PieceController.pieces = new Button[10];
        for (int i = 0; i < 10; i++) {
            PieceController.pieces[i] = new Button();
        }
        PieceController.MoveUp();
        assertEquals(0.0, PieceController.piece.getLayoutY());


    }

    @Test
    void testMoveDown() throws Exception {
        mainController.initializeButtonArray(false);
        Button button = new Button();
        PieceController.piece = button;
        PieceController.pieces = new Button[10];
        for (int i = 0; i < 10; i++) {
            PieceController.pieces[i] = new Button();
        }
        PieceController.MoveDown();
        assertEquals(0.0, PieceController.piece.getLayoutY());
    }


    @Test
    void testMoveLeft() throws Exception {
        mainController.initializeButtonArray(false);
        Button button = new Button();
        PieceController.piece = button;
        PieceController.pieces = new Button[10];
        for (int i = 0; i < 10; i++) {
            PieceController.pieces[i] = new Button();
        }
        PieceController.MoveLeft();
        assertEquals(0.0, PieceController.piece.getLayoutX());
    }


    @Test
    void testMoveRight() throws Exception {
        mainController.initializeButtonArray(false);
        Button button = new Button();
        PieceController.piece = button;
        PieceController.pieces = new Button[10];
        for (int i = 0; i < 10; i++) {
            PieceController.pieces[i] = new Button();
        }
        PieceController.MoveRight();
        assertEquals(0.0, PieceController.piece.getLayoutX());
    }


}