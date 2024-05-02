package kesares.textadventure.io;

import kesares.textadventure.util.AnsiColor;
import kesares.textadventure.util.lang.Strings;

public final class OutputManager {

    public static final byte CLEAR_LENGTH = 50;
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
        printTitle(title, CLEAR_LENGTH);
    }

    public static void printColorText(String text, AnsiColor color) {
        System.out.printf("%s%s%s%n", color.getValue(), text, AnsiColor.RESET.getValue());
    }

    public static void printPartingLine(char c, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(c);
        }
        System.out.println();
    }

    public static void printPartingLine(char c) {
        printPartingLine(c, CLEAR_LENGTH);
    }

    public static void printPartingLine() {
        printPartingLine(EQUAL_SIGN);
    }

    public static void clearConsole() {
        for (byte i = 0; i < 50; ++i) {
            System.out.println();
        }
    }

    public static void printOptionDoesntExist(byte option) {
        System.out.printf(Strings.optionDoesntExist, option);
    }

    public static int calculateCenterWidth(String text, int length) {
        return length / 2 + text.length() / 2;
    }
}