package de.hsos.prog3.minesweeper.logic;

public enum Difficulty {
    EASY(9, 9, 10),
    MEDIUM(16, 16, 40),
    HARD(30, 16, 99);

    public final int width;
    public final int height;
    public final int bombCount;

    Difficulty(int width, int height, int bombCount) {
        this.width = width;
        this.height = height;
        this.bombCount = bombCount;
    }
}
