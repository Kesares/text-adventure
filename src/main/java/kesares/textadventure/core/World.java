package kesares.textadventure.core;

import kesares.textadventure.entity.Player;
import kesares.textadventure.io.InputManager;
import kesares.textadventure.io.MenuPrinter;
import kesares.textadventure.io.OutputManager;
import kesares.textadventure.util.AnsiColor;
import kesares.textadventure.util.Refactor;
import kesares.textadventure.util.lang.LanguageSelector;

public class World {

    private String name;
    private Player player;

    public World(String name, Player player) {
        this.name = name;
        this.player = player;
    }

    public World(String name) {
        this(name, createPlayer());
    }

    public World() {}

    public void changeWorldName() {
        OutputManager.printBoldPartingLine();
        String name = InputManager.enterString("Neuer Weltname: ");
        if (!isValidString(name)) {
            OutputManager.printColorText(LanguageSelector.strings.invalidWorldName, AnsiColor.YELLOW);
            this.changeWorldName();
        }
        this.name = name;
    }

    public void load() {
        while (true) {
            InputManager.enterToContinue();
            OutputManager.clearConsole();
            final byte option = MenuPrinter.printWorldMenu(this.name);
            switch (option) {
                case 1 -> this.continueJourney();
                case 2 -> this.player.printStats();
                case 3 -> this.player.printInventory();
                case 4 -> Settings.changeSettings();
                case 5 -> { return; }
                default -> OutputManager.printOptionDoesntExist(option);
            }
        }
    }

    private void continueJourney() {
        OutputManager.printComingSoon("Story fortsetzen... - ");
//        OutputManager.clearConsole();
//        double eventRate = Math.random();
//
//        if (eventRate < 0.7) {
//            Battle battle = new Battle(this.player, this.getRandomInvader());
//            battle.begin();
//        } else if (eventRate < 0.9) {
//            OutputManager.printTitle(Strings.peacefulJourney);
//        }
    }
//    private Invader getRandomInvader() {
////        int index = (int) (Math.random() * Strings.invaderNames.length);
//        return new Invader(Strings.invaderNames[index], this.player.getLevel());

//    }

    @Refactor(msg = "static")
    private static Player createPlayer() {
        OutputManager.clearConsole();
        OutputManager.printTitle(LanguageSelector.strings.createNewPlayer);
        String name = InputManager.enterString(LanguageSelector.strings.playerName);
        OutputManager.printBoldPartingLine();
        if (!isValidString(name)) {
            OutputManager.printColorText(LanguageSelector.strings.invalidPlayerName, AnsiColor.YELLOW);
            return createPlayer();
        }
        return new Player(name);
    }

    private static boolean isValidString(String text) {
        return !text.isEmpty() || !text.isBlank();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}