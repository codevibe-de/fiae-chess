package de.bbw.chess.model;

import java.io.BufferedReader;

import java.io.FileReader;

import java.io.IOException;

public class ZweiDimGameBoard implements GameBoard {

   private Piece [][] array;

    public ZweiDimGameBoard() {
        this.array = new Piece[8][8];

    }

    @Override
    public Piece get(Position position) {
        return array [position.getRow()][position.getCol()]
;
    }

    @Override
    public void setPiece(Position position, Piece piece) {
        array[position.getRow()][position.getCol()] = piece
        }

    }
}

