package kesares.textadventure.io.table;

import kesares.textadventure.io.OutputManager;

public abstract class TablePrinter {

    protected final String title;
    private final String[] headers;
    protected final int[] widthsCache;
    protected int tableWidth;
    protected final StringBuilder headerBuilder;
    protected final StringBuilder bodyBuilder;

    public TablePrinter(String title, String... headers) {
        this.title = title;
        this.headers = headers;
        this.widthsCache = this.getHeaderWidths(headers);
        this.headerBuilder = new StringBuilder();
        this.bodyBuilder = new StringBuilder();
    }

    public void update() {
        this.calculateColumnWidths();
        this.calculateTableWidth();
        this.tableWidth = Math.max(this.tableWidth, this.title.length());
    }

    public void print() {
        this.update();
        OutputManager.printTitle(this.title, this.tableWidth);
        this.printHeaders();
        this.printBody();
        this.resetBuilder();
    }

    protected abstract void printBody();
    protected abstract void calculateColumnWidths();

    protected void printHeaders() {
        for (int i = 0; i < this.headers.length; i++) {
            this.headerBuilder.append(String.format("| %-" + this.widthsCache[i] + "s ", this.headers[i]));
        }
        this.headerBuilder.append('|');
        System.out.println(this.headerBuilder);
    }

    protected void resetBuilder() {
        this.headerBuilder.setLength(0);
        this.bodyBuilder.setLength(0);
    }

    private int[] getHeaderWidths(String[] headers) {
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
}
