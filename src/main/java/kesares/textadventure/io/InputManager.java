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

    public static void enterToContinue() {
        enterString(Strings.enterContinue);
    }
}