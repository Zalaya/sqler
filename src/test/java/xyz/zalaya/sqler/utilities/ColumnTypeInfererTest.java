package xyz.zalaya.sqler.utilities;

import org.junit.jupiter.api.Test;
import xyz.zalaya.sqler.models.Entry;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColumnTypeInfererTest {

    @Test
    public void shouldInferIntegerColumnType() {
        List<Entry> entries = List.of(
            new Entry(null, "1"),
            new Entry(null, "2"),
            new Entry(null, "3")
        );

        String columnType = ColumnTypeInferer.inferColumnType(entries);

        assertEquals("INTEGER", columnType);
    }

    @Test
    public void shouldInferBooleanColumnType() {
        List<Entry> entries = List.of(
            new Entry(null, "true"),
            new Entry(null, "false"),
            new Entry(null, "true")
        );

        String columnType = ColumnTypeInferer.inferColumnType(entries);

        assertEquals("BOOLEAN", columnType);
    }

    @Test
    public void shouldInferDecimalType() {
        List<Entry> entries = List.of(
            new Entry(null, "1.23"),
            new Entry(null, "45.678"),
            new Entry(null, "0.1")
        );

        String columnType = ColumnTypeInferer.inferColumnType(entries);

        assertEquals("DECIMAL(5,3)", columnType);
    }

    @Test
    public void shouldInferVarcharType() {
        List<Entry> entries = List.of(
            new Entry(null, "Hello"),
            new Entry(null, "World"),
            new Entry(null, "!")
        );

        String columnType = ColumnTypeInferer.inferColumnType(entries);

        assertEquals("VARCHAR(5)", columnType);
    }

    @Test
    public void shouldInferVarcharTypeWithMixedValues() {
        List<Entry> entries = List.of(
            new Entry(null, "Hello"),
            new Entry(null, "123"),
            new Entry(null, "true")
        );

        String columnType = ColumnTypeInferer.inferColumnType(entries);

        assertEquals("VARCHAR(5)", columnType);
    }

    @Test
    public void shouldInferVarcharTypeForMixedNumericAndBooleanValues() {
        List<Entry> entries = List.of(
            new Entry(null, "true"),
            new Entry(null, "123"),
            new Entry(null, "false"),
            new Entry(null, "456.78")
        );

        String columnType = ColumnTypeInferer.inferColumnType(entries);

        assertEquals("VARCHAR(6)", columnType);
    }

    @Test
    public void shouldInferVarcharTypeForEmptyValues() {
        List<Entry> entries = List.of(
            new Entry(null, ""),
            new Entry(null, ""),
            new Entry(null, "")
        );

        String columnType = ColumnTypeInferer.inferColumnType(entries);

        assertEquals("VARCHAR(1)", columnType);
    }

    @Test
    public void shouldInferVarcharTypeForEmptyAndNonEmptyValues() {
        List<Entry> entries = List.of(
            new Entry(null, ""),
            new Entry(null, "Hello"),
            new Entry(null, "")
        );

        String columnType = ColumnTypeInferer.inferColumnType(entries);

        assertEquals("VARCHAR(5)", columnType);
    }

    @Test
    public void shouldInferVarcharTypeForMixedVarcharAndBooleanValues() {
        List<Entry> entries = List.of(
            new Entry(null, "Hello"),
            new Entry(null, "true"),
            new Entry(null, "World")
        );

        String columnType = ColumnTypeInferer.inferColumnType(entries);

        assertEquals("VARCHAR(5)", columnType);
    }

    @Test
    public void shouldInferDecimalTypeWithMultipleDecimalValues() {
        List<Entry> entries = List.of(
            new Entry(null, "1.2345"),
            new Entry(null, "45.67890"),
            new Entry(null, "0.1000")
        );

        String columnType = ColumnTypeInferer.inferColumnType(entries);

        assertEquals("DECIMAL(7,5)", columnType);
    }

}