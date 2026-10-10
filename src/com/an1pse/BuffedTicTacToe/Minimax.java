package com.an1pse.BuffedTicTacToe;

public class Minimax {
    public static Tile getMove(Board board) {
        Piece player = PlayerTurn.determine(board);
        var options = board.getEmpty();
        float prevVal = 0.0f;
        for (Tile option : options) {
           if (player == Piece.CROSS) {
               float optUtil = minVal(Result.makeMove(board, option));
               if (optUtil > prevVal)
                   return option;
               prevVal = optUtil;
           } else if (player == Piece.CIRCLE) {
               float optUtil = maxVal(Result.makeMove(board, option));
               if (optUtil < prevVal)
                   return option;
               prevVal = optUtil;
           }
        }
        return options.getFirst();
    }

    private static float maxVal(Board board) {
        if (Terminal.check(board))
            return (float) Utility.get(board);
        float v = Float.NEGATIVE_INFINITY;
        for (Tile action : board.getEmpty())
            v = Float.max(v, minVal(Result.makeMove(board, action)));
        return v;
    }

    private static float minVal(Board board) {
        if (Terminal.check(board))
            return (float) Utility.get(board);
        float v = Float.POSITIVE_INFINITY;
        for (Tile action : board.getEmpty())
            v = Float.min(v, maxVal(Result.makeMove(board, action)));
        return v;
    }
}
