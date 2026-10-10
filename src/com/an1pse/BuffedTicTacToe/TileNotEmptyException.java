package com.an1pse.BuffedTicTacToe;

public class TileNotEmptyException extends RuntimeException{
    public TileNotEmptyException(String message) {
        super(message);
    }
}
