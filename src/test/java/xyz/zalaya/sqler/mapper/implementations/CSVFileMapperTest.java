package xyz.zalaya.sqler.mapper.implementations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xyz.zalaya.sqler.models.Table;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CSVFileMapperTest {

    private CSVFileMapper mapper;

    @BeforeEach
    public void setUp() {
        mapper = new CSVFileMapper();
    }

    @Test
    public void shouldMapCSV() {
        Table table = mapper.map(new File(getClass().getClassLoader().getResource("shouldMapCSVCorrectly.csv").getPath()));

        assertNotNull(table, "Table should not be null");
        assertEquals("shouldMapCSVCorrectly", table.getName(), "Table name should be 'shouldMapCSVCorrectly'");

        assertEquals(3, table.getColumns().size(), "Table should have 3 columns");
        assertEquals("Name", table.getColumns().get(0).getName(), "First column should be 'Name'");
        assertEquals("Age", table.getColumns().get(1).getName(), "Second column should be 'Age'");
        assertEquals("City", table.getColumns().get(2).getName(), "Third column should be 'City'");

        assertEquals(2, table.getRows().size(), "Table should have 2 rows");
        assertEquals("Alice", table.getRows().get(0).getEntries().get(0).getValue(), "First row, first column should be 'Alice'");
        assertEquals("30", table.getRows().get(0).getEntries().get(1).getValue(), "First row, second column should be '30'");
        assertEquals("New York", table.getRows().get(0).getEntries().get(2).getValue(), "First row, third column should be 'New York'");
        assertEquals("Bob", table.getRows().get(1).getEntries().get(0).getValue(), "Second row, first column should be 'Bob'");
        assertEquals("25", table.getRows().get(1).getEntries().get(1).getValue(), "Second row, second column should be '25'");
        assertEquals("Los Angeles", table.getRows().get(1).getEntries().get(2).getValue(), "Second row, third column should be 'Los Angeles'");
    }

    @Test
    public void shouldMapCSVWithEmptyValues() {
        Table table = mapper.map(new File(getClass().getClassLoader().getResource("shouldMapCSVWithEmptyValuesCorrectly.csv").getPath()));

        assertNotNull(table, "Table should not be null");
        assertEquals("shouldMapCSVWithEmptyValuesCorrectly", table.getName(), "Table name should be 'shouldMapCSVWithEmptyValuesCorrectly'");

        assertEquals(3, table.getColumns().size(), "Table should have 3 columns");
        assertEquals("Name", table.getColumns().get(0).getName(), "First column should be 'Name'");
        assertEquals("Age", table.getColumns().get(1).getName(), "Second column should be 'Age'");
        assertEquals("City", table.getColumns().get(2).getName(), "Third column should be 'City'");

        assertEquals(2, table.getRows().size(), "Table should have 2 rows");
        assertEquals("Alice", table.getRows().get(0).getEntries().get(0).getValue(), "First row, first column should be 'Alice'");
        assertEquals("", table.getRows().get(0).getEntries().get(1).getValue(), "First row, second column should be empty");
        assertEquals("New York", table.getRows().get(0).getEntries().get(2).getValue(), "First row, third column should be 'New York'");
        assertEquals("", table.getRows().get(1).getEntries().get(0).getValue(), "Second row, first column should be empty");
        assertEquals("25", table.getRows().get(1).getEntries().get(1).getValue(), "Second row, second column should be '25'");
        assertEquals("Los Angeles", table.getRows().get(1).getEntries().get(2).getValue(), "Second row, third column should be 'Los Angeles'");
    }

    @Test
    public void shouldMapCSVWithExtraColumns() {
        Table table = mapper.map(new File(getClass().getClassLoader().getResource("shouldMapCSVWithExtraColumnsCorrectly.csv").getPath()));

        assertNotNull(table, "Table should not be null");
        assertEquals("shouldMapCSVWithExtraColumnsCorrectly", table.getName(), "Table name should be 'shouldMapCSVWithExtraColumnsCorrectly'");

        assertEquals(4, table.getColumns().size(), "Table should have 4 columns");
        assertEquals("Name", table.getColumns().get(0).getName(), "First column should be 'Name'");
        assertEquals("Age", table.getColumns().get(1).getName(), "Second column should be 'Age'");
        assertEquals("City", table.getColumns().get(2).getName(), "Third column should be 'City'");
        assertEquals("Country", table.getColumns().get(3).getName(), "Fourth column should be 'Country'");

        assertEquals(2, table.getRows().size(), "Table should have 2 rows");
        assertEquals("Alice", table.getRows().get(0).getEntries().get(0).getValue(), "First row, first column should be 'Alice'");
        assertEquals("30", table.getRows().get(0).getEntries().get(1).getValue(), "First row, second column should be '30'");
        assertEquals("New York", table.getRows().get(0).getEntries().get(2).getValue(), "First row, third column should be 'New York'");
        assertEquals("", table.getRows().get(0).getEntries().get(3).getValue(), "First row, fourth column should be empty");
        assertEquals("Bob", table.getRows().get(1).getEntries().get(0).getValue(), "Second row, first column should be 'Bob'");
        assertEquals("25", table.getRows().get(1).getEntries().get(1).getValue(), "Second row, second column should be '25'");
        assertEquals("Los Angeles", table.getRows().get(1).getEntries().get(2).getValue(), "Second row, third column should be 'Los Angeles'");
        assertEquals("", table.getRows().get(1).getEntries().get(3).getValue(), "Second row, fourth column should be empty");
    }

    @Test
    public void shouldMapCSVWithExtraValues() {
        Table table = mapper.map(new File(getClass().getClassLoader().getResource("shouldMapCSVWithExtraValuesCorrectly.csv").getPath()));

        assertNotNull(table, "Table should not be null");
        assertEquals("shouldMapCSVWithExtraValuesCorrectly", table.getName(), "Table name should be 'shouldMapCSVWithExtraValuesCorrectly'");

        assertEquals(3, table.getColumns().size(), "Table should have 3 columns");
        assertEquals("Name", table.getColumns().get(0).getName(), "First column should be 'Name'");
        assertEquals("Age", table.getColumns().get(1).getName(), "Second column should be 'Age'");
        assertEquals("City", table.getColumns().get(2).getName(), "Third column should be 'City'");

        assertEquals(2, table.getRows().size(), "Table should have 2 rows");
        assertEquals("Alice", table.getRows().get(0).getEntries().get(0).getValue(), "First row, first column should be 'Alice'");
        assertEquals("30", table.getRows().get(0).getEntries().get(1).getValue(), "First row, second column should be '30'");
        assertEquals("New York", table.getRows().get(0).getEntries().get(2).getValue(), "First row, third column should be 'New York'");
        assertEquals("Bob", table.getRows().get(1).getEntries().get(0).getValue(), "Second row, first column should be 'Bob'");
        assertEquals("25", table.getRows().get(1).getEntries().get(1).getValue(), "Second row, second column should be '25'");
        assertEquals("Los Angeles", table.getRows().get(1).getEntries().get(2).getValue(), "Second row, third column should be 'Los Angeles'");
    }

}
