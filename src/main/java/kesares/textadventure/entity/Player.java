package kesares.textadventure.entity;

import kesares.textadventure.io.OutputManager;
import kesares.textadventure.util.lang.Strings;

public class Player extends Entity {

    private static final int[] REQUIRED_XP_FOR_LEVEL_UP = {15, 24, 34, 43, 53, 63, 72, 82, 92, 101, 111, 121, 130, 140, 149};

    private final Inventory inventory;

    public Player(String name) {
        super(name, new int[] {10, 1, 0, 0, 3, 0, 0});
        this.inventory = new Inventory(10);
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
        this.inventory.printInventory();
        OutputManager.printBoldPartingLine();
    }

    @Override
    public String toString() {
        return String.format("Max HP:\t%10d\r\nHP:\t\t%10d\r\nLevel:\t%10d\r\nXP:\t\t%10d/%d\r\nGold:\t%10d\r\nATK:\t%10d\r\nDEF:\t%10d\r\nArmor:\t%10d",
                this.maxHP,
                this.HP,
                this.level,
                this.exp,
                REQUIRED_XP_FOR_LEVEL_UP[this.level - 1],
                this.gold,
                this.atk,
                this.def,
                this.armor
        );
    }

    @Override
    public void addExp(int exp) {
        super.addExp(exp);
        this.checkLevelUp();
    }

    private void checkLevelUp() {
        for (int level = REQUIRED_XP_FOR_LEVEL_UP.length - 1; level >= 0; level--) {
            if (this.hasRequiredExpForLevelUp(level)) {
                this.level++;
                this.maxHP++;
                this.HP++;
                OutputManager.printTitle(String.format("You are now level %d.", this.level));
                return;
            }
        }
    }

    private boolean hasRequiredExpForLevelUp(int level) {
        return this.exp >= REQUIRED_XP_FOR_LEVEL_UP[level];
    }
}