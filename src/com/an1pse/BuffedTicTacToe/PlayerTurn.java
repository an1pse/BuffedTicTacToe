package com.an1pse.BuffedTicTacToe;

public class PlayerTurn {
    public static Piece determine(Board board) {
        int xCount = 0;
        int oCount = 0;
        var current_board = board.getBoard();

        for (var row : current_board) {
            for (var piece : row) {
               if (piece == Piece.CROSS)
                  xCount++;
               else if (piece == Piece.CIRCLE)
                   oCount++;
            }
        }

        return xCount > oCount ? Piece.CIRCLE : Piece.CROSS;
    }
}
