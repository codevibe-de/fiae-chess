package de.bbw.chess.model;

import de.bbw.chess.IllegalMoveException;

import java.util.List;

public class King extends Piece{

    public King(PlayerColor color) {
        super(color);
    }

    //    @Override
    //    public abstract boolean canMoveTo();

    @Override
    public List<Position> getMovePath(Position target) throws IllegalMoveException {
        return List.of(); // todo
    }

}
