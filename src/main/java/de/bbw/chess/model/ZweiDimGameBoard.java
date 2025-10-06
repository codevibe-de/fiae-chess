package de.bbw.chess.model;

import de.bbw.chess.IllegalMoveException;

public class ZweiDimGameBoard implements GameBoard {

    private Piece[][] array;

    public ZweiDimGameBoard() {
        this.array = new Piece[8][8];
    }

    @Override
    public Piece get(Position position) {
        return array[position.getRow()][position.getCol()];
    }

    @Override
    public void setPiece(Position position, Piece piece) {
        array[position.getRow()][position.getCol()] = piece;
        piece.setPosition(position);
    }

    @Override
    public void checkMove(Position start, Position target) throws IllegalMoveException {
        // todo
    }

    @Override
    public void movePiece(Position start, Position target) {
        // todo
    }

}

