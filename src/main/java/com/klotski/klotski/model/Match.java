package com.klotski.klotski.model;

public class Match {
    private static Match instance;
    private int currentIndex;
    private String matchName;
    private Move[] moves;

    public Match() {
        currentIndex = 0;
        matchName = "New Match";
        moves = new Move[9999];
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

    public Move[] getMoves() {
        return moves;
    }

    public void setMoves(Move[] moves) {
        this.moves = moves;
    }
}
