package kesares.textadventure.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kesares.textadventure.entity.ship.Ship;
import kesares.textadventure.entity.ship.Ships;
import kesares.textadventure.io.OutputManager;
import kesares.textadventure.item.Items;
import kesares.textadventure.util.lang.LanguageSelector;

import java.util.Arrays;

public class Player extends Entity {

    private static final int[] REQUIRED_XP_FOR_LEVEL_UP = {2_550, 4_000, 5_000, 6_250, 7_750, 9_500, 11_500, 13_750,
            16_250, 19_000, 22_000, 25_250, 28_750, 32_500, 36_500, 40_750, 45_250, 50_000, 60_000};

    @JsonIgnore
    private final Inventory inventory;
    @JsonIgnore
    private final Inventory equipment;

    public Player(String name) {
        super(name, 1, 0, 0, Ship.Settings.copyOf(Ships.SLOOP));
        this.inventory = new Inventory(Items.ITEMS.size());
        this.inventory.add(Items.STEEL_BALL, 1000);
        this.equipment = new Inventory(8);
    }

    public Player() {
        this("undefined");
    }

    public void printStats() {
        OutputManager.clearConsole();
        OutputManager.printTitle(LanguageSelector.strings.playerStatsTitle + super.name);
        System.out.println(this);
        OutputManager.printBoldPartingLine();
    }

    public void printInventory() {
        OutputManager.clearConsole();
        this.inventory.print();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Inventory getEquipment() {
        return equipment;
    }

    @Override
    public String toString() {
        return String.format("Max HP:\t%10d%nHP:\t\t%10d%nLevel:\t%10d%nXP:\t\t%10d/%d%nGold:\t%10d%nSchiff:\t%s%s%n",
            super.maxHP,
            super.hp,
            super.level,
            super.exp,
            REQUIRED_XP_FOR_LEVEL_UP[super.level - 1],
            super.gold,
            super.ship.getId(),
            Arrays.toString(this.equipment.getItemStacks())
        );
    }

    @Override
    public void addExp(int exp) {
        super.addExp(exp);
        this.checkLevelUp();
    }

    private void checkLevelUp() {
        while (this.hasRequiredExpForLevelUp()) {
            super.level++;
            OutputManager.printTitle(String.format(LanguageSelector.strings.levelUp, super.level));
        }
    }

    private boolean hasRequiredExpForLevelUp() {
        return super.exp >= REQUIRED_XP_FOR_LEVEL_UP[super.level - 1];
    }
}