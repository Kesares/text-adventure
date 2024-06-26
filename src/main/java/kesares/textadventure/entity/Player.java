package kesares.textadventure.entity;

import kesares.textadventure.entity.ship.Ship;
import kesares.textadventure.entity.ship.Ships;
import kesares.textadventure.io.OutputManager;
import kesares.textadventure.util.lang.LanguageSelector;

public class Player extends Entity {

    public Player(String name) {
        super(name, Ship.Settings.copyOf(Ships.SLOOP), 1, 0, 0);
    }

    public Player() {
        this("undefined");
    }

    public void printStats() {
        OutputManager.clearConsole();
        OutputManager.printTitle(LanguageSelector.strings.playerStatsTitle + this.name);
        System.out.println(this);
        OutputManager.printBoldPartingLine();
    }

    public void printInventory() {
        OutputManager.printComingSoon("Inventory – ");
    }

    @Override
    public String toString() {
        return String.format("Max HP:\t%10d%nHP:\t\t%10d%nLevel:\t%10d%nXP:\t\t%10d/?%nGold:\t%10d",
            this.maxHP,
            this.hp,
            this.level,
            this.exp,
            this.gold
        );
    }
}