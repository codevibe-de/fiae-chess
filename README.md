# Chess

https://en.wikipedia.org/wiki/Chess

## Todos

- Klasse für jede Figur
- mehr Code für die Position
- GameBoard Implementierungen
- erkennen, ob - oder Figur
- letzte Zeile lesen
- aktiven Spieler merken
- abstrakte Piece Klasse um Position erweitern

## Pieces

- Turm = Rook (R)
- Springer = Knight (N)
- Läufer = Bishop (B)
- Königin = Queen (Q) ♕
- König = King (K)
- Bauer = Pawn (P)

## Core Concepts

### The Board



## Data File Formats

### CSV

- Contains a letter (see "Pieces" above) for each piece.  
- Empty segment means no piece.  
- White pieces are defined by a capital letter (e.g. "Q") and black pieces with lowercase ("q").  
- The file uses a comma (not semicolon) for separation.
- The last line contains the keyword "black" or "white" to define the next moving player
