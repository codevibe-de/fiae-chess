package de.bbw.chess.io;

import de.bbw.chess.model.GameState;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

// CSV -> GameStateCsvReader -> GameState
public class GameStateCsvReader {

    private final File file;

    public GameStateCsvReader(File file) {
        // Check if file exists and really is a file (and not a directory)
        if (file != null && file.isFile() && file.canRead()) {
            this.file = file;
        } else {
            throw new IllegalArgumentException("Datei existiert nicht oder ist nicht lesbar");
        }
    }


    public GameState read() throws IOException {
        // 1. Datei öffnen
        // 2. alle Zeilen in eine Liste lesen
        List<String> rows = Files.readAllLines(this.file.toPath());

        // 3. Prüfe auf 9 nicht-leere Zeilen
        if (rows.size() != 9) {
            throw new GameStateFormatException("Expected 9 rows, but got " + rows.size());
        }

        // 4. Schleife über die ersten 8 Zeilen (Brett-Zeilen)
        //  4.1. in Einzelteile splitten (mit ",") -> Liste an Tokens
        //  4.2. Prüfe, ob genau 8 Tokens habe
        //  4.3. für jedes Token ein Spielfigur-Objekt anlegen und irgendwie merken
        // 5. letzte (neunte) Zeile lesen, muss "black" oder "white" enthalten
        // 6. merke, wer aktive spieler ist

        return null; // todo
    }

}
