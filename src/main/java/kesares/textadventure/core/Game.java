package kesares.textadventure.core;

import kesares.textadventure.io.InputManager;
import kesares.textadventure.io.MenuPrinter;
import kesares.textadventure.io.OutputManager;
import kesares.textadventure.util.lang.Language;
import kesares.textadventure.util.lang.LanguageSelector;

import java.util.Locale;

public class Game {

    private boolean isRunning;

    public Game() {
        this.initResources();
        this.isRunning = true;
    }

    private void initResources() {
        LanguageSelector.getInstance().changeLanguageTo(Language.GERMAN);
    }

    public void update() {
        InputManager.enterToContinue();
        OutputManager.clearConsole();
        byte option = MenuPrinter.printMainMenu();
        switch (option) {
            case 1 -> new Story().run();
            case 2 -> Settings.changeSettings();
            case 3 -> this.exit();
            default -> OutputManager.printOptionDoesntExist(option);
        }
    }

    private void exit() {
        System.out.println("Bye.");
        this.isRunning = false;
    }

    public boolean isRunning() {
        return isRunning;
    }
}