package de.bbw.chess.model;

public class GameState {

    private final PlayerColor activePlayerColor;
    private final GameBoard gameBoard;

    public GameState(PlayerColor activePlayerColor, GameBoard gameBoard) {
        this.activePlayerColor = activePlayerColor;
        this.gameBoard = gameBoard;
    }

    public PlayerColor getActivePlayerColor() {
        return activePlayerColor;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }
}
