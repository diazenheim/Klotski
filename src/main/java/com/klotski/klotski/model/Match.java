package com.klotski.klotski.model;

import java.util.ArrayList;

public class Match {
    private static Match instance;
    private static int currentIndex;
    private static String matchName;
    private static ArrayList<Move> moves;
    private boolean saved;
    private int configuration;

    public Match() {
        currentIndex = 0;
        matchName = "New Match";
        moves = new ArrayList<Move>();
        saved = false;
        configuration = 0;
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

    public static void reset(){
        currentIndex = 0;
        matchName = "New Match";
        moves = new ArrayList<Move>();
    }

    public void addMove(Move move){
        moves.add(move);
        ++currentIndex;
        if (this.saved){
            this.saved = false;
        }
    }
    public static void RemoveLastMove(int index){
        Move scarto = moves.remove(index);
        --currentIndex;
    }
    public int getConfiguration(){
        return configuration;
    }
    public void setConfiguration(int conf){
        configuration = conf;
    }
}
