package kesares.textadventure.core;

import kesares.textadventure.io.InputManager;
import kesares.textadventure.io.MenuPrinter;
import kesares.textadventure.io.OutputManager;
import kesares.textadventure.util.lang.Language;
import kesares.textadventure.util.lang.LanguageSelector;

public final class GameSettings {

    private static final LanguageSelector LANGUAGE_SELECTOR = LanguageSelector.getInstance();

    private GameSettings() {
        throw new UnsupportedOperationException();
    }

    public static void changeSettings() {
        OutputManager.clearConsole();
        byte option = MenuPrinter.printSettingsMenu();
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
        byte option = MenuPrinter.printLanguageSelectionMenu();
        switch (option) {
            case 1 -> LANGUAGE_SELECTOR.changeLanguageTo(Language.EN_US);
            case 2 -> LANGUAGE_SELECTOR.changeLanguageTo(Language.DE_DE);
            case 3 -> {}
            default -> {
                OutputManager.printOptionDoesntExist(option);
                InputManager.enterToContinue();
                changeLanguage();
            }
        }
    }
}