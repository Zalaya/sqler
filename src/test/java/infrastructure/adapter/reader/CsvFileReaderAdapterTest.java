package infrastructure.adapter.reader;

import domain.model.Table;
import domain.port.outbound.FileReaderPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CsvFileReaderAdapterTest {

    private FileReaderPort reader;

    @BeforeEach
    public void setUp() {
        reader = new infrastructure.adapter.reader.CsvFileReaderAdapter();
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

}
