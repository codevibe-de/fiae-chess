package de.bbw.chess;

import de.bbw.chess.io.GameStateCsvReader;
import de.bbw.chess.model.GameState;
import de.bbw.chess.model.Position;
import de.bbw.chess.tui.TerminalGameBoardRenderer;

import java.io.File;
import java.io.IOException;

public class ChessApp {

    public static void main(String[] args) {
        // 1. Spielstand einlesen
        File gameStateFile = new File("game-states/chess.csv");
        GameStateCsvReader reader = new GameStateCsvReader(gameStateFile);
        GameState gameState = null;
        try {
            gameState = reader.read();
        } catch (IOException e) {
            System.out.println("Es gab ein Problem beim Einlesen der CSV Datei: " + e.getMessage());
            System.exit(1);
        }

        // 2. Schachbrett darstellen
        TerminalGameBoardRenderer renderer = new TerminalGameBoardRenderer();
        renderer.render(gameState);

        // 3. Aktiven Spieler nach Zug prompten
        while (true) {
            String prompt = "Spieler " + gameState.getActivePlayerColor().name() + " ist am Zug: ";
            String movementCmd = IO.readln(prompt); // e7e8
            Position[] startAndTargetPosition = Position.parseMovementCommand(movementCmd);
            try {
                gameState.getGameBoard().checkMove(startAndTargetPosition[0], startAndTargetPosition[1]);
                gameState.getGameBoard().movePiece(startAndTargetPosition[0], startAndTargetPosition[1]);
                break;
            } catch (IllegalMoveException e) {
                System.out.println("Dieser Zug ist leider nicht möglich: " + e.getMessage());
            }
        }
    }

}
