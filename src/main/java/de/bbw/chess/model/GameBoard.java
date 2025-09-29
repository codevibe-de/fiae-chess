package de.bbw.chess.model;

public interface GameBoard {

    Piece get(Position position);

    void setPiece(Position position, Piece piece);

}
