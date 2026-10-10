package com.an1pse.BuffedTicTacToe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

public class Game {
    public static void main(String[] args) {
        Board board = new Board();
        Player human = setPlayer();
        Player ai = setAIPlayer(human.getPiece());

        while (!Terminal.check(board)) {
            displayBoard(board);
            Piece currentPlayer = PlayerTurn.determine(board);
            if (currentPlayer == ai.getPiece())
                ai.move(board);
            if (currentPlayer == human.getPiece())
                human.move(board);
        }
        displayBoard(board);

        var winner = Winner.check(board);
        if (winner.isPresent()) {
            if (winner.get() == human.getPiece())
                System.out.println("Player wins!");
            if (winner.get() == ai.getPiece())
                System.out.println("AI wins!");
        }
        else
            System.out.println("Draw!");
    }

    private static Player setAIPlayer(Piece humanPiece) {
        return switch (humanPiece) {
            case CROSS -> new AIPlayer(Piece.CIRCLE);
            case CIRCLE -> new AIPlayer(Piece.CROSS);
            default -> throw new RuntimeException("Cannot assign a piece for AI Player.");
        };
    }

    private static Player setPlayer() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Player human;
        try {
            Optional<Piece> piece = Optional.empty();
            while (piece.isEmpty()) {
                System.out.print("Select board piece (X = 1, O = 2): ");
                int select = Integer.parseInt(br.readLine());
                piece = setPlayerPiece(select);
                if (piece.isEmpty())
                    System.out.println("Selection invalid. Please try again");
            }
            human = new HumanPlayer(piece.get());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return human;
    }

    private static Optional<Piece> setPlayerPiece(int selection) {
        return switch (selection) {
            case 1 -> Optional.of(Piece.CROSS);
            case 2 -> Optional.of(Piece.CIRCLE);
            default -> Optional.empty();
        };
    }

    private static void displayBoard(Board board) {
        var boardView = board.getBoard();
        System.out.println("-------------");
        int rowNum = 0;
        for (var row : boardView) {
            char left = row.getFirst() != Piece.EMPTY ? row.getFirst().getPiece() :
                    Character.forDigit(rowNum * 3 + 1, 10);
            char mid = row.get(1) != Piece.EMPTY ? row.get(1).getPiece() :
                    Character.forDigit(rowNum * 3 + 2, 10);
            char right = row.getLast() != Piece.EMPTY ? row.getLast().getPiece() :
                    Character.forDigit(rowNum * 3 + 3, 10);
            System.out.printf("| %c | %c | %c |\n", left, mid, right);
            System.out.println("-------------");
            rowNum++;
        }
    }
}
