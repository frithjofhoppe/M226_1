package v1;

import java.util.Random;

public class Logic {
    public int getRandomNumber(int max) {
        Random rnd = new Random();
        return rnd.nextInt(max) + 1;
    }
}
