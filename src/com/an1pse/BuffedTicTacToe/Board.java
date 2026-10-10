package com.an1pse.BuffedTicTacToe;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Board {
    private static final int rows = 3;
    private static final int tiles = 3;
    private List<List<Piece>> board = new ArrayList<>();

    public Board() {
        for (int j = 0; j < rows; j++) {
            List<Piece> row = new ArrayList<>();
            for (int i = 0; i < tiles; i++) {
                row.add(Piece.EMPTY);
            }
            board.add(row);
        }
    }

    public Board(Board other) {
        this(other.getBoard());
    }

    private Board(List<List<Piece>> otherBoard) {
        board = new ArrayList<>();
        for (var row : otherBoard) {
            board.add(new ArrayList<>(row));
        }
    }

    public void placePiece(Piece piece, Tile tile) throws TileNotEmptyException {
        if (board.get(tile.x()).get(tile.y()) != Piece.EMPTY) {
            throw new TileNotEmptyException("Selected tile is taken.");
        }
        board.get(tile.x()).set(tile.y(), piece);
    }

    public List<List<Piece>> getBoard() {
        return board.stream().map(List::copyOf).toList();
    }

    public int getRows() { return rows; }

    public int getTiles() { return tiles; }

    public List<Tile> getEmpty() {
        List<Tile> emptyTiles = new ArrayList<>();
        for (int j = 0; j < rows; j++) {
            for (int i = 0; i < tiles; i++) {
                if (board.get(i).get(j) == Piece.EMPTY)
                    emptyTiles.add(new Tile(i, j));
            }
        }
        return emptyTiles;
    }
}
