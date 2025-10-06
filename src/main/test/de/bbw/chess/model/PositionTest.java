package de.bbw.chess.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    void checkChessNotation() {
        // given - a Position with row/col coordinates
        Position p = new Position(0, 0);
        // when - asking for typical "chess coordinates"
        String coords = p.getBoardCoordinates();
        // then
        Assertions.assertEquals("a8", coords);

        // given - a Position with row/col coordinates
        Position p2 = new Position(1, 4);
        // when - asking for typical "chess coordinates"
        String coords2 = p2.getBoardCoordinates();
        // then
        Assertions.assertEquals("e7", coords2);
    }


    /**
     * Checks that we can transform a given board position like "f6" into data coordinates.
     */
    @Test
    void checkDataCoordinatesToPosition() {
        // given - Ausgangsbasis
        String boardCoords = "f6";

        // when
        Position position = new Position(boardCoords);

        // then
        int expectedRow = 2;
        int expectedCol = 5;
        Assertions.assertEquals(expectedRow, position.getRow());
        Assertions.assertEquals(expectedCol, position.getCol());
    }

    @Test
    void parseMovementCommand() {
        String boardCoords = "b1f6";

        String expectedRow = "b1";
        String expectedCol = "f6";
        Assertions.assertEquals(expectedRow, Position.parseMovementCommand(boardCoords)[0].getBoardCoordinates());
        Assertions.assertEquals(expectedCol, Position.parseMovementCommand(boardCoords)[1].getBoardCoordinates());



    }
}