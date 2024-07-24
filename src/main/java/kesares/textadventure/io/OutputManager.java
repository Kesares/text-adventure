package kesares.textadventure.io;

import kesares.textadventure.util.AnsiColor;
import kesares.textadventure.util.lang.LanguageSelector;
import kesares.textadventure.util.lang.Strings;

public final class OutputManager {

    public static final byte LINE_LENGTH = 50;
    public static final char EQUAL_SIGN = '=';
    public static final char MINUS_SIGN = '-';

    private static final StringBuilder LINE_BUILDER = new StringBuilder();
    private static final StringBuilder CLEANER = new StringBuilder();

    static {
        CLEANER.append("\n".repeat(50));
    }

    private OutputManager() {
        throw new UnsupportedOperationException();
    }

    public static void printTitle(String title, char c, int length, String color) {
        printPartingLine(c, length);
        System.out.printf("%s%" + calculateCenterWidth(title, length) + "s%s%n", color, title, AnsiColor.DEFAULT);
        printPartingLine(c, length);
    }

    public static void printTitle(String title, char c, int length) {
        printTitle(title, c, length, AnsiColor.YELLOW);
    }

    public static void printTitle(String title, int length) {
        printTitle(title, EQUAL_SIGN, length);
    }

    public static void printTitle(String title) {
        printTitle(title, LINE_LENGTH);
    }

    public static void printColorText(String text, String color) {
        System.out.printf("%s%s%s%n", color, text, AnsiColor.DEFAULT);
    }

    public static void printColorText(String text) {
        printColorText(text, AnsiColor.YELLOW);
    }

    public static void printCenteredColorText(String text, String color, int length) {
        int width = calculateCenterWidth(text, length);
        System.out.printf("%s%" + width + "s%s%n", color, text, AnsiColor.DEFAULT);
    }

    /**
     * Prints a line on the console consisting of a given {@code c},
     * the {@code length} and a {@code borderChar} at the beginning and end of the line.
     * The method replaces the 2 characters at the beginning and the end with the {@code borderChar}.
     * The caller only needs to know the total length.
     *
     * @param c the character of the line
     * @param length the length of the line
     * @param borderChar the character at the beginning and end of the line
     */
    public static void printPartingLineWithBorder(char c, int length, char borderChar) {
        LINE_BUILDER
                .append(borderChar)
                .append(String.valueOf(c).repeat(Math.max(0, length - 2)))
                .append(borderChar);
        System.out.println(LINE_BUILDER);
        LINE_BUILDER.setLength(0);
    }

    public static void printPartingLine(char c, int length) {
        LINE_BUILDER.append(String.valueOf(c).repeat(Math.max(0, length)));
        System.out.println(LINE_BUILDER);
        LINE_BUILDER.setLength(0);
    }

    public static void printPartingLine(char c) {
        printPartingLine(c, LINE_LENGTH);
    }

    public static void printBoldPartingLine() {
        printPartingLine(EQUAL_SIGN);
    }

    public static void printComingSoon(String text) {
        printPartingLine(MINUS_SIGN);
        printColorText(text + Strings.COMING_SOON, AnsiColor.RED);
    }

    public static void clearConsole() {
        System.out.println(CLEANER);
    }

    public static void printOptionDoesntExist(byte option) {
        OutputManager.printColorText(LanguageSelector.strings.getFormattedOptionDoesntExist(option));
    }

    public static int calculateCenterWidth(String text, int length) {
        return length / 2 + text.length() / 2;
    }
}