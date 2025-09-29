package de.bbw.chess.logic;

public class GameRuleViolationException extends RuntimeException {

    public GameRuleViolationException(String message) {
        super(message);
    }

}
