package kesares.textadventure.io.table;

import kesares.textadventure.core.World;
import kesares.textadventure.io.OutputManager;
import kesares.textadventure.util.AnsiColor;
import kesares.textadventure.util.lang.LanguageSelector;

import java.util.List;

public class WorldTablePrinter extends TablePrinter {

    private final List<World> worlds;

    public WorldTablePrinter(String title, List<World> worlds, String... headers) {
        super(title, headers);
        this.worlds = worlds;
    }

    @Override
    public void print() {
        super.print();
        System.out.printf("| %-" + this.widthsCache[0] + "s | %-" + this.widthsCache[1] + "s |%n", this.worlds.size() + 1 + ".", LanguageSelector.strings.back);
        OutputManager.printPartingLine(OutputManager.EQUAL_SIGN, this.tableWidth);
    }

    @Override
    protected void printBody() {
        if (this.worlds.isEmpty()) {
            OutputManager.printTitle("-", '-', this.tableWidth, AnsiColor.RESET);
            return;
        }

        OutputManager.printPartingLineWithBorder(OutputManager.MINUS_SIGN, this.tableWidth, '|');
        for (int i = 0; i < this.worlds.size(); i++) {
            this.bodyBuilder
                    .append(String.format("| %-" + this.widthsCache[0] + "s ", i + 1))
                    .append(String.format("| %-" + this.widthsCache[1] + "s |%n", this.worlds.get(i).getName()));
        }
        System.out.print(this.bodyBuilder);
        OutputManager.printPartingLineWithBorder(OutputManager.MINUS_SIGN, this.tableWidth, '|');
    }

    @Override
    protected void calculateColumnWidths() {
        this.widthsCache[0] = Math.max(this.widthsCache[0], String.valueOf(this.worlds.size()).length());
        if (!this.worlds.isEmpty()) {
            this.widthsCache[1] = Math.max(this.widthsCache[1], this.worlds.getLast().getName().length());
        }
    }
}
