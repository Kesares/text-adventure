package kesares.textadventure.entity;

import kesares.textadventure.item.Item;
import kesares.textadventure.item.ItemStack;
import kesares.textadventure.util.Utils;

public class Inventory {

    private final ItemStack[] itemStacks;
    private boolean isFull;

    public Inventory(int size) {
        this.itemStacks = new ItemStack[size];
        this.isFull = false;
    }

    public void add(Item item, int amount) {
        if (this.isInvalidAmount(amount)) return;
        for (int i = 0; i < this.itemStacks.length; i++) {
            if (!Utils.isNull(this.itemStacks[i]) && this.itemStacks[i].getItem().equals(item)) {
                this.itemStacks[i].add(amount);
                return;
            } else if (this.itemStacks[i] == null) {
                this.itemStacks[i] = new ItemStack(item, amount);
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

    public void printInventory() {
        for (int i = 0; i < this.itemStacks.length; i++) {
            System.out.printf("%2d. %s\r\n",
                i + 1,
                Utils.isNull(this.itemStacks[i]) ? "-" : this.itemStacks[i]
            );
        }
    }

    private boolean isInvalidAmount(int amount) {
        return amount <= 0;
    }
}