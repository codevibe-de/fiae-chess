package de.bbw.chess.model;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece{

    @Override
    protected ArrayList<Position> validMoves(){
        ArrayList<Position> valMoves=new ArrayList<>();
        ArrayList<Diff> MoveList = (ArrayList<Diff>) List.of(new Diff(+2,-1),new Diff(+2,+1),new Diff(+1,+2),new Diff(-1,+2),new Diff(+1,-2),new Diff(-1,-2),new Diff(-2,-1),new Diff(-2,+1));
        for(Diff diff:MoveList) {
            valMoves.add(new Position((this.getPosition().getRow()) + diff.x(), (this.getPosition().getCol()) + diff.y()));
        }
        return valMoves;
    }

//    static record Diff(int x , int y){
//
//    }


}
