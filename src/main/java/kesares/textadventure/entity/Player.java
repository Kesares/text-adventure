package kesares.textadventure.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kesares.textadventure.entity.ship.Ship;
import kesares.textadventure.entity.ship.Ships;
import kesares.textadventure.io.OutputManager;
import kesares.textadventure.item.Items;
import kesares.textadventure.util.lang.LanguageSelector;

public class Player extends Entity {

    @JsonIgnore
    private final Inventory inventory;
    @JsonIgnore
    private final Inventory equipment;

    public Player(String name) {
        super(name, 1, 0, 0,  Ship.Settings.copyOf(Ships.SLOOP));
        this.inventory = new Inventory(8);
        this.inventory.add(Items.STEEL_BALL, 1000);
        this.equipment = new Inventory(8);
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
        return String.format("Max HP:\t%10d%nHP:\t\t%10d%nLevel:\t%10d%nXP:\t\t%10d/?%nGold:\t%10d",
            this.maxHP,
            this.hp,
            this.level,
            this.exp,
            this.gold
        );
    }
}