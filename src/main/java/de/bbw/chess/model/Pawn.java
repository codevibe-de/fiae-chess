package de.bbw.chess.model;

import de.bbw.chess.IllegalMoveException;

import java.util.List;

public class Pawn extends Piece{

    public Pawn(PlayerColor color) {
        super(color);
    }

//        @Override
//        public abstract boolean canMoveTo();
//         MoveList= if this.getColor()=="white" { if firstMove [(+1,0),(+2,0)]

    @Override
    public List<Position> getMovePath(Position target) throws IllegalMoveException {
        return List.of(); // todo
    }

}
