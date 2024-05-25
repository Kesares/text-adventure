package kesares.textadventure.io;

import kesares.textadventure.util.AnsiColor;
import kesares.textadventure.util.lang.LanguageSelector;
import kesares.textadventure.util.lang.Strings;

public final class OutputManager {

    private static final byte CLEAR_LENGTH = 50;
    public static final byte LINE_LENGTH = CLEAR_LENGTH;
    public static final char EQUAL_SIGN = '=';
    public static final char MINUS_SIGN = '-';

    private OutputManager() {
        throw new UnsupportedOperationException();
    }

    public static void printTitle(String title, char c, int length, AnsiColor color) {
        printPartingLine(c, length);
        System.out.printf("%s%" + calculateCenterWidth(title, length) + "s%s%n", color.getValue(), title, AnsiColor.RESET.getValue());
        printPartingLine(c, length);
    }

    public static void printTitle(String title, char lineChar, int length) {
        printTitle(title, lineChar, length, AnsiColor.YELLOW);
    }

    public static void printTitle(String title, int length) {
        printTitle(title, EQUAL_SIGN, length);
    }

    public static void printTitle(String title) {
        printTitle(title, LINE_LENGTH);
    }

    public static void printColorText(String text, AnsiColor color) {
        System.out.printf("%s%s%s%n", color.getValue(), text, AnsiColor.RESET.getValue());
    }

    public static void printColorText(String text) {
        printColorText(text, AnsiColor.YELLOW);
    }

    public static void printCenteredColorText(String text, AnsiColor color, int length) {
        int width = calculateCenterWidth(text, length);
        System.out.printf("%s%" + width + "s%s%n", color.getValue(), text, AnsiColor.RESET.getValue());
    }

    public static void printPartingLine(char c, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(c);
        }
        System.out.println();
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
        for (byte i = 0; i < CLEAR_LENGTH; ++i) {
            System.out.println();
        }
    }

    public static void printOptionDoesntExist(byte option) {
        OutputManager.printColorText(LanguageSelector.strings.getFormattedOptionDoesntExist(option));
    }

    public static int calculateCenterWidth(String text, int length) {
        return length / 2 + text.length() / 2;
    }
}