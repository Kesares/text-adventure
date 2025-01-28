package kesares.textadventure.item;

import kesares.textadventure.util.AnsiColor;

public class ItemStack {

    private final Item item;
    private final int maxStackSize;
    private int amount;

    public ItemStack(Item item, int maxStackSize, int amount) {
        this.item = item;
        this.maxStackSize = maxStackSize;
        this.amount = amount;
    }

    public ItemStack(Item item, int amount) {
        this(item, Integer.MAX_VALUE, amount);
    }

    public int push(int amount) {
        int availableSpace = this.maxStackSize - this.amount;
        int added = Math.min(availableSpace, amount);
        this.amount += added;
        return amount - added;
    }

    public void pop(int amount) {
        if (this.amount - amount <= 0) {
            this.amount = 0;
        } else {
            this.amount -= amount;
        }
    }

    @Override
    public String toString() {
        return String.format("%s%15s (%d)%s", this.item.getRarity().getColor(), this.item.getName(), this.amount,  AnsiColor.RESET);
    }

    public Item getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }
}