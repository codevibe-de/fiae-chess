package de.bbw.chess.io;

import de.bbw.chess.model.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

// CSV -> GameStateCsvReader -> GameState
public class GameStateCsvReader {

    private final File file;
    private  Player player1;
    private  Player player2;

    public GameStateCsvReader(File file) {
        // Check if file exists and really is a file (and not a directory)
        if (file != null && file.isFile() && file.canRead()) {
            this.file = file;
        } else {
            throw new IllegalArgumentException("Datei existiert nicht oder ist nicht lesbar");
        }
    }


    public GameState read() throws IOException {
        GameBoard board = new ZweiDimGameBoard();

        // 1. Datei öffnen
        // 2. alle Zeilen in eine Liste lesen
        List<String> rows = Files.readAllLines(this.file.toPath());

        // 3. Prüfe auf 9 nicht-leere Zeilen
        // todo leere Zeilen ignorieren
        if (rows.size() != 9) {
            throw new GameStateFormatException("Expected 9 rows, but got " + rows.size());
        }

        // 4. Schleife über die ersten 8 Zeilen (Brett-Zeilen)
        for (int row=0; row<8; row++) {
            String line = rows.get(row);
            //  4.1. in Einzelteile splitten (mit ",") -> Liste an Tokens
            String[] tokens = line.split(",");
            int numOfTokens = tokens.length;
            //  4.2. Prüfe, ob genau 8 Tokens habe
            if (numOfTokens != 8) {
                throw new GameStateFormatException("Expected 8 tokens, but got " + numOfTokens +
                        " in line " + row + " ('" + line + "'");
            // Hier die Sortierung einfügen...
            }
            //  4.3. für jedes Token ein Spielfigur-Objekt anlegen und irgendwie merken
            for (int col=0; col<8; col++) {
                String token = tokens[col];
                Piece piece = createPiece(token);
                if (piece != null) {
                    board.setPiece(new Position(row, col), piece);
                }
            }
        }
        // 5. letzte (neunte) Zeile lesen, muss "black" oder "white" enthalten
        // Es wird nur die neunte Zeile gelesen
        String lastRow = rows.get(8).trim();
        PlayerColor activePlayerColor = PlayerColor.valueOf(lastRow.toUpperCase());

        // paketiere alles in einem GameState und gib das zurück
        return new GameState(
                activePlayerColor,
                board
        );
    }


    private Piece createPiece(String token) {
        Character tokenChr = token.charAt(0);
        PlayerColor color = (Character.isUpperCase(tokenChr)) ? PlayerColor.WHITE : PlayerColor.BLACK;
        return switch (token.toUpperCase()) {
            case "K" -> new King(color);
            case "R" -> new Rook(color);
            case "Q" -> new Queen(color);
            case "B" -> new Bishop(color);
            case "P" -> new Pawn(color);
            case "N" -> new Knight(color);
            default -> null;
        };
    }

}
