package kesares.textadventure.core;

import kesares.textadventure.io.InputManager;
import kesares.textadventure.io.MenuPrinter;
import kesares.textadventure.io.OutputManager;
import kesares.textadventure.util.lang.LanguageSelector;
import kesares.textadventure.util.lang.Strings;

import java.util.Locale;

public final class Settings {

    private Settings() {
        throw new UnsupportedOperationException();
    }

    public static void changeSettings() {
        OutputManager.clearConsole();
        MenuPrinter.printSettingsMenu();
        byte option = InputManager.enterByte("> ");
        switch (option) {
           case 1 -> changeLanguage();
           case 2 -> {}
           default -> {
               System.out.printf(Strings.optionDoesntExist + "\r\n", option);
               changeSettings();
           }
        }
    }

    private static void changeLanguage() {
        LanguageSelector languageSelector = LanguageSelector.getInstance();
        OutputManager.clearConsole();
        MenuPrinter.printLanguageSelectionMenu();
        byte option = InputManager.enterByte("> ");
        switch (option) {
            case 1 -> languageSelector.changeLanguageTo(Locale.ENGLISH);
            case 2 -> languageSelector.changeLanguageTo(Locale.GERMAN);
            case 3 -> {}
            default -> {
                System.out.printf(Strings.optionDoesntExist + "\r\n", option);
                changeLanguage();
            }
        }
    }
}