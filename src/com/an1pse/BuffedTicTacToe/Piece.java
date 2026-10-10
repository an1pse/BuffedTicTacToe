package com.an1pse.BuffedTicTacToe;

public enum Piece {
    CROSS('X', 1),
    CIRCLE('O', -1),
    EMPTY(' ' , 0);

    private final char piece;
    private final int role;

    Piece(char piece, int role) {
        this.piece = piece;
        this.role = role;
    }

    public char getPiece() { return piece; }

    public int getRole() { return role; }
}
