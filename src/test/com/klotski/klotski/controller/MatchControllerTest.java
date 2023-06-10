package com.klotski.klotski.controller;

import com.klotski.klotski.model.Match;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatchControllerTest {
    //testing the loading of a file
    @Test
    void testLoadMatch() throws Exception {
        Match match = new Match();
        MatchController.loadMatch("New_Match", "saved");
        assertEquals(match.getMatchName(), "New_Match");
    }

    @Test
    void testSaveMatch() throws Exception {
        Match match = new Match();
        MatchController.loadMatch("New_Match", "saved");
        MatchController.saveMatch();
        assertEquals("New_Match", match.getMatchName());
    }

}