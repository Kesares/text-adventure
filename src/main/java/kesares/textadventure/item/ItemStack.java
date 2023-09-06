package kesares.textadventure.item;

public class ItemStack {

    private final Item item;
    private int amount;

    public ItemStack(Item item, int amount) {
        this.item = item;
        this.amount = amount;
    }

    public void add(int amount) {
        this.amount += amount;
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
        return String.format("%15s (%d)", this.item.getName(), this.amount);
    }

    public Item getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }
}