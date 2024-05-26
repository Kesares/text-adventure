package kesares.textadventure.io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleTableTest {

    private ConsoleTable table;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        table = new ConsoleTable("Header1", "Header2", "Header3");
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testConstructorInitializesHeadersCorrectly() {
        assertNotNull(table);
        assertEquals(0, table.getSize());
    }

    @Test
    public void testAddRowAddsRowCorrectly() {
        table.addRow("Row1Col1", "Row1Col2", "Row1Col3");
        assertEquals(1, table.getSize());
    }

    @Test
    public void testAddRowWithInvalidLengthThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> table.addRow("Row1Col1", "Row1Col2"));
    }

    @Test
    public void testPrintPrintsCorrectly() {
        table.addRow("Row1Col1", "Row1Col2", "Row1Col3");
        table.print();
        String output = outputStreamCaptor.toString().trim();

        assertTrue(output.contains("Header1"));
        assertTrue(output.contains("Row1Col1"));
    }

    @Test
    public void testGetSizeReturnsCorrectSize() {
        assertEquals(0, this.table.getSize());
        this.table.addRow("Row1Col1", "Row1Col2", "Row1Col3");
        assertEquals(1, this.table.getSize());
    }

    @Test
    public void testGetHeaderWidths() {
        int[] widths = this.table.getHeaderWidths(new String[] {"Header1444", "Header2", "Header3"});
        assertEquals(10, widths[0]);
        assertEquals(7, widths[1]);
        assertEquals(7, widths[2]);
    }
}