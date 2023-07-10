package kesares.textadventure.core;

import kesares.textadventure.entity.Battle;
import kesares.textadventure.entity.Invader;
import kesares.textadventure.entity.Player;
import kesares.textadventure.io.InputManager;
import kesares.textadventure.io.MenuPrinter;
import kesares.textadventure.io.OutputManager;
import kesares.textadventure.util.lang.Strings;

public class Story {

    private static final String[] INVADERS = {"Ogre", "Goblin", "Griffon"};

    private boolean isRunning;
    private final Player player;

    public Story() {
        this.isRunning = false;
        this.player = new Player("undefined");
    }

    public void run() {
        this.isRunning = true;
        byte option;
        while(this.isRunning) {
            InputManager.enterToContinue();
            OutputManager.clearConsole();
            MenuPrinter.printStoryMenu();
            option = InputManager.enterByte("> ");
            this.update(option);
        }
    }

    private void update(byte option) {
        switch (option) {
            case 1 -> this.continueJourney();
            case 2 -> this.player.printStats();
            case 3 -> this.player.printInventory();
            case 4 -> this.isRunning = false;
            default -> OutputManager.printOptionDoesntExist(option);
        }
    }

    private void continueJourney() {
        OutputManager.clearConsole();
        double eventRate = Math.random();

        if (eventRate < 0.7) {
            Battle battle = new Battle(this.player, this.getRandomInvader());
            battle.begin();
        } else if (eventRate < 0.9) {
            System.out.println(Strings.peacefulJourney);
        }
    }

    private Invader getRandomInvader() {
        int index = (int) (Math.random() * INVADERS.length);
        return new Invader(INVADERS[index], this.player.getLevel());
    }

    private String enterPlayerName() {
        boolean isPlayerNameSet = false;
        String name;

        do {
            OutputManager.clearConsole();
            OutputManager.printTitle(Strings.whatIsYourPlayerName);
            name = InputManager.enterString(Strings.playerName);
            OutputManager.clearConsole();
            OutputManager.printTitle(String.format(Strings.playerNameCorrect, name));
            byte option = InputManager.enterByte(Strings.yesNo);
            if (option == 1) isPlayerNameSet = true;
        } while(!isPlayerNameSet);
        return name;
    }
}