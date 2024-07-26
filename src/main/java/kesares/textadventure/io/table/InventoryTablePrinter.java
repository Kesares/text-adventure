package kesares.textadventure.io.table;

import kesares.textadventure.io.OutputManager;
import kesares.textadventure.item.ItemStack;
import kesares.textadventure.util.AnsiColor;
import kesares.textadventure.util.Utils;

public class InventoryTablePrinter extends TablePrinter {

    private final ItemStack[] itemStacks;

    public InventoryTablePrinter(String title, ItemStack[] itemStacks, String... headers) {
        super(title, headers);
        this.itemStacks = itemStacks;
    }

    @Override
    protected void printBody() {
        if (Utils.isAllNull(this.itemStacks)) {
            OutputManager.printTitle("-", '-', this.tableWidth, AnsiColor.RESET);
            return;
        }
        OutputManager.printPartingLineWithBorder(OutputManager.MINUS_SIGN, this.tableWidth, '|');
        for (int i = 0; i < this.itemStacks.length; i++) {
            if (this.itemStacks[i] == null) break;
            this.bodyBuilder
                    .append(String.format("| %-" + this.widthsCache[0] + "s ", i + 1))
                    .append(String.format("| %s%-" + this.widthsCache[1] + "s%s ", this.itemStacks[i].getItem().getRarity().getColor(), this.itemStacks[i].getItem().getName(), AnsiColor.RESET))
                    .append(String.format("| %-" + this.widthsCache[2] + "s |%n", this.itemStacks[i].getAmount()));
        }
        System.out.print(this.bodyBuilder);
        OutputManager.printPartingLine('=', this.tableWidth);
    }

    @Override
    protected void calculateColumnWidths() {
        for (int i = this.itemStacks.length - 1; i >= 0; i--) {
            if (Utils.isNotNull(this.itemStacks[i])) {
                this.widthsCache[0] = Math.max(this.widthsCache[0], String.valueOf(i).length());
                this.widthsCache[1] = Math.max(this.widthsCache[1], this.itemStacks[i].getItem().getName().length());
                this.widthsCache[2] = Math.max(this.widthsCache[2], String.valueOf(this.itemStacks[i].getAmount()).length());
                return;
            }
        }
    }
}
