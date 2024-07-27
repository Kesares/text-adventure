package kesares.textadventure.util;

import java.util.Random;

/**
 * A utility class for mathematical operations and random number generation.
 * <p>
 * It cannot be instantiated, and its constructor throws an {@link UnsupportedOperationException}
 * to prevent instantiation.
 * </p>
 */
public final class Maths {

    private static final Random RANDOM = new Random();

    /**
     * Private constructor to prevent instantiation of this utility class.
     *
     * @throws UnsupportedOperationException always thrown to prevent instantiation.
     */
    private Maths() {
        throw new UnsupportedOperationException();
    }

    /**
     * Generates a random integer between the specified minimum (inclusive) and maximum (exclusive) values.
     * <p>
     * The generated random number is uniformly distributed within the range.
     *
     * @param min the minimum value (inclusive) of the range.
     * @param max the maximum value (exclusive) of the range.
     * @return a randomly generated integer between {@code min} (inclusive) and {@code max} (exclusive).
     * @throws IllegalArgumentException if {@code min} is greater than or equal to {@code max}.
     */
    public static int getRandomNumberBetween(int min, int max) {
        if (min >= max) throw new IllegalArgumentException("min must be less than max");
        return (int) (Math.random() * (max - min) + min);
    }

    /**
     * Generates a random boolean value.
     * <p>
     * The result is equally likely to be {@code true} or {@code false}.
     *
     * @return a randomly generated boolean value.
     */
    public static boolean getRandomBoolean() {
        return RANDOM.nextBoolean();
    }
}