package com.klotski.klotski.controller;

import com.klotski.klotski.model.Match;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MatchControllerTest {

    //testing the method saveMatch
    @Test
    void testSaveMatch() throws Exception {
        Match match = new Match();
        MatchController.saveMatch();
        assertEquals("New_Match", match.getMatchName());
    }

    //testing the method loadMatch that loads a saved match
    @Test
    void testLoadMatchSaved() throws Exception {
        Match match = new Match();
        MatchController.loadMatch("New_Match", "saved");
        assertEquals(match.getMatchName(), "New_Match");
    }
    //testing the method loadMatch that loads a configuration
    @Test
    void testLoadMConfiguration() throws Exception {
        Match match = new Match();
        MatchController.loadMatch("Config 1", "configuration");
        assertEquals(match.getMatchName(), "Config 1");
    }


}