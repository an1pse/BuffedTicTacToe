package com.an1pse.BuffedTicTacToe;

public class Result {
    public static Board makeMove(Board board, Tile action) {
        Piece currentPlayer = PlayerTurn.determine(board);
        Board boardCopy = new Board(board);
        try {
            boardCopy.placePiece(currentPlayer, action);
        } catch (TileNotEmptyException e) {
            throw new RuntimeException(e);
        }
        return boardCopy;
    }
}
