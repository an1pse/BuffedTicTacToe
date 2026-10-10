package com.an1pse.BuffedTicTacToe;

public class Terminal {
    public static boolean check(Board board) {
        int emptyCount = board.getEmpty().size();
        var winner = Winner.check(board);
        return (emptyCount == 0 || winner.isPresent());
    }
}
