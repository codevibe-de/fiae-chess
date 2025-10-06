package de.bbw.chess.model;

import de.bbw.chess.IllegalMoveException;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {

    private final PlayerColor color;
    private Position position;

    protected Piece(PlayerColor color) {
        this.color = color;
    }

    public PlayerColor getPlayerColor() {
        return color;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public abstract List<Position> getMovePath(Position target) throws IllegalMoveException;




    protected static record Diff(int x, int y) {
    }

}
