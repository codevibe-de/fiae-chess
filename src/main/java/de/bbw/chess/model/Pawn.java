package de.bbw.chess.model;

import de.bbw.chess.IllegalMoveException;

import java.util.List;

public class Pawn extends Piece {

    public Pawn(PlayerColor color) {
        super(color);
    }

//        @Override
//        public abstract boolean canMoveTo();
//         MoveList= if this.getColor()=="white" { if firstMove [(+1,0),(+2,0)]

    @Override
    public List<Position> getMovePath(Position target) throws IllegalMoveException {
        // prep
        var startRow = getPosition().getRow();
        var targetRow = target.getRow();
        // Check move direction
        int rowDiff = getPosition().getRow() - target.getRow();
        if (rowDiff <= 0 && getPlayerColor() == PlayerColor.BLACK) {
            throw new IllegalMoveException("Schwarze Bauern können nur nach 'unten' bewegt werden");
        }
        if (rowDiff >= 0 && getPlayerColor() == PlayerColor.WHITE) {
            throw new IllegalMoveException("Weiße Bauern können nur nach 'oben' bewegt werden");
        }
        // pawns move 1 or 2 fields
        if (Math.abs(rowDiff) == 0) {
            throw new IllegalMoveException("Bauern müssen sich eine Reihe bewegen");
        }
        if (Math.abs(rowDiff) > 2) {
            throw new IllegalMoveException("Bauern können sich maximal 2 Reihen bewegen");
        }
        // pawn moves two rows from starting line, otherwise one
        if (startRow != 1 && startRow != 7 && Math.abs(rowDiff) > 1) {
            throw new IllegalMoveException("Bauern können nur von ihrer Ausgangslinie aus sich um 2 Reihen bewegen");
        }
        // max. 1 feld zur seite
        var colDiff = getPosition().getCol() - target.getCol();
        if (Math.abs(colDiff) > 1) {
            throw new IllegalMoveException("Bauern können sich maximal 1 Feld zur Seite bewegen");
        }
        // nicht bei 2er move schlagen
        if (Math.abs(colDiff) == 1 && Math.abs(rowDiff) == 2) {
            throw new IllegalMoveException("Bauern können sich nicht um 2 Felder nach vorne bewegen UND dabei schlagen");
        }

        // generate path, which is either just the target field (1 row) or both rows
        if (Math.abs(rowDiff) == 1) {
            return List.of(target);
        } else {
            return List.of(
                    target.withRow((startRow + targetRow) / 2),
                    target
            );
        }
    }

}
