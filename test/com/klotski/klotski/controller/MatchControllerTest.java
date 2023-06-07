package com.klotski.klotski.controller;

import com.klotski.klotski.model.Match;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchControllerTest {

    @Test
    void testSaveMatch() throws Exception {
        Match match = new Match();
        match.getMatchName();
        MatchController.saveMatch();
        assertEquals(match.getMatchName(), "New Match");
    }

    @Test
    void loadMatch() {
    }
}