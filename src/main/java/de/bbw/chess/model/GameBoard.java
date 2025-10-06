package de.bbw.chess.model;

import de.bbw.chess.IllegalMoveException;

public interface GameBoard {

    Piece get(Position position);

    void setPiece(Position position, Piece piece);

    void checkMove(Position start, Position target) throws IllegalMoveException;

    void movePiece(Position start, Position target);

}
