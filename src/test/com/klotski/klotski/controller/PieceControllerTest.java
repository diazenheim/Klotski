package com.klotski.klotski.controller;

import javafx.application.Platform;
import javafx.scene.control.Button;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.klotski.klotski.controller.PieceController.pieces;
import static org.junit.jupiter.api.Assertions.*;

class PieceControllerTest {

    MainController mainController;


    @BeforeAll
    public static void setUpClass() {
        // Initialize JavaFX Toolkit
        Platform.startup(() -> {

        });
    }


    @BeforeEach
    public void setUp() {
        mainController = new MainController();
    }

    @Test
    void testRefresh() {

        //assertNotNull(pieceController.piece);
        Button button = new Button();
        PieceController.piece = button;
        PieceController.refresh();
        assertEquals(PieceController.piece.getLayoutX(),PieceController.x);

    }
    @Test
    void testMoveUp() throws Exception {

        Button button = new Button();
        PieceController.piece = button;
        pieces = new Button[10];
        for (int i = 0; i < 10; i++) {
            pieces[i] = new Button();
            pieces[i].setLayoutY(0);
            pieces[i].setLayoutX(0);
        }
        PieceController.piece = pieces[1];
        PieceController.piece.setPrefHeight(100);
        PieceController.piece.setPrefWidth(100);
        PieceController.moveUp();
        assertEquals(-0, PieceController.piece.getLayoutY());


    }
    @Test
    void testMoveDown() throws Exception {

        Button button = new Button();
        PieceController.piece = button;
        pieces = new Button[10];
        for (int i = 0; i < 10; i++) {
            pieces[i] = new Button();
            pieces[i].setLayoutY(0);
            pieces[i].setLayoutX(0);
        }
        PieceController.piece = pieces[1];
        PieceController.piece.setPrefHeight(100);
        PieceController.piece.setPrefWidth(100);
        PieceController.moveDown();
        assertEquals(100, PieceController.piece.getLayoutY());
    }
    @Test
    void testMoveLeft() throws Exception {

        Button button = new Button();
        PieceController.piece = button;
        pieces = new Button[10];
        for (int i = 0; i < 10; i++) {
            pieces[i] = new Button();
            pieces[i].setLayoutY(0);
            pieces[i].setLayoutX(0);
        }
        PieceController.piece = pieces[1];
        PieceController.piece.setPrefHeight(100);
        PieceController.piece.setPrefWidth(100);
        PieceController.moveLeft();
        assertEquals(0, PieceController.piece.getLayoutX());
    }
    @Test
    void testMoveRight() throws Exception {
        Button button = new Button();
        PieceController.piece = button;
        pieces = new Button[10];
        for (int i = 0; i < 10; i++) {
            pieces[i] = new Button();
            pieces[i].setLayoutY(0);
            pieces[i].setLayoutX(0);
        }
        PieceController.piece = pieces[1];
        PieceController.piece.setPrefHeight(100);
        PieceController.piece.setPrefWidth(100);
        PieceController.moveRight();
        assertEquals(100, PieceController.piece.getLayoutX());
    }

}