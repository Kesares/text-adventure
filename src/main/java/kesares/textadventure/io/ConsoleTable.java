package kesares.textadventure.io;

import kesares.textadventure.util.lang.LanguageSelector;

import java.util.ArrayList;
import java.util.List;

public class ConsoleTable {

    private final String[] headers;
    private final List<String[]> rows;
    private final int[] widthsCache;
    private int tableWidth;

    public ConsoleTable(String... headers) {
        this.headers = headers;
        this.rows = new ArrayList<>();
        this.widthsCache = this.getHeaderWidths(headers);
    }

    public void addRow(String... row) {
        if (row == null || row.length != this.headers.length) throw new IllegalArgumentException("Invalid row length");
        this.calculateColumnWidths(row);
        this.calculateTableWidth();
        this.rows.add(row);
    }

    public void print() {
        OutputManager.printTitle(LanguageSelector.strings.loadingWorldsMenuTitle, this.tableWidth);
        this.printHeaders();
        OutputManager.printPartingLine(OutputManager.MINUS_SIGN, this.tableWidth);
        this.printData();
        OutputManager.printPartingLine(OutputManager.MINUS_SIGN, this.tableWidth);
        System.out.printf("| %d: Zurück |%n", this.rows.size() + 1);
        OutputManager.printPartingLine(OutputManager.EQUAL_SIGN, this.tableWidth);
    }

    public int getSize() {
        return this.rows.size();
    }

    private void printData() {
        for (String[] row : this.rows) {
            for (int i = 0; i < row.length; i++) {
                final int width = this.widthsCache[i];
                System.out.printf("| %-" + width + "s ", row[i]);
            }
            System.out.println('|');
        }
    }

    private void printHeaders() {
        for (int i = 0; i < this.headers.length; i++) {
            final int width = this.widthsCache[i];
            System.out.printf("| %-" + width + "s ", this.headers[i]);
        }
        System.out.println('|');
    }

    public int[] getHeaderWidths(String[] headers) {
        int[] widths = new int[headers.length];
        for (int i = 0; i < headers.length; i++) {
            widths[i] = headers[i].length();
        }
        return widths;
    }

    private void calculateTableWidth() {
        int sum = this.headers.length * 3 + 1;
        for (int i : this.widthsCache) {
            sum += i;
        }
        this.tableWidth = sum;
    }

    private void calculateColumnWidths(String[] row) {
        for (int i = 0; i < row.length; i++) {
            this.widthsCache[i] = Math.max(this.widthsCache[i], row[i].length());
        }
    }
}
