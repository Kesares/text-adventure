package kesares.textadventure.entity;

import kesares.textadventure.io.ConsoleTable;
import kesares.textadventure.item.Item;
import kesares.textadventure.item.ItemStack;
import kesares.textadventure.util.Utils;
import kesares.textadventure.util.lang.LanguageSelector;

public class Inventory {

    private final ItemStack[] itemStacks;
    private boolean isFull;
    private final ConsoleTable consoleTable;

    public Inventory(int size) {
        this.itemStacks = new ItemStack[size];
        this.isFull = false;
        this.consoleTable = new ConsoleTable(LanguageSelector.strings.numero, "Item", "Anzahl");
    }

    public void add(Item item, int amount) {
        if (this.isInvalidAmount(amount)) return;
        for (int i = 0; i < this.itemStacks.length; i++) {
            if (!Utils.isNull(this.itemStacks[i]) && this.itemStacks[i].getItem().equals(item)) {
                this.itemStacks[i].add(amount);
                this.consoleTable.addRow(i + 1 + ".", item.getName(), String.valueOf(this.itemStacks[i].getAmount()));
                return;
            } else if (this.itemStacks[i] == null) {
                this.itemStacks[i] = new ItemStack(item, amount);
                this.consoleTable.addRow(i + 1 + ".", item.getName(), String.valueOf(this.itemStacks[i].getAmount()));
                return;
            }
        }
        this.isFull = true;
    }

    public void remove(Item item, int amount) {
        if (this.isInvalidAmount(amount)) return;
        for (int i = 0; i < this.itemStacks.length; i++) {
            if (!Utils.isNull(this.itemStacks[i]) && this.itemStacks[i].getItem().equals(item)) {
                this.itemStacks[i].remove(amount);

                if (this.isInvalidAmount(this.itemStacks[i].getAmount())) {
                    this.itemStacks[i] = null;
                    this.isFull = false;
                }
            }
        }
    }

    public void printInventory(String title) {
        this.consoleTable.print(title);
    }

    private boolean isInvalidAmount(int amount) {
        return amount <= 0;
    }
}