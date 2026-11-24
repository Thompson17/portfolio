package de.hsos.prog3.minesweeper.logic;

public class Square {
    private boolean bomb;
    private boolean discovered;
    private int numberOfBombNeighbours;
    private boolean flag;

    public Square() {
        this.bomb = false;
        this.discovered = false;
        this.numberOfBombNeighbours = -1;
        this.flag = false;
    }

    public boolean isBomb() {
        return bomb;
    }

    public void setBomb(boolean bomb) {
        this.bomb = bomb;
    }

    public boolean isDiscovered() {
        return discovered;
    }

    public void setDiscovered(boolean discovered) {
        this.discovered = discovered;
    }

    public int getNumberOfBombNeighbours() {
        return numberOfBombNeighbours;
    }

    public void setNumberOfBombNeighbours(int numberOfBombNeighbours) {
        this.numberOfBombNeighbours = numberOfBombNeighbours;
    }

    public boolean hasFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
