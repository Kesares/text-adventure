package kesares.textadventure.util;

public final class Utils {

    private Utils() {
        throw new UnsupportedOperationException();
    }

    /**
     * Checks if the given object is not null.
     *
     * @param o the object to check
     * @return {@code true} if the object is not null, {@code false} otherwise
     */
    public static boolean isNotNull(Object o) {
        return o != null;
    }

    /**
     * Checks if all elements in the provided array are null.
     * <p>
     * This method iterates through the given array and checks if each element
     * is null. If any element is found to be non-null, the method returns false.
     * If all elements are null, the method returns true.
     *
     * @param array the array to be checked for null elements.
     *              It should not be null itself. If a null array is passed,
     *              a NullPointerException may be thrown during iteration.
     * @return {@code true} if all elements in the array are null,
     *         {@code false} if at least one element is non-null.
     */
    public static boolean isAllNull(Object[] array) {
        for (Object o : array) {
            if (isNotNull(o)) return false;
        }
        return true;
    }

    /**
     * Checks if a given string is invalid.
     * <p>
     * This method considers a string invalid if it is {@code null},
     * empty, or contains only whitespace characters.
     *
     * @param text the string to be checked for validity.
     * @return {@code true} if the string is {@code null}, empty, or blank,
     *         {@code false} otherwise.
     */
    public static boolean isInvalidString(String text) {
        return text == null || text.isEmpty() || text.isBlank();
    }
}
