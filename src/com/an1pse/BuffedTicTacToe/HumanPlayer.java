package com.an1pse.BuffedTicTacToe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HumanPlayer extends Player{
    public HumanPlayer(Piece piece) {
        super(piece);
    }

    @Override
    public void move(Board board) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.print("Select tile: ");
                int select = Integer.parseInt(br.readLine());
                Tile tile = interpretSelection(select);
                board.placePiece(this.piece, tile);
                break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (TileNotEmptyException | TileOutOfBoundsException e) {
               System.out.printf("%s. Please try again\n", e.getMessage());
            }
        }
    }

    private static Tile interpretSelection(int select) {
        return switch (select) {
            case 1 -> new Tile(0, 0);
            case 2 -> new Tile(0, 1);
            case 3 -> new Tile(0, 2);
            case 4 -> new Tile(1, 0);
            case 5 -> new Tile(1, 1);
            case 6 -> new Tile(1, 2);
            case 7 -> new Tile(2, 0);
            case 8 -> new Tile(2, 1);
            case 9 -> new Tile(2, 2);
            default -> throw new TileOutOfBoundsException("Selection is out of bounds.");
        };
    }
}


