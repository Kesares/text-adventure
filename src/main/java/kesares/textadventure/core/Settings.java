package kesares.textadventure.core;

import kesares.textadventure.io.InputManager;
import kesares.textadventure.io.MenuPrinter;
import kesares.textadventure.io.OutputManager;
import kesares.textadventure.util.lang.LanguageSelector;

import java.util.Locale;

public final class Settings {

    private static final LanguageSelector LANGUAGE_SELECTOR = LanguageSelector.getInstance();

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
               OutputManager.printOptionDoesntExist(option);
               InputManager.enterToContinue();
               changeSettings();
           }
        }
    }

    private static void changeLanguage() {
        OutputManager.clearConsole();
        MenuPrinter.printLanguageSelectionMenu();
        byte option = InputManager.enterByte("> ");
        switch (option) {
            case 1 -> LANGUAGE_SELECTOR.changeLanguageTo(Locale.ENGLISH);
            case 2 -> LANGUAGE_SELECTOR.changeLanguageTo(Locale.GERMAN);
            case 3 -> {}
            default -> {
                OutputManager.printOptionDoesntExist(option);
                InputManager.enterToContinue();
                changeLanguage();
            }
        }
    }
}