package infrastructure.adapter.reader;

import domain.model.Table;
import domain.port.outbound.FileReaderPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

public class CsvFileReaderAdapterTest {

    private FileReaderPort reader;

    @BeforeEach
    public void setUp() {
        reader = new infrastructure.adapter.reader.CsvFileReaderAdapter();
    }

    @Test
    public void shouldReadCsvFile() {
        String path = "src/test/resources/test.csv";
        Table table = reader.read(new File(path));

        System.out.println(table.getColumns().get(0).getValues());
    }

}
