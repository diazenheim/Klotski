package com.klotski.klotski.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MoveTest {

    Move mv = new Move();

    @Test
    void getPieceIndex() {

        mv.setPieceIndex(0);
        assertEquals(0, mv.getPieceIndex());
    }

    @Test
    void setPieceIndex() {
        mv.setPieceIndex(0);
        assertEquals(0, mv.getPieceIndex());
    }

    @Test
    void getMoveIndex() {
        mv.setMoveIndex(0);
        assertEquals(0, mv.getMoveIndex());
    }

    @Test
    void setMoveIndex() {
        mv.setMoveIndex(0);
        assertEquals(0, mv.getMoveIndex());
    }

    @Test
    void getOldX() {
        mv.setOldX(0);
        assertEquals(0, mv.getOldX());
    }

    @Test
    void setOldX() {
        mv.setOldX(0);
        assertEquals(0, mv.getOldX());
    }

    @Test
    void getOldY() {
        mv.setOldY(0);
        assertEquals(0, mv.getOldY());
    }

    @Test
    void setOldY() {
        mv.setOldY(0);
        assertEquals(0, mv.getOldY());
    }

    @Test
    void getNewX() {
        mv.setNewX(0);
        assertEquals(0, mv.getNewX());
    }

    @Test
    void setNewX() {
        mv.setNewX(0);
        assertEquals(0, mv.getNewX());
    }

    @Test
    void getNewY() {
        mv.setNewY(0);
        assertEquals(0, mv.getNewY());
    }

    @Test
    void setNewY() {
        mv.setNewY(0);
        assertEquals(0, mv.getNewY());
    }
}