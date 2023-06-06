package com.klotski.klotski.model;

import com.klotski.klotski.controller.MatchController;

import java.util.ArrayList;

public class Match {
    private static Match instance;
    private static int currentIndex;
    private static String matchName;
    private static ArrayList<Move> moves;
    private static boolean saved;
    private static String configuration;

    public Match() {
        currentIndex = 0;
        matchName = "New Match";
        moves = new ArrayList<Move>();
        saved = false;
        configuration = "";
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

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public static void reset() throws Exception {
        currentIndex = 0;
        matchName = "New Match";
        moves = new ArrayList<Move>();
        MatchController.loadMatch(getConfiguration(), "configuration");
    }

    public void addMove(Move move){
        moves.add(move);
        ++this.currentIndex;
        if (this.saved){
            this.saved = false;
        }
    }
    public static void RemoveLastMove(int index){
        moves.remove(index);
        --currentIndex;
    }
    public static String getConfiguration(){
        return configuration;
    }
    public void setConfiguration(String conf){
        configuration = conf;
    }
}
