package v1;

import java.util.Random;

public class Logic {
    public static int getRandomNumber(int max) {
        Random rnd = new Random();
        return rnd.nextInt(max) + 1;
    }
}
