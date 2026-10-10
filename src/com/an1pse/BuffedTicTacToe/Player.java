package com.an1pse.BuffedTicTacToe;

public abstract class Player {
    protected final Piece piece;

    public Player(Piece piece) {
        this.piece = piece;
    }

    public abstract void move(Board board);

    public Piece getPiece() {
        return piece;
    }
}
