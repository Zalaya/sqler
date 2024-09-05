package infrastructure.adapter.reader;

import domain.model.Table;
import domain.port.outbound.FileReaderPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CsvFileReaderAdapterTest {

    private FileReaderPort reader;

    @BeforeEach
    public void setUp() {
        reader = new CsvFileReaderAdapter();
    }

    @Test
    public void shouldReadAndMapTheNameOfAValidCsvFile() {
        // GIVEN
        File file = new File("src/test/resources/valid.csv");

        // WHEN
        Table table = reader.read(file);

        // THEN
        assertEquals("valid", table.getName().getValue());
    }

    @Test
    public void shouldReadAndMapTheColumnHeadersOfAValidCsvFile() {
        // GIVEN
        File file = new File("src/test/resources/valid.csv");

        // WHEN
        Table table = reader.read(file);

        // THEN
        assertEquals("Name", table.getColumns().get(0).getName().getValue());
        assertEquals("Age", table.getColumns().get(1).getName().getValue());
    }

    @Test
    public void shouldReadAndMapTheColumnValuesOfAValidCsvFile() {
        // GIVEN
        File file = new File("src/test/resources/valid.csv");

        // WHEN
        Table table = reader.read(file);

        // THEN
        assertEquals("John", table.getColumns().get(0).getValues().get(0));
        assertEquals("25", table.getColumns().get(1).getValues().get(0));
        assertEquals("Jane", table.getColumns().get(0).getValues().get(1));
        assertEquals("30", table.getColumns().get(1).getValues().get(1));
    }

    @Test
    public void shouldReadAndMapTheNameOfAnEmptyCsvFile() {
        // GIVEN
        File file = new File("src/test/resources/empty.csv");

        // WHEN
        Table table = reader.read(file);

        // THEN
        assertEquals("empty", table.getName().getValue());
    }

    @Test
    public void shouldReadAndMapTheColumnsOfAnEmptyCsvFile() {
        // GIVEN
        File file = new File("src/test/resources/empty.csv");

        // WHEN
        Table table = reader.read(file);

        // THEN
        assertEquals(0, table.getColumns().size());
    }

    @Test
    public void shouldReadAndMapTheRowsOfAnEmptyCsvFile() {
        // GIVEN
        File file = new File("src/test/resources/empty.csv");

        // WHEN
        Table table = reader.read(file);

        // THEN
        assertEquals(0, table.getRows().size());
    }

    @Test
    public void shouldReadAndMapTheNameOfAnOnlyHeadersCsvFile() {
        // GIVEN
        File file = new File("src/test/resources/only_headers.csv");

        // WHEN
        Table table = reader.read(file);

        // THEN
        assertEquals("only_headers", table.getName().getValue());
    }

    @Test
    public void shouldReadAndMapTheColumnsOfAnOnlyHeadersCsvFile() {
        // GIVEN
        File file = new File("src/test/resources/only_headers.csv");

        // WHEN
        Table table = reader.read(file);

        // THEN
        assertEquals("Name", table.getColumns().get(0).getName().getValue());
        assertEquals("Age", table.getColumns().get(1).getName().getValue());
    }

    @Test
    public void shouldReadAndMapTheRowsOfAnOnlyHeadersCsvFile() {
        // GIVEN
        File file = new File("src/test/resources/only_headers.csv");

        // WHEN
        Table table = reader.read(file);

        // THEN
        assertEquals(0, table.getRows().size());
    }

    @Test
    public void shouldReadAndMapTheNameOfAMalformedCsvFile() {
        // GIVEN
        File file = new File("src/test/resources/malformed.csv");

        // WHEN
        Table table = reader.read(file);

        // THEN
        assertEquals("malformed", table.getName().getValue());
    }

    @Test
    public void shouldReadAndMapTheColumnsOfAMalformedCsvFile() {
        // GIVEN
        File file = new File("src/test/resources/malformed.csv");

        // WHEN
        Table table = reader.read(file);

        // THEN
        assertEquals("Name", table.getColumns().get(0).getName().getValue());
        assertEquals("Age", table.getColumns().get(1).getName().getValue());
    }

    @Test
    public void shouldReadAndMapTheRowsOfAMalformedCsvFile() {
        // GIVEN
        File file = new File("src/test/resources/malformed.csv");

        // WHEN
        Table table = reader.read(file);

        // THEN
        assertEquals("John", table.getColumns().get(0).getValues().get(0));
        assertEquals("25", table.getColumns().get(1).getValues().get(0));
        assertEquals("Jane", table.getColumns().get(0).getValues().get(1));
        assertEquals("", table.getColumns().get(1).getValues().get(1));
    }

}
