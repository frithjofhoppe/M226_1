package Minesweeper;

import javafx.scene.control.Button;

public class Field extends Button {
    boolean isMarked;
    boolean isBomb;
    int xPos;
    int yPos;

    Field(boolean isBomb) {
        this.isBomb = isBomb;
    }

    public boolean isBomb() { return isBomb; }

    public boolean isMarked() {
        return isMarked;
    }

    public void setMarked(boolean marked) {
        isMarked = marked;
    }

    public int getXPos() {
        return xPos;
    }

    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public void setYPos(int yPos) {
        this.yPos = yPos;
    }
}
