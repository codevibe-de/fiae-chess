package de.bbw.chess.model;

import de.bbw.chess.IllegalMoveException;

import java.util.List;

public class Bishop extends Piece{

    public Bishop(PlayerColor color) {
        super(color);
    }

    @Override
    public List<Position> getMovePath(Position target) throws IllegalMoveException {
        return List.of(); // todo
    }

    //    @Override
    //    public abstract boolean canMoveTo();

}
