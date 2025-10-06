package de.bbw.chess.model;

import java.util.List;

public class Position {

    private static final List<String> xCord = List.of("1","2","3","4","5","6","7","8");
    private static final List<String> yCord = List.of("A","B","C","D","E","F","G","H");


    public Position(int row, int col) {

    }

    public String getSquareCoordinate(int x, int y) {
        if (x > -1 && x < xCord.size() && y > -1 && y < yCord.size()) {
            return xCord.get(x) + yCord.get(y);
        }else
        {
            return "ungültig";
        }
    }

    public int[] getIndices(String coordinate) {    
        String letter = coordinate.substring(0, 1);
        String number = coordinate.substring(1);    

        int x = xCord.indexOf(number);  
        int y = yCord.indexOf(letter);  

        if (x >= 9 || y >= 9) {
            throw new IllegalArgumentException("Ungültige Koordinate: " + coordinate);
        }
        return new int[]{x, y};
    }
}
