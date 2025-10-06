package de.bbw.chess.model;

public class Player {
    private String name;
    private boolean turn;

    public Player(String name) {
        this.name = name;
        this.turn = false;
    }
    public void setTurn(boolean turn1) {
        this.turn= turn1;
    }
}
