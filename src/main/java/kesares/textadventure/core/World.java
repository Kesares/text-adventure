package kesares.textadventure.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import kesares.textadventure.entity.Battle;
import kesares.textadventure.entity.Inventory;
import kesares.textadventure.entity.NPC;
import kesares.textadventure.entity.Player;
import kesares.textadventure.io.InputManager;
import kesares.textadventure.io.MenuPrinter;
import kesares.textadventure.io.OutputManager;
import kesares.textadventure.item.Items;
import kesares.textadventure.util.AnsiColor;
import kesares.textadventure.util.Refactor;
import kesares.textadventure.util.Utils;
import kesares.textadventure.util.lang.LanguageSelector;

public class World {

    private String name;
    private final Player player;

    @JsonCreator
    public World(@JsonProperty("name") String name, @JsonProperty("player") Player player) {
        this.name = name;
        this.player = player;
    }

    public World(String name) {
        this(name, createPlayer());
    }


    public void changeWorldName() {
        OutputManager.printBoldPartingLine();
        String name = InputManager.enterString("Neuer Weltname: ");
        if (Utils.isInvalidString(name)) {
            OutputManager.printColorText(LanguageSelector.strings.invalidWorldName, AnsiColor.YELLOW);
            this.changeWorldName();
        }
        this.name = name;
    }

    public void update() {
        while (true) {
            InputManager.enterToContinue();
            OutputManager.clearConsole();
            final byte option = MenuPrinter.printWorldMenu(this.name);
            switch (option) {
                case 1 -> this.continueJourney();
                case 2 -> this.player.printStats();
                case 3 -> this.player.printInventory();
                case 4 -> GameSettings.changeSettings();
                case 5 -> { return; }
                default -> OutputManager.printOptionDoesntExist(option);
            }
        }
    }

    private void continueJourney() {
        OutputManager.clearConsole();
        double eventRate = Math.random();

        if (eventRate < 0.8) {
            Battle battle = new Battle(this.player, NPC.create(this.player.getLevel()));
            battle.begin();
        } else {
            OutputManager.printTitle(LanguageSelector.strings.peacefulJourney);
        }
    }

    @Refactor(msg = "static")
    private static Player createPlayer() {
        OutputManager.clearConsole();
        OutputManager.printTitle(LanguageSelector.strings.createNewPlayer);
        String name = InputManager.enterString(LanguageSelector.strings.playerName);
        OutputManager.printBoldPartingLine();
        if (Utils.isInvalidString(name)) {
            OutputManager.printColorText(LanguageSelector.strings.invalidPlayerName, AnsiColor.YELLOW);
            return createPlayer();
        }
        Inventory inventory = new Inventory("Inventar", Items.ITEMS.size());
        inventory.add(Items.STEEL_BALL, 1000);
        inventory.add(Items.STONE_BALL, 1000);
        return new Player(name, inventory);
    }

    public String getName() {
        return name;
    }

    public Player getPlayer() {
        return player;
    }
}