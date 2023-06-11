package com.klotski.klotski.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution s = new Solution();

    @Test
    void getPieceIndex() {
        s.setPieceIndex(0);
        assertEquals(0, s.getPieceIndex());
    }

    @Test
    void setPieceIndex() {
        s.setPieceIndex(0);
        assertEquals(0, s.getPieceIndex());
    }

    @Test
    void getDirectionMove() {
        s.setDirectionMove("");
        assertEquals("", s.getDirectionMove());
    }

    @Test
    void setDirectionMove() {
        s.setDirectionMove("");
        assertEquals("", s.getDirectionMove());
    }
}