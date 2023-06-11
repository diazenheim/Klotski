package com.klotski.klotski.model;

/*
* Solution Class helper to be able to read solutions in JSON object from the match file
* */
public class Solution {
    private int pieceIndex;
    private String directionMove;

    public int getPieceIndex() {
        return pieceIndex;
    }

    public void setPieceIndex(int pieceIndex) {
        this.pieceIndex = pieceIndex;
    }

    public String getDirectionMove() {
        return directionMove;
    }

    public void setDirectionMove(String directionMove) {
        this.directionMove = directionMove;
    }
}
