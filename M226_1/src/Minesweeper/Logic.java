package Minesweeper;

import java.util.Random;

public class Logic {
    public static int getRandomNumber(int max) {
        Random rnd = new Random();
        return rnd.nextInt(max) + 1;
    }

    public static boolean checkEnd(PlayingField playingField)
    {
        int fields = playingField.dimensionOfField*playingField.dimensionOfField;
        int bombs = playingField.bombsCount;
        if(playingField.clickedFields >= fields - bombs) {
            return true;
        }
        return false;
    }
}
