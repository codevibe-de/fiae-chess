package de.bbw.chess;

import de.bbw.chess.io.GameStateCsvReader;

import java.io.File;
import java.io.IOException;

public class ChessApp {

    public static void main(String[] args) {
        // 1. Spielstand einlesen
        File gameStateFile = new File("game-states/chess.csv");
        GameStateCsvReader reader = new GameStateCsvReader(gameStateFile);
        try {
            reader.read();
        } catch (IOException e) {
            System.out.println("Es gab ein Problem beim Einlesen der CSV Datei: " + e.getMessage());
        }
    }

}
