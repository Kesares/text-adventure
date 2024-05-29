package kesares.textadventure.util;

public final class Utils {

    private Utils() {
        throw new UnsupportedOperationException();
    }

    public static boolean isNull(Object object) {
        return object == null;
    }

    public static boolean isInvalidString(String text) {
        return text == null || text.isEmpty() || text.isBlank();
    }
}
