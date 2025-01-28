package kesares.textadventure.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import kesares.textadventure.io.serial.InventoryDeserializer;
import kesares.textadventure.io.serial.InventorySerializer;
import kesares.textadventure.io.table.InventoryTablePrinter;
import kesares.textadventure.io.table.TablePrinter;
import kesares.textadventure.io.table.Tabulateable;
import kesares.textadventure.item.Item;
import kesares.textadventure.item.ItemStack;

import java.util.Objects;


/**
 * Represents an inventory that holds {@link ItemStack} objects and provides methods to add, remove, and print items.
 *
 * <p>The inventory is serialized and deserialized using {@link InventorySerializer} and {@link InventoryDeserializer}
 * respectively. It implements the {@link Tabulateable} interface for tabular representation of its contents.</p>
 */
@JsonDeserialize(using = InventoryDeserializer.class)
@JsonSerialize(using = InventorySerializer.class)
public class Inventory implements Tabulateable {

    private final ItemStack[] itemStacks;
    private boolean isFull;
    private final TablePrinter tablePrinter;

    /**
     * Constructs an {@code Inventory} with a specified table printer title and an array of {@link ItemStack} objects.
     *
     * @param tablePrinterTitle the title to be used by the {@link TablePrinter}
     * @param itemStacks        an array of {@link ItemStack} objects representing the initial inventory
     */
    public Inventory(String tablePrinterTitle, ItemStack[] itemStacks) {
        this.itemStacks = itemStacks;
        this.isFull = false;
        this.tablePrinter = new InventoryTablePrinter(tablePrinterTitle, this.itemStacks, this.getColumnNames());
    }

    /**
     * Constructs an {@code Inventory} with a specified table printer title and a given {@code size} for the inventory.
     *
     * @param tablePrinterTitle the title to be used by the {@link TablePrinter}
     * @param size              the number of {@link ItemStack} slots in the inventory
     */
    public Inventory(String tablePrinterTitle, int size) {
        this(tablePrinterTitle, new ItemStack[size]);
    }

    /**
     * Adds an {@link Item} to the inventory with a specified amount.
     *
     * <p>If the inventory is full or the amount is invalid, the item will not be added.
     * If the item already exists in the inventory, its amount would be increased. Otherwise, a new {@link ItemStack}
     * is created.
     *
     * @param item   the {@link Item} to be added
     * @param amount the amount of the item to be added
     */
    public void add(Item item, int amount) {
        if (this.isFull || this.isInvalidAmount(amount)) return;
        for (int i = 0; i < this.itemStacks.length; i++) {
            if (Objects.nonNull(this.itemStacks[i]) && this.itemStacks[i].getItem().equals(item)) {
                this.itemStacks[i].push(amount);
                return;
            } else if (this.itemStacks[i] == null) {
                this.itemStacks[i] = new ItemStack(item, amount);
                return;
            }
        }
        this.isFull = true;
    }

    /**
     * Removes a specified amount of the given {@link Item} from the inventory.
     *
     * <p>This method iterates through the {@link ItemStack} array and finds the first matching {@link Item}.
     * It then attempts to remove the specified {@code amount} from that {@link ItemStack}. If the removal results in
     * the {@link ItemStack} having an invalid amount (less than or equal to zero), it shifts the remaining items
     * to the left to fill the gap and updates the inventory status.</p>
     *
     * <p>If the specified amount is invalid (i.e., less than or equal to zero) the method does nothing.
     * If no matching item is found, no changes are made to the inventory.</p>
     *
     * @param item   the {@link Item} to be removed
     * @param amount the amount of the {@link Item} to be removed
     */
    public void remove(Item item, int amount) {
        if (this.isInvalidAmount(amount)) return;
        for (int i = 0; i < this.itemStacks.length; i++) {
            if (Objects.nonNull(this.itemStacks[i]) && this.itemStacks[i].getItem().equals(item)) {
                this.itemStacks[i].pop(amount);

                if (this.isInvalidAmount(this.itemStacks[i].getAmount())) {
                    this.shiftItems(i);
                    this.isFull = false;
                    return;
                }
            }
        }
    }

    private void shiftItems(int index) {
        for (int i = index; i < this.itemStacks.length - 1; i++) {
            this.itemStacks[i] = this.itemStacks[i + 1];
        }
    }

    /**
     * Prints the inventory using the associated {@link TablePrinter}.
     */
    public void print() {
        this.tablePrinter.print();
    }

    public ItemStack[] getItemStacks() {
        return itemStacks;
    }

    /**
     * Provides the column names for tabular representation of the inventory.
     *
     * <p>This method is part of the {@link Tabulateable} interface.</p>
     *
     * @return an array of column names
     */
    @JsonIgnore
    @Override
    public String[] getColumnNames() {
        return new String[] { "Nr.", "Item", "Menge" };
    }

    private boolean isInvalidAmount(int amount) {
        return amount <= 0;
    }
}