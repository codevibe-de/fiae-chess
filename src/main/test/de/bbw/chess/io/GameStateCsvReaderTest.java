package de.bbw.chess.io;

import de.bbw.chess.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

class GameStateCsvReaderTest {

    @Test
    void read() throws IOException {
        // given
        File gameFile = new File("game-states/chess.csv");
        GameStateCsvReader gameStateCsvReader = new GameStateCsvReader(gameFile);

        // when
        GameState gameState = gameStateCsvReader.read();

        // then
        Assertions.assertEquals(PlayerColor.WHITE, gameState.getActivePlayerColor());
        {
            Piece pieceA8 = gameState.getGameBoard().get(new Position("a8"));
            Assertions.assertNotNull(pieceA8);
            Assertions.assertTrue(pieceA8 instanceof Rook);
        }
        Piece pieceWhiteQueen = gameState.getGameBoard().get(new Position("d1"));
        Assertions.assertNotNull(pieceWhiteQueen);
        Assertions.assertTrue(pieceWhiteQueen instanceof Queen);
        Assertions.assertEquals(PlayerColor.WHITE, pieceWhiteQueen.getPlayerColor());
    }

}