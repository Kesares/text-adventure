package kesares.textadventure.core;

import kesares.textadventure.entity.Player;
import kesares.textadventure.io.InputManager;
import kesares.textadventure.io.MenuPrinter;
import kesares.textadventure.io.OutputManager;
import kesares.textadventure.util.lang.LanguageSelector;

import java.util.Locale;

public class Game {

    private boolean isRunning;
    private final Player player;
    private final Story story;

    public Game() {
        this.isRunning = true;
        this.player = new Player();
        this.story = new Story(this.player);
        this.init();
    }

    private void init() {
        LanguageSelector.getInstance().changeLanguageTo(Locale.GERMAN);
    }

    public void update() {
        InputManager.enterToContinue();
        OutputManager.clearConsole();
        MenuPrinter.printMainMenu();
        byte option = InputManager.enterByte("> ");
        switch (option) {
            case 1 -> this.story.continueJourney();
            case 2 -> this.player.printStats();
            case 3 -> this.player.printInventory();
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