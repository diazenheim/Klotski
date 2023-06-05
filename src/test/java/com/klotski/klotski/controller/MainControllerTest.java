package com.klotski.klotski.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.klotski.klotski.model.Match;

class MainControllerTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void initialize() {
    }

    @Test
    void initializeButtonArray() {
    }

    @Test
    void select() {
    }

    @Test
    void moveRight() {
    }

    @Test
    void moveLeft() {
    }

    @Test
    void moveUp() {
    }

    @Test
    void moveDown() {
    }

    @Test
    void saveMatch() {
    }

    @Test
    void loadMatch() throws Exception {
        Match match = new Match();
        MainController main = new MainController();
        main.initialize();
        MatchController.loadMatch("cane", "saved");
        assertEquals(match.getMatchName(), "cane");
    }

    @Test
    void bestMove() throws Exception {
    }

    @Test
    void quit() {
    }

    @Test
    void back() {
    }

    @Test
    void keyboard() {
    }

    @Test
    void swipe() {
    }

    @Test
    void setCounter() {
    }
}