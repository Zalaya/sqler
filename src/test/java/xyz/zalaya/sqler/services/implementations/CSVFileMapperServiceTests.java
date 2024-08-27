package xyz.zalaya.sqler.services.implementations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xyz.zalaya.sqler.models.Table;
import xyz.zalaya.sqler.services.mapper.implementations.CSVFileMapperService;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CSVFileMapperServiceTests {

    private CSVFileMapperService service;

    @BeforeEach
    public void setUp() {
        service = new CSVFileMapperService();
    }

    @Test
    public void shouldMapCSVCorrectly() {
        InputStream stream = getClass().getClassLoader().getResourceAsStream("shouldMapCSVCorrectly.csv");
        Table table = service.map("shouldMapCSVCorrectly.csv", stream);

        assertNotNull(table, "Table should not be null");
        assertEquals("shouldMapCSVCorrectly", table.getName(), "Table name should be 'shouldMapCSVCorrectly'");

        assertEquals(3, table.getColumns().size(), "Table should have 3 columns");
        assertEquals("Name", table.getColumns().get(0).getName(), "First column should be 'Name'");
        assertEquals("Age", table.getColumns().get(1).getName(), "Second column should be 'Age'");
        assertEquals("City", table.getColumns().get(2).getName(), "Third column should be 'City'");

        assertEquals(2, table.getRows().size(), "Table should have 2 rows");
        assertEquals("Alice", table.getRows().get(0).getRecords().get(0).getValue(), "First row, first column should be 'Alice'");
        assertEquals("30", table.getRows().get(0).getRecords().get(1).getValue(), "First row, second column should be '30'");
        assertEquals("New York", table.getRows().get(0).getRecords().get(2).getValue(), "First row, third column should be 'New York'");
        assertEquals("Bob", table.getRows().get(1).getRecords().get(0).getValue(), "Second row, first column should be 'Bob'");
        assertEquals("25", table.getRows().get(1).getRecords().get(1).getValue(), "Second row, second column should be '25'");
        assertEquals("Los Angeles", table.getRows().get(1).getRecords().get(2).getValue(), "Second row, third column should be 'Los Angeles'");
    }

    @Test
    public void shouldMapCSVWithEmptyValuesCorrectly() {
        InputStream stream = getClass().getClassLoader().getResourceAsStream("shouldMapCSVWithEmptyValuesCorrectly.csv");
        Table table = service.map("shouldMapCSVWithEmptyValuesCorrectly.csv", stream);

        assertNotNull(table, "Table should not be null");
        assertEquals("shouldMapCSVWithEmptyValuesCorrectly", table.getName(), "Table name should be 'shouldMapCSVWithEmptyValuesCorrectly'");

        assertEquals(3, table.getColumns().size(), "Table should have 3 columns");
        assertEquals("Name", table.getColumns().get(0).getName(), "First column should be 'Name'");
        assertEquals("Age", table.getColumns().get(1).getName(), "Second column should be 'Age'");
        assertEquals("City", table.getColumns().get(2).getName(), "Third column should be 'City'");

        assertEquals(2, table.getRows().size(), "Table should have 2 rows");
        assertEquals("Alice", table.getRows().get(0).getRecords().get(0).getValue(), "First row, first column should be 'Alice'");
        assertEquals("", table.getRows().get(0).getRecords().get(1).getValue(), "First row, second column should be empty");
        assertEquals("New York", table.getRows().get(0).getRecords().get(2).getValue(), "First row, third column should be 'New York'");
        assertEquals("", table.getRows().get(1).getRecords().get(0).getValue(), "Second row, first column should be empty");
        assertEquals("25", table.getRows().get(1).getRecords().get(1).getValue(), "Second row, second column should be '25'");
        assertEquals("Los Angeles", table.getRows().get(1).getRecords().get(2).getValue(), "Second row, third column should be 'Los Angeles'");
    }

    @Test
    public void shouldMapCSVWithExtraColumnsCorrectly() {
        InputStream stream = getClass().getClassLoader().getResourceAsStream("shouldMapCSVWithExtraColumnsCorrectly.csv");
        Table table = service.map("shouldMapCSVWithExtraColumnsCorrectly.csv", stream);

        assertNotNull(table, "Table should not be null");
        assertEquals("shouldMapCSVWithExtraColumnsCorrectly", table.getName(), "Table name should be 'shouldMapCSVWithExtraColumnsCorrectly'");

        assertEquals(4, table.getColumns().size(), "Table should have 4 columns");
        assertEquals("Name", table.getColumns().get(0).getName(), "First column should be 'Name'");
        assertEquals("Age", table.getColumns().get(1).getName(), "Second column should be 'Age'");
        assertEquals("City", table.getColumns().get(2).getName(), "Third column should be 'City'");
        assertEquals("Country", table.getColumns().get(3).getName(), "Fourth column should be 'Country'");

        assertEquals(2, table.getRows().size(), "Table should have 2 rows");
        assertEquals("Alice", table.getRows().get(0).getRecords().get(0).getValue(), "First row, first column should be 'Alice'");
        assertEquals("30", table.getRows().get(0).getRecords().get(1).getValue(), "First row, second column should be '30'");
        assertEquals("New York", table.getRows().get(0).getRecords().get(2).getValue(), "First row, third column should be 'New York'");
        assertEquals("", table.getRows().get(0).getRecords().get(3).getValue(), "First row, fourth column should be empty");
        assertEquals("Bob", table.getRows().get(1).getRecords().get(0).getValue(), "Second row, first column should be 'Bob'");
        assertEquals("25", table.getRows().get(1).getRecords().get(1).getValue(), "Second row, second column should be '25'");
        assertEquals("Los Angeles", table.getRows().get(1).getRecords().get(2).getValue(), "Second row, third column should be 'Los Angeles'");
        assertEquals("", table.getRows().get(1).getRecords().get(3).getValue(), "Second row, fourth column should be empty");
    }

    @Test
    public void shouldMapCSVWithExtraValuesCorrectly() {
        InputStream stream = getClass().getClassLoader().getResourceAsStream("shouldMapCSVWithExtraValuesCorrectly.csv");
        Table table = service.map("shouldMapCSVWithExtraValuesCorrectly.csv", stream);

        assertNotNull(table, "Table should not be null");
        assertEquals("shouldMapCSVWithExtraValuesCorrectly", table.getName(), "Table name should be 'shouldMapCSVWithExtraValuesCorrectly'");

        assertEquals(3, table.getColumns().size(), "Table should have 3 columns");
        assertEquals("Name", table.getColumns().get(0).getName(), "First column should be 'Name'");
        assertEquals("Age", table.getColumns().get(1).getName(), "Second column should be 'Age'");
        assertEquals("City", table.getColumns().get(2).getName(), "Third column should be 'City'");

        assertEquals(2, table.getRows().size(), "Table should have 2 rows");
        assertEquals("Alice", table.getRows().get(0).getRecords().get(0).getValue(), "First row, first column should be 'Alice'");
        assertEquals("30", table.getRows().get(0).getRecords().get(1).getValue(), "First row, second column should be '30'");
        assertEquals("New York", table.getRows().get(0).getRecords().get(2).getValue(), "First row, third column should be 'New York'");
        assertEquals("Bob", table.getRows().get(1).getRecords().get(0).getValue(), "Second row, first column should be 'Bob'");
        assertEquals("25", table.getRows().get(1).getRecords().get(1).getValue(), "Second row, second column should be '25'");
        assertEquals("Los Angeles", table.getRows().get(1).getRecords().get(2).getValue(), "Second row, third column should be 'Los Angeles'");
    }

}
