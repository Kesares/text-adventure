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

    public void add(int amount) {
        if (this.amount + amount <= this.maxStackSize) {
            this.amount += amount;
        }
    }

    public void remove(int amount) {
        if (this.amount - amount <= 0) {
            this.amount = 0;
        } else {
            this.amount -= amount;
        }
    }

    @Override
    public String toString() {
        return String.format(this.item.getRarity().getColor() + "%15s (%d)" + AnsiColor.RESET, this.item.getName(), this.amount);
    }

    public Item getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }
}