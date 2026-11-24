package de.hsos.prog3.minesweeper.logic;

import java.util.Random;

public class GameManager {
    private final Random random = new Random();
    private Minefield minefield;
    private Difficulty difficulty;
    private int timer;
    private int bombsRemainingShown;
    private int squaresDiscovered;
    private boolean gameRunning;
    private boolean gameOver;
    private boolean gameWon;

    public GameManager() {
        initialiseGame();
    }

    private void initialiseGame() {
        initDifficulty();
        initMinefield();
        initVariables();
    }

    private void initDifficulty() {
        // The original game initialisation uses the easy difficulty.
        difficulty = Difficulty.EASY;
    }

    private void initMinefield() {
        minefield = new Minefield(difficulty.width, difficulty.height);
        // Place bombs on distinct squares.
        for (int i = 0; i < difficulty.bombCount; i++) {
            RandomPosition position;
            Square square;
            do {
                position = new RandomPosition();
                square = minefield.getSquare(position.yPos, position.xPos);
            } while (square.isBomb());
            square.setBomb(true);
        }
        // Calculate the number of neighbouring bombs for each square.
        for (int yPos = 0; yPos < difficulty.height; yPos++) {
            for (int xPos = 0; xPos < difficulty.width; xPos++) {
                int numberOfBombNeighbours = neighbourBombCount(xPos, yPos);
                minefield.getSquare(yPos, xPos).setNumberOfBombNeighbours(numberOfBombNeighbours);
            }
        }
    }

    private void initVariables() {
        timer = 0;
        gameRunning = false;
        gameOver = false;
        gameWon = false;
        bombsRemainingShown = difficulty.bombCount;
        squaresDiscovered = 0;
    }

    // Count neighbouring bombs for the square at (xPos, yPos).
    private int neighbourBombCount(int xPos, int yPos) {

        int neighboursWithBombs = 0;

        // Examine all surrounding squares.
        for (int colNum = xPos - 1; colNum <= (xPos + 1); colNum += 1) {

            for (int rowNum = yPos - 1; rowNum <= (yPos + 1); rowNum += 1) {

                // Exclude the centre square.
                if (!((colNum == xPos) && (rowNum == yPos))) {

                    // Check that the square is within the grid.
                    if (withinGrid(rowNum, colNum)) {

                        // Count the square if it contains a bomb.
                        if (this.minefield.getSquare(rowNum, colNum).isBomb()) {
                            neighboursWithBombs++;
                        }
                    }
                }
            }
        }
        return neighboursWithBombs;
    }

    // Discover all neighbouring squares of the given position.
    private void discoverNeighbours(int row, int col) {

        // Examine all surrounding squares.
        for (int colNum = col - 1; colNum <= (col + 1); colNum += 1) {

            for (int rowNum = row - 1; rowNum <= (row + 1); rowNum += 1) {

                // Exclude the centre square.
                if (!((colNum == col) && (rowNum == row))) {

                    // Check that the square is within the grid.
                    if (withinGrid(rowNum, colNum)) {

                        if (!this.discoverSquare(rowNum, colNum)) {
                            return;
                        }
                    }
                }
            }
        }
    }

    // Check whether the given row and column are within the grid.
    private boolean withinGrid(int rowNum, int colNum) {

        if ((colNum < 0) || (rowNum < 0)) {
            return false;
        }
        if ((colNum >= difficulty.width) || (rowNum >= difficulty.height)) {
            return false;
        }
        return true;
    }

    // Toggle the flag on an undiscovered square and update the displayed bomb count.
    public void changeFlag(int row, int col) {
        if (gameOver || gameWon) {
            return;
        }

        Square square = minefield.getSquare(row, col);
        if (square.isDiscovered()) {
            return;
        }

        boolean newFlag = !square.hasFlag();
        square.setFlag(newFlag);
        if (newFlag) {
            bombsRemainingShown--;
        } else {
            bombsRemainingShown++;
        }
    }

    public boolean discoverSquare(int row, int col) {
        if (gameOver || gameWon) {
            return !gameOver;
        }

        Square square = minefield.getSquare(row, col);
        if (!square.isDiscovered() && !square.hasFlag()) {
            square.setDiscovered(true);
            if (square.isBomb()) {
                gameOver();
                return false;
            } else {
                squaresDiscovered++;
            }
            if (square.getNumberOfBombNeighbours() == 0) {
                discoverNeighbours(row, col);
            }
        }
        return !gameOver;
    }

    public void setGameRunning(boolean gameRunning) {
        this.gameRunning = gameRunning;
    }

    private void gameOver() {
        gameRunning = false;
        gameOver = true;
    }

    private void gameWon() {
        gameRunning = false;
        gameWon = true;
    }

    public void updateWinCondition() {
        if (!gameOver && !gameWon
                && squaresDiscovered == difficulty.height * difficulty.width - difficulty.bombCount) {
            gameWon();
        }
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public int getTimer() {
        return timer;
    }

    public int getBombsRemainingShown() {
        return bombsRemainingShown;
    }

    public boolean isGameRunning() {
        return gameRunning;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean isGameWon() {
        return gameWon;
    }

    public Minefield getMinefield() {
        return minefield;
    }

    public void incrementTimer() {
        timer++;
    }

    // Generate random coordinates within the playing field.
    class RandomPosition {
        private final int xPos;
        private final int yPos;

        public RandomPosition() {
            xPos = random.nextInt(difficulty.width);
            yPos = random.nextInt(difficulty.height);
        }
    }
}
