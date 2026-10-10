package com.an1pse.BuffedTicTacToe;

public class AIPlayer extends Player{
    public AIPlayer(Piece piece) {
        super(piece);
    }

    @Override
    public void move(Board board) {
        System.out.println("AI is thinking...");
        Tile move = Minimax.getMove(board);
        try {
            board.placePiece(piece, move);
        } catch (TileNotEmptyException e) {
            throw new RuntimeException(e);
        }
    }
}
