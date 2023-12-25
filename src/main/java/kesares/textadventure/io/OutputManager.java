package kesares.textadventure.io;

import kesares.textadventure.util.AnsiColor;
import kesares.textadventure.util.lang.Strings;

public final class OutputManager {

    private static final int PRINT_PARTING_LINE = 100;
    private static byte counter;

    private OutputManager() {
        throw new UnsupportedOperationException();
    }

    public static void printTitle(String title) {
        printBoldPartingLine();
        System.out.printf("%s%" + calculateCenterWidth(title) + "s%s\r\n",
                AnsiColor.YELLOW.getValue(),
                title,
                AnsiColor.RESET.getValue()
        );
        printBoldPartingLine();
    }

    public static void printBoldPartingLine() {
        for (counter = 0; counter < PRINT_PARTING_LINE; counter++) {
            System.out.print('=');
        }
        System.out.println();
    }

    public static void printThinPartingLine() {
        for (counter = 0; counter < PRINT_PARTING_LINE; counter++) {
            System.out.print('-');
        }
        System.out.println();
    }

    public static void clearConsole() {
        for (counter = 0; counter < PRINT_PARTING_LINE; counter++) {
            System.out.println();
        }
    }

    public static void printOptionDoesntExist(byte option) {
        System.out.printf(Strings.optionDoesntExist, option);
    }

    private static int calculateCenterWidth(String text) {
        return PRINT_PARTING_LINE / 2 + text.length() / 2;
    }
}