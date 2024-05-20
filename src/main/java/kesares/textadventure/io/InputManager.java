package kesares.textadventure.io;

import kesares.textadventure.util.lang.LanguageSelector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class InputManager {

    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    private InputManager() {
        throw new UnsupportedOperationException();
    }

    public static String enterString(String info) {
        try {
            System.out.print(info);
            return READER.readLine();
        } catch (IOException e) {
            return enterString(info);
        }
    }

    public static byte enterByte(String info) {
        try {
            return Byte.parseByte(enterString(info));
        } catch (NumberFormatException e) {
            OutputManager.printColorText(LanguageSelector.strings.invalidInput);
            return enterByte(info);
        }
    }

    public static short enterShort(String info) {
        try {
            return Short.parseShort(enterString(info));
        } catch (NumberFormatException e) {
            OutputManager.printColorText(LanguageSelector.strings.invalidInput);
            return enterShort(info);
        }
    }

    public static int enterInt(String info) {
        try {
            return Integer.parseInt(enterString(info));
        } catch (NumberFormatException e) {
            OutputManager.printColorText(LanguageSelector.strings.invalidInput);
            return enterInt(info);
        }
    }

    public static long enterLong(String info) {
        try {
            return Long.parseLong(enterString(info));
        } catch (NumberFormatException e) {
            OutputManager.printColorText(LanguageSelector.strings.invalidInput);
            return enterLong(info);
        }
    }

    public static float enterFloat(String info) {
        try {
            return Float.parseFloat(enterString(info));
        } catch (NumberFormatException e) {
            OutputManager.printColorText(LanguageSelector.strings.invalidInput);
            return enterFloat(info);
        }
    }

    public static double enterDouble(String info) {
        try {
            return Double.parseDouble(enterString(info));
        } catch (NumberFormatException e) {
            OutputManager.printColorText(LanguageSelector.strings.invalidInput);
            return enterDouble(info);
        }
    }

    public static boolean enterBoolean(String info) {
        try {
            String input = enterString(info);
            return Byte.parseByte(input) == 1;
        } catch (NumberFormatException e) {
            OutputManager.printColorText(LanguageSelector.strings.invalidInput);
            return enterBoolean(info);
        }
    }

    public static void enterToContinue() {
        enterString(LanguageSelector.strings.enterToContinue);
    }

    public static void close() {
        try {
            READER.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}