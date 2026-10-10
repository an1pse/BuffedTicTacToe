package com.an1pse.BuffedTicTacToe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Winner {
    private static Optional<Piece> checkRows(Board board) {
        var current_board = board.getBoard();
        for (var row : current_board) {
            if (row.stream().allMatch(piece -> piece == Piece.CROSS))
                return Optional.of(Piece.CROSS);
            if (row.stream().allMatch(piece -> piece == Piece.CIRCLE))
                return Optional.of(Piece.CIRCLE);
        }
        return Optional.empty();
    }

    private static Optional<Piece> checkColumns(Board board) {
        var current_board = board.getBoard();
        for (int column = 0; column < board.getRows(); column++) {
            List<Piece> current_column = new ArrayList<>();
            for (int tile = 0; tile < board.getTiles(); tile++) {
                current_column.add(current_board.get(tile).get(column));
            }

            if (current_column.stream().allMatch(piece -> piece == Piece.CROSS))
                return Optional.of(Piece.CROSS);
            if (current_column.stream().allMatch(piece -> piece == Piece.CIRCLE))
                return Optional.of(Piece.CIRCLE);
        }
        return Optional.empty();
    }

    private static Optional<Piece> checkDiags(Board board) {
        var currentBoard = board.getBoard();
        Piece[] diag1 = {
            currentBoard.getFirst().getFirst(),
            currentBoard.get(1).get(1),
            currentBoard.getLast().getLast()
        };

        Piece[] diag2 = {
            currentBoard.getFirst().getLast(),
            currentBoard.get(1).get(1),
            currentBoard.getLast().getFirst()
        };

        if (Arrays.stream(diag1).allMatch(piece -> piece == Piece.CROSS))
            return Optional.of(Piece.CROSS);
        else if (Arrays.stream(diag1).allMatch(piece -> piece == Piece.CIRCLE))
            return Optional.of(Piece.CIRCLE);

        if (Arrays.stream(diag2).allMatch(piece -> piece == Piece.CROSS))
            return Optional.of(Piece.CROSS);
        else if (Arrays.stream(diag2).allMatch(piece -> piece == Piece.CIRCLE))
            return Optional.of(Piece.CIRCLE);

        return Optional.empty();
    }

    public static Optional<Piece> check(Board board) {
        var row = checkRows(board);
        var column = checkColumns(board);
        var diag = checkDiags(board);

        if (row.isPresent())
            return row;
        else if (column.isPresent())
            return column;
        else if (diag.isPresent())
            return diag;
        return Optional.empty();
    }
}
