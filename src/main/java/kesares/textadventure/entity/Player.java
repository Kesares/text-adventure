package kesares.textadventure.entity;

import kesares.textadventure.io.OutputManager;
import kesares.textadventure.util.lang.Strings;

public class Player extends Entity {

    public Player() {
        super("undefined", 10, 1, 0, 0, 3, 0, 0);
    }

    public void printStats() {
        OutputManager.clearConsole();
        OutputManager.printTitle(Strings.playerStatsTitle + this.name);
        System.out.println(this);
        OutputManager.printBoldPartingLine();
    }

    public void printInventory() {
        OutputManager.clearConsole();
        OutputManager.printTitle(Strings.inventoryTitle);
        System.out.println("Coming soon");
        OutputManager.printBoldPartingLine();
    }

    @Override
    public String toString() {
        return String.format("Max HP:\t%10d\r\nHP:\t\t%10d\r\nLevel:\t%10d\r\nXP:\t\t%10d\r\nGold:\t%10d\r\nATK:\t%10d\r\nDEF:\t%10d\r\nArmor:\t%10d",
                this.maxHP,
                this.HP,
                this.level,
                this.exp,
                this.gold,
                this.atk,
                this.def,
                this.armor
        );
    }
}