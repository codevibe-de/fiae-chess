package de.bbw.chess.model;

import de.bbw.chess.IllegalMoveException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    @Test
    void getMovePath__twoRows() throws IllegalMoveException {
        // given
        Pawn p = new Pawn(PlayerColor.WHITE);
        p.setPosition(new Position(1,1));

        // given
        List<Position> movePath = p.getMovePath(new Position(3, 1));

        // then
        Assertions.assertEquals(2, movePath.size());
        Assertions.assertEquals(new Position(2,1), movePath.get(0));
        Assertions.assertEquals(new Position(3,1), movePath.get(1));
    }


    @Test
    void getMovePath__singleRow() throws IllegalMoveException {
        // given
        Pawn p = new Pawn(PlayerColor.WHITE);
        p.setPosition(new Position(1,1));

        // given
        List<Position> movePath = p.getMovePath(new Position(2, 1));

        // then
        Assertions.assertEquals(1, movePath.size());
        Assertions.assertEquals(new Position(2,1), movePath.get(0));
    }


}