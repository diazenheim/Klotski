package com.klotski.klotski.model;

import java.util.ArrayList;

public class Match {
    private static Match instance;
    private int currentIndex;
    private String matchName;
    private ArrayList<Move> moves;
    private boolean saved;

    public Match() {
        currentIndex = 0;
        matchName = "New Match";
        moves = new ArrayList<Move>();
        saved = false;
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

    public void reset(){
        this.currentIndex = 0;
        this.matchName = "New Match";
        this.moves = new ArrayList<Move>();
    }

    public void addMove(Move move){
        this.moves.add(move);
        ++this.currentIndex;
    }
}
