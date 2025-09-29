package de.bbw.chess.io;

/**
 * Thrown if a game-state reader discovers a structural problem with the game file.
 */
public class GameStateFormatException extends RuntimeException {

    public GameStateFormatException(String message) {
        super(message); // constructor chaining
    }

}
