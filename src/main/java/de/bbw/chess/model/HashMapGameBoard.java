package de.bbw.chess.model;

import de.bbw.chess.logic.GameRuleViolationException;

import java.util.HashMap;
import java.util.Map;

public class HashMapGameBoard implements GameBoard {

    Map<Position, Piece> map = new HashMap<>(64);

    @Override
    public Piece get(Position position) {
        return map.get(position);
    }

    @Override
    public void setPiece(Position position, Piece piece) {
        // check if position is already taken by a different piece
        Piece otherPiece = get(position);
        if (piece != otherPiece) {
            throw new GameRuleViolationException("Cannot set a piece at " + position + " since its occupied");
        }
        // accept
        map.put(position, piece);
    }

}
