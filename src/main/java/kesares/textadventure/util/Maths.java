package kesares.textadventure.util;

import java.util.Random;

public final class Maths {

    private static final Random RANDOM = new Random();

    private Maths() {
        throw new UnsupportedOperationException();
    }

    public static int getRandomNumberBetween(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

    public static boolean getRandomBoolean() {
        return RANDOM.nextBoolean();
    }

    public static boolean isNull(Object object) {
        return object == null;
    }
}