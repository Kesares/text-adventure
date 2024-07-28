package kesares.textadventure.entity;

import kesares.textadventure.io.table.TablePrinter;
import kesares.textadventure.io.table.Tabulateable;
import kesares.textadventure.item.Item;
import kesares.textadventure.item.ItemStack;
import kesares.textadventure.io.table.InventoryTablePrinter;
import kesares.textadventure.util.Utils;

public class Inventory implements Tabulateable {

    private final ItemStack[] itemStacks;
    private boolean isFull;
    private final TablePrinter tablePrinter;

    public Inventory(String tablePrinterTitle, int size) {
        this.itemStacks = new ItemStack[size];
        this.isFull = false;
        this.tablePrinter = new InventoryTablePrinter(tablePrinterTitle, this.itemStacks, this.getColumnNames());
    }

    public void add(Item item, int amount) {
        if (this.isFull || this.isInvalidAmount(amount)) return;
        for (int i = 0; i < this.itemStacks.length; i++) {
            if (Utils.isNotNull(this.itemStacks[i]) && this.itemStacks[i].getItem().equals(item)) {
                this.itemStacks[i].add(amount);
                this.tablePrinter.update();
                return;
            } else if (this.itemStacks[i] == null) {
                this.itemStacks[i] = new ItemStack(item, amount);
                this.tablePrinter.update();
                return;
            }
        }
        this.isFull = true;
    }

    public void remove(Item item, int amount) {
        if (this.isInvalidAmount(amount)) return;
        for (int i = 0; i < this.itemStacks.length; i++) {
            if (Utils.isNotNull(this.itemStacks[i]) && this.itemStacks[i].getItem().equals(item)) {
                this.itemStacks[i].remove(amount);
                this.tablePrinter.update();

                if (this.isInvalidAmount(this.itemStacks[i].getAmount())) {
                    this.shiftItems(i);
                    this.isFull = false;
                    break;
                }
            }
        }
    }

    private void shiftItems(int index) {
        for (int i = index; i < this.itemStacks.length - 1; i++) {
            this.itemStacks[i] = this.itemStacks[i + 1];
        }
    }

    public void print() {
        this.tablePrinter.print();
    }

    public ItemStack[] getItemStacks() {
        return itemStacks;
    }

    public boolean isFull() {
        return isFull;
    }

    @Override
    public String[] getColumnNames() {
        return new String[] { "Nr.", "Item", "Menge" };
    }

    private boolean isInvalidAmount(int amount) {
        return amount <= 0;
    }
}