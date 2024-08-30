package xyz.zalaya.domain.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColumnTypeTest {

    @Test
    public void shouldReturnBooleanWhenAllEntriesAreBoolean() {
        List<Entry> entries = List.of(
            new Entry("true"),
            new Entry("false"),
            new Entry("True")
        );

        Column column = new Column(entries);

        assertEquals("BOOLEAN", column.getType());
    }

    @Test
    public void shouldReturnIntegerWhenAllEntriesAreInteger() {
        List<Entry> entries = List.of(
            new Entry("123"),
            new Entry("456"),
            new Entry("789")
        );

        Column column = new Column(entries);

        assertEquals("INTEGER", column.getType());
    }

    @Test
    public void shouldReturnDateWhenAllEntriesAreDate() {
        List<Entry> entries = List.of(
            new Entry("2021-01-01"),
            new Entry("2021/01/01"),
            new Entry("01/01/2021"),
            new Entry("01-01-2021")
        );

        Column column = new Column(entries);

        assertEquals("DATE", column.getType());
    }

    @Test
    public void shouldReturnDecimalWhenAllEntriesAreDecimalWithSamePrecisionAndScale() {
        List<Entry> entries = List.of(
            new Entry("123.456"),
            new Entry("789.012"),
            new Entry("334.141")
        );

        Column column = new Column(entries);

        assertEquals("DECIMAL(6,3)", column.getType());
    }

    @Test
    public void shouldReturnDecimalWhenAllEntriesAreDecimalWithDifferentPrecisionAndScale() {
        List<Entry> entries = List.of(
            new Entry("123.456"),
            new Entry("789.0123"),
            new Entry("3323524.14")
        );

        Column column = new Column(entries);

        assertEquals("DECIMAL(9,4)", column.getType());
    }

    @Test
    public void shouldReturnVarcharWhenAllEntriesAreVarcharWithSameLength() {
        List<Entry> entries = List.of(
            new Entry("abc"),
            new Entry("def"),
            new Entry("ghi")
        );

        Column column = new Column(entries);

        assertEquals("VARCHAR(3)", column.getType());
    }

    @Test
    public void shouldReturnVarcharWhenAllEntriesAreVarcharWithDifferentLength() {
        List<Entry> entries = List.of(
            new Entry("abc"),
            new Entry("defg"),
            new Entry("hijkl")
        );

        Column column = new Column(entries);

        assertEquals("VARCHAR(5)", column.getType());
    }

    @Test
    public void shouldReturnTextWhenAnyEntryIsText() {
        List<Entry> entries = List.of(
            new Entry("abc"),
            new Entry("def"),
            new Entry("ghi"),
            new Entry("x".repeat(256))
        );

        Column column = new Column(entries);

        assertEquals("TEXT", column.getType());
    }

}
