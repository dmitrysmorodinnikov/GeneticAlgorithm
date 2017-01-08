package common;

import java.util.Random;

/**
 * Generates random values
 */
public class Randomizer {
    /**
     *
     * @param min min bound
     * @param max max bound
     * @return random number between min bound and max bound
     */
    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}
