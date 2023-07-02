package kesares.textadventure.util;

import java.util.Random;

public final class Maths {

    private static final Random RANDOM = new Random();

    private Maths() {
        throw new UnsupportedOperationException();
    }

    public static boolean getRandomBoolean() {
        return RANDOM.nextBoolean();
    }

    public static boolean isNull(Object object) {
        return object == null;
    }

    public static String formatMenuString(String text) {
        return text.replaceAll("\\|", "\r\n");
    }
}