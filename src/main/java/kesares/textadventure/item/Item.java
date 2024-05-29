package kesares.textadventure.item;

import kesares.textadventure.util.AnsiColor;

public class Item {

    private final String ID;
    private final String name;
    private final AnsiColor rarity;

    public Item(String ID, String name, AnsiColor rarity) {
        this.ID = ID;
        this.name = name;
        this.rarity = rarity;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public AnsiColor getRarity() {
        return rarity;
    }
}