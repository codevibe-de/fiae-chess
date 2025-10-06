package de.bbw.chess.model;

import de.bbw.chess.IllegalMoveException;

import java.util.List;

public class Rook extends Piece {

    public Rook(PlayerColor color) {
        super(color);
    }

    @Override
    public List<Position> getMovePath(Position target) throws IllegalMoveException {
        return List.of(); // todo
    }

}
