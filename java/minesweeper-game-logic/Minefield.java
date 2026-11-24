package de.hsos.prog3.minesweeper.logic;

public class Minefield {
    private final Square[][] minefield;

    public Minefield(int width, int height) {
        this.minefield = new Square[height][width];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                minefield[row][col] = new Square();
            }
        }
    }

    public Square getSquare(int rowPos, int colPos) {
        return minefield[rowPos][colPos];
    }
}
