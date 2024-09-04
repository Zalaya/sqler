package infrastructure.adapter.reader;

import domain.model.Table;
import domain.port.outbound.FileReaderPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CsvFileReaderAdapterTest {

    private FileReaderPort reader;

    @BeforeEach
    public void setUp() {
        reader = new CsvFileReaderAdapter();
    }

    @Test
    public void shouldReadAndMapTheFirstColumnOfTheCsvFile() {
        // GIVEN
        String path = "src/test/resources/test.csv";

        // WHEN
        Table table = reader.read(new File(path));

        // THEN
        assertEquals(List.of("John", "Anna", "Peter"), table.getColumns().get(0).getValues());
    }

    @Test
    public void shouldReadAndMapTheSecondColumnOfTheCsvFile() {
        // GIVEN
        String path = "src/test/resources/test.csv";

        // WHEN
        Table table = reader.read(new File(path));

        // THEN
        assertEquals(List.of("25", "30", "45"), table.getColumns().get(1).getValues());
    }

    @Test
    public void shouldReadAndMapTheThirdColumnOfTheCsvFile() {
        // GIVEN
        String path = "src/test/resources/test.csv";

        // WHEN
        Table table = reader.read(new File(path));

        // THEN
        assertEquals(List.of("New York", "London", "Paris"), table.getColumns().get(2).getValues());
    }

    @Test
    public void shouldReadAndMapTheFirstRowOfTheCsvFile() {
        // GIVEN
        String path = "src/test/resources/test.csv";

        // WHEN
        Table table = reader.read(new File(path));

        // THEN
        assertEquals(List.of("John", "25", "New York"), table.getRows().get(0).getValues());
    }

    @Test
    public void shouldReadAndMapTheSecondRowOfTheCsvFile() {
        // GIVEN
        String path = "src/test/resources/test.csv";

        // WHEN
        Table table = reader.read(new File(path));

        // THEN
        assertEquals(List.of("Anna", "30", "London"), table.getRows().get(1).getValues());
    }

    @Test
    public void shouldReadAndMapTheThirdRowOfTheCsvFile() {
        // GIVEN
        String path = "src/test/resources/test.csv";

        // WHEN
        Table table = reader.read(new File(path));

        // THEN
        assertEquals(List.of("Peter", "45", "Paris"), table.getRows().get(2).getValues());
    }

    @Test
    public void shouldHandleMissingValues() {
        // GIVEN
        String path = "src/test/resources/missing_values.csv";

        // WHEN
        Table table = reader.read(new File(path));

        // THEN
        assertEquals(List.of("John", "Anna", "Peter"), table.getColumns().get(0).getValues());
        assertEquals(List.of("25", "", "45"), table.getColumns().get(1).getValues());
        assertEquals(List.of("New York", "London", ""), table.getColumns().get(2).getValues());
    }

    @Test
    public void shouldHandleEmptyLinesInCsvFile() {
        // GIVEN
        String path = "src/test/resources/empty_lines.csv";

        // WHEN
        Table table = reader.read(new File(path));

        // THEN
        assertEquals(3, table.getRows().size());
    }

    @Test
    public void shouldReturnEmptyTableWhenOnlyHeadersPresent() {
        // GIVEN
        String path = "src/test/resources/only_headers.csv";

        // WHEN
        Table table = reader.read(new File(path));

        // THEN
        assertEquals(3, table.getColumns().size());
        assertEquals(0, table.getRows().size());
    }

    @Test
    public void shouldHandleRowsWithDifferentLengths() {
        // GIVEN
        String path = "src/test/resources/different_lengths.csv";

        // WHEN
        Table table = reader.read(new File(path));

        // THEN
        assertEquals(List.of("John", "Anna", "Peter", "Mark"), table.getColumns().get(0).getValues());
        assertEquals(List.of("25", "30", "", "22"), table.getColumns().get(1).getValues());
        assertEquals(List.of("New York", "London", "Paris", ""), table.getColumns().get(2).getValues());
    }

    @Test
    public void shouldHandleInvalidNumericValues() {
        // GIVEN
        String path = "src/test/resources/invalid_numeric_values.csv";

        // WHEN
        Table table = reader.read(new File(path));

        // THEN
        assertEquals(List.of("25", "NaN", "45"), table.getColumns().get(1).getValues());
    }

    @Test
    public void shouldThrowExceptionWhenFileDoesNotExist() {
        // GIVEN
        String path = "src/test/resources/non_existent_file.csv";

        // THEN
        assertThrows(RuntimeException.class, () -> {
            // WHEN
            reader.read(new File(path));
        });
    }

    @Test
    public void shouldHandleCsvFileWithNoRowsAndNoColumns() {
        // GIVEN
        String path = "src/test/resources/empty_file.csv";

        // WHEN
        Table table = reader.read(new File(path));

        // THEN
        assertEquals(0, table.getColumns().size());
        assertEquals(0, table.getRows().size());
    }
}
