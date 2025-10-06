package de.bbw.chess.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ZweiDimGameBoardTest {

    @Test
    void testSetPieceAndGet() {
        // Arrange
        ZweiDimGameBoard board = new ZweiDimGameBoard();
        Position position = new Position(3, 4);
        Piece piece = new Piece(); // oder was auch immer dein Piece-Konstruktor braucht

        // Act
        board.setPiece(position, piece);
        Piece result = board.get(position);

        // Assert
        assertSame(piece, result);
    }

    @Test
    void testGetEmptyPosition() {
        // Arrange
        ZweiDimGameBoard board = new ZweiDimGameBoard();
        Position position = new Position(0, 0);

        // Act
        Piece result = board.get(position);

        // Assert
        assertNull(result);
    }
}