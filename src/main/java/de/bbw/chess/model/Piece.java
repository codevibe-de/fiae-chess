package de.bbw.chess.model;

import java.util.ArrayList;

public abstract class Piece {

    private String color;
    private Position position;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }


    protected ArrayList<Position> validMoves(){
        return null;
    }

    public boolean canMoveTo(Position targetPos){
        return validMoves().contains(targetPos);
    }

    protected static record Diff(int x , int y){

    }

//
    //    public abstract String getToken();
//    public abstract ??? getLocation();

}
