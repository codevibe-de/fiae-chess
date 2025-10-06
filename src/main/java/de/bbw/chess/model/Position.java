package de.bbw.chess.model;

import java.util.List;
import java.util.Objects;

public class Position {

    // --- static fields ---

    private static final List<String> rowDigits = List.of("8","7","6","5","4","3","2","1");
    private static final List<String> colDigits = List.of("a","b","c","d","e","f","g","h");

    // --- instance fields ---

    private final int row;
    private final int col;


    // --- constructors & factories ---

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Position(String boardCoords) {
        int[] rowAndColArr = getIndices(boardCoords);
        this.row = rowAndColArr[0];
        this.col = rowAndColArr[1];
    }

    public static Position[] parseMovementCommand(String movementCmd) {
        return null; // todo
    }

    public Position withRow(int row) {
        return new Position(row, this.col);
    }

    // --- business logic methods ---

    /**
     * Returns the board coordinate for the given position, e.g. "e7" (given row=1 and col=4)
     */
    public String getBoardCoordinates() {
        if (this.col > -1 && this.col < rowDigits.size() && this.row > -1 && this.row < colDigits.size()) {
            return colDigits.get(this.col) + rowDigits.get(this.row);
        }else
        {
            return "ungültig";
        }
    }

    public int[] getIndices(String coordinate) {    
        String letter = coordinate.substring(0, 1);
        String number = coordinate.substring(1);    

        int x = rowDigits.indexOf(number);
        int y = colDigits.indexOf(letter);

        if (x >= 9 || y >= 9) {
            throw new IllegalArgumentException("Ungültige Koordinate: " + coordinate);
        }
        return new int[]{x, y};
    }

    // --- getter / setter ---

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    // --- equals & hashcode ---


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return row == position.row && col == position.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
