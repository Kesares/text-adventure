package kesares.textadventure.util;

import java.util.Objects;

public final class Utils {

    private Utils() {
        throw new UnsupportedOperationException();
    }

    /**
     * Checks if all elements in the provided array are {@code null}.
     *
     * <p>This method iterates over each element of the array and returns {@code true} only if every element is {@code null}.
     * If any element is not {@code null}, the method returns {@code false}.</p>
     *
     * @param <T> the type of elements in the array
     * @param array the array to be checked; must not be {@code null}
     * @return {@code true} if all elements in the array are {@code null}; {@code false} otherwise
     * @throws NullPointerException if the provided array is {@code null}
     */
    public static <T> boolean isAllNull(T[] array) {
        for (T t : array) {
            if (!Objects.isNull(t)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if a given string is invalid.
     *
     * <p>This method considers a string invalid if it is {@code null},
     * empty, or contains only whitespace characters.</p>
     *
     * @param text the string to be checked for validity.
     * @return {@code true} if the string is {@code null}, empty, or blank,
     *         {@code false} otherwise.
     */
    public static boolean isInvalidString(String text) {
        return Objects.isNull(text) || text.isBlank();
    }
}
