package kesares.textadventure.util;

public final class Utils {

    private Utils() {
        throw new UnsupportedOperationException();
    }

    public static boolean isNotNull(Object object) {
        return object != null;
    }

    public static boolean isInvalidString(String text) {
        return text == null || text.isEmpty() || text.isBlank();
    }

    public static boolean isAllNull(Object[] array) {
        for (Object o : array) {
            if (isNotNull(o)) return false;
        }
        return true;
    }
}
