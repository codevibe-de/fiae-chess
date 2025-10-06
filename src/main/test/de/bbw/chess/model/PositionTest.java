package de.bbw.chess.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    void checkChessNotation() {
        // given - a Position with row/col coordinates
        Position p = new Position(0, 0);
        // when - asking for typical "chess coordinates"
        String coords = p.getSquareCoordinate();
        // then
        Assertions.assertEquals("a8", coords);

        // given - a Position with row/col coordinates
        Position p2 = new Position(1, 4);
        // when - asking for typical "chess coordinates"
        String coords2 = p2.getSquareCoordinate();
        // then
        Assertions.assertEquals("d7", coords2);
    }

}