package com.an1pse.BuffedTicTacToe;

public class Utility {
    public static int get(Board board) {
        var winner = Winner.check(board);
        return winner.map(Piece::getRole).orElse(0);
    }
}
