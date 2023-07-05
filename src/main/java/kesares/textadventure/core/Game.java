package kesares.textadventure.core;

import kesares.textadventure.entity.Player;
import kesares.textadventure.io.InputManager;
import kesares.textadventure.io.MenuPrinter;
import kesares.textadventure.io.OutputManager;
import kesares.textadventure.util.lang.LanguageSelector;
import kesares.textadventure.util.lang.Strings;

import java.util.Locale;

public class Game {

    private boolean isRunning;
    private final Player player;
    private final Story story;

    public Game() {
        this.init();
        this.isRunning = true;
        this.player = new Player("undefined");
        this.story = new Story(this.player);
    }

    private String enterPlayerName() {
        boolean isPlayerNameSet = false;
        String name;

        do {
            OutputManager.printTitle(Strings.whatIsYourPlayerName);
            name = InputManager.enterString(Strings.playerName);
            OutputManager.clearConsole();
            OutputManager.printTitle(String.format(Strings.playerNameCorrect, name));
            byte option = InputManager.enterByte(Strings.yesNo);
            if (option == 1) isPlayerNameSet = true;
        } while(!isPlayerNameSet);
        return name;
    }

    private void init() {
        LanguageSelector.getInstance().changeLanguageTo(Locale.ENGLISH);
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