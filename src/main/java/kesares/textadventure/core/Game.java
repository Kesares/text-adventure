package kesares.textadventure.core;

import kesares.textadventure.io.OutputManager;
import kesares.textadventure.util.lang.LanguageSelector;

import java.util.Locale;

public class Game {

    private boolean isRunning;

    public Game() {
        this.isRunning = true;
        this.init();
    }

    private void init() {
        LanguageSelector.getInstance().changeLanguageTo(Locale.GERMAN);
    }

    public void update(byte option) {
        switch (option) {
            case 1 -> System.out.println("Continue story...");
            case 2 -> System.out.println("Character info");
            case 3 -> System.out.println("Inventory");
            case 4 -> Settings.changeSettings();
            case 5 -> this.exit();
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