package kesares.textadventure.io;

import kesares.textadventure.util.lang.Strings;

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
            System.out.println(Strings.invalidInput);
            return enterByte(info);
        }
    }

    public static short enterShort(String info) {
        try {
            return Short.parseShort(enterString(info));
        } catch (NumberFormatException e) {
            return enterShort(info);
        }
    }

    public static int enterInt(String info) {
        try {
            return Integer.parseInt(enterString(info));
        } catch (NumberFormatException e) {
            return enterInt(info);
        }
    }

    public static long enterLong(String info) {
        try {
            return Long.parseLong(enterString(info));
        } catch (NumberFormatException e) {
            return enterLong(info);
        }
    }

    public static float enterFloat(String info) {
        try {
            return Float.parseFloat(enterString(info));
        } catch (NumberFormatException e) {
            return enterFloat(info);
        }
    }

    public static double enterDouble(String info) {
        try {
            return Double.parseDouble(enterString(info));
        } catch (NumberFormatException e) {
            return enterDouble(info);
        }
    }

    public static void enterToContinue() {
        enterString(Strings.enterContinue);
    }
}