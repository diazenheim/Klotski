package com.klotski.klotski.model;

import com.klotski.klotski.controller.MatchController;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

/*
 * Match Class to create match Singleton instance. The Match object always contains all the meaningful
 * information regarding a game: mane, starterconfiguration, list of moves, solution and other helper attributes
 * */

//the following annotation is needed to allow the Jackson library to convert the match configuration to a POJO ignoring the missing fields in the Match configuration
@JsonIgnoreProperties(ignoreUnknown = true)

public class Match {
    private static Match instance;
    private static int currentIndex;
    private static String matchName;
    private static ArrayList<Move> moves;
    private static ArrayList<Solution> solution;
    private static boolean saved;
    private static String configuration;
    private static boolean bestMoveReset;

    public Match() {
        currentIndex = 0;
        matchName = "New_Match";
        moves = new ArrayList<Move>();
        solution = new ArrayList<Solution>();
        saved = false;
        bestMoveReset = true;
    }

    public static Match getMatch(){
        if (instance == null){
            instance = new Match();
        }
        return instance;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public ArrayList<Move> getMovesList() {
        return moves;
    }

    public void setMovesList(ArrayList<Move> moves) {
        this.moves = moves;
    }

    public ArrayList<Solution> getSolutionList() {
        return solution;
    }

    public void setSolutionList(ArrayList<Solution> solution) {
        Match.solution = solution;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    //reset instance and reload initial configuration
    public static void reset() throws Exception {
        currentIndex = 0;
        matchName = "New_Match";
        moves = new ArrayList<Move>();
        bestMoveReset = true;
        MatchController.loadMatch(configuration, "configuration");
    }

    //add a move to the movesList array
    public void addMove(Move move){
        moves.add(move);
        ++this.currentIndex;
        if (this.saved){
            this.saved = false;
        }
    }

    //remove last move from the movesList array
    public static void removeLastMove(int index){
        moves.remove(index);
        --currentIndex;
        if (currentIndex == 0){
            bestMoveReset = true;
        }
    }
    public String getConfiguration(){
        return configuration;
    }
    public void setConfiguration(String conf){
        configuration = conf;
    }

    public boolean isBestMoveReset() {
        return bestMoveReset;
    }

    public void setBestMoveReset(boolean bestMoveReset) {
        Match.bestMoveReset = bestMoveReset;
    }
    public static void setBestMoveResetfield(boolean bestMoveReset) {
        Match.bestMoveReset = bestMoveReset;
    }
}
