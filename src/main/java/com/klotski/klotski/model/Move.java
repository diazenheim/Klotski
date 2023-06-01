package com.klotski.klotski.model;

public class Move {
    private int pieceIndex;
    private int moveIndex;
    private double oldX;
    private double oldY;
    private double newX;
    private double newY;

    public int getPieceIndex() {
        return pieceIndex;
    }

    public void setPieceIndex(int pieceIndex) {
        this.pieceIndex = pieceIndex;
    }

    public int getMoveIndex() {
        return moveIndex;
    }

    public void setMoveIndex(int moveIndex) {
        this.moveIndex = moveIndex;
    }

    public double getOldX() {
        return oldX;
    }

    public void setOldX(double oldX) {
        this.oldX = oldX;
    }

    public double getOldY() {
        return oldY;
    }

    public void setOldY(double oldY) {
        this.oldY = oldY;
    }

    public double getNewX() {
        return newX;
    }

    public void setNewX(double newX) {
        this.newX = newX;
    }

    public double getNewY() {
        return newY;
    }

    public void setNewY(double newY) {
        this.newY = newY;
    }
}
