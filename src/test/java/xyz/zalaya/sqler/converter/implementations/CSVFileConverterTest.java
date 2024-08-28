package xyz.zalaya.sqler.converter.implementations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xyz.zalaya.sqler.mapper.implementations.CSVFileMapper;
import xyz.zalaya.sqler.models.Table;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CSVFileConverterTest {

    private CSVFileConverter converter;
    private CSVFileMapper mapper;

    @BeforeEach
    public void setUp() {
        converter = new CSVFileConverter();
        mapper = new CSVFileMapper();
    }

    @Test
    public void shouldConvertCSV() {
        Table table = mapper.map(new File(getClass().getClassLoader().getResource("shouldMapCSVCorrectly.csv").getPath()));
        String sql = converter.convert(table);

        assertEquals("""
        CREATE TABLE IF NOT EXISTS shouldMapCSVCorrectly (
            Name VARCHAR(5),
            Age INTEGER,
            City VARCHAR(11)
        );
        
        INSERT INTO shouldMapCSVCorrectly VALUES ('Alice', '30', 'New York');
        INSERT INTO shouldMapCSVCorrectly VALUES ('Bob', '25', 'Los Angeles');
        """, sql, "SQL should be correct");
    }

    @Test
    public void shouldConvertCSVWithEmptyValues() {
        Table table = mapper.map(new File(getClass().getClassLoader().getResource("shouldMapCSVWithEmptyValuesCorrectly.csv").getPath()));
        String sql = converter.convert(table);

        assertEquals("""
        CREATE TABLE IF NOT EXISTS shouldMapCSVWithEmptyValuesCorrectly (
            Name VARCHAR(5),
            Age VARCHAR(2),
            City VARCHAR(11)
        );
        
        INSERT INTO shouldMapCSVWithEmptyValuesCorrectly VALUES ('Alice', '', 'New York');
        INSERT INTO shouldMapCSVWithEmptyValuesCorrectly VALUES ('', '25', 'Los Angeles');
        """, sql, "SQL should be correct");
    }

}