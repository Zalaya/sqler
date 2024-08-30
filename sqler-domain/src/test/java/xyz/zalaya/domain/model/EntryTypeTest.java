package xyz.zalaya.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntryTypeTest {

    @Test
    public void shouldReturnBooleanForLowerCaseTrue() {
        Entry entry = new Entry("true");

        assertEquals("BOOLEAN", entry.getType());
    }

    @Test
    public void shouldReturnBooleanForLowerCaseFalse() {
        Entry entry = new Entry("false");

        assertEquals("BOOLEAN", entry.getType());
    }

    @Test
    public void shouldReturnBooleanForCapitalizedTrue() {
        Entry entry = new Entry("True");

        assertEquals("BOOLEAN", entry.getType());
    }

    @Test
    public void shouldReturnBooleanForCapitalizedFalse() {
        Entry entry = new Entry("False");

        assertEquals("BOOLEAN", entry.getType());
    }

    @Test
    public void shouldReturnBooleanForUpperCaseTrue() {
        Entry entry = new Entry("TRUE");

        assertEquals("BOOLEAN", entry.getType());
    }

    @Test
    public void shouldReturnBooleanForUpperCaseFalse() {
        Entry entry = new Entry("FALSE");

        assertEquals("BOOLEAN", entry.getType());
    }

    @Test
    public void shouldReturnIntegerForShortIntegerValue() {
        Entry entry = new Entry("123");

        assertEquals("INTEGER", entry.getType());
    }

    @Test
    public void shouldReturnIntegerForLongIntegerValue() {
        Entry entry = new Entry("123456789");

        assertEquals("INTEGER", entry.getType());
    }

    @Test
    public void shouldReturnIntegerForVeryLongIntegerValue() {
        Entry entry = new Entry("1234567890123456789");

        assertEquals("INTEGER", entry.getType());
    }

    @Test
    public void shouldReturnIntegerForShortNegativeIntegerValue() {
        Entry entry = new Entry("-123");

        assertEquals("INTEGER", entry.getType());
    }

    @Test
    public void shouldReturnIntegerForLongNegativeIntegerValue() {
        Entry entry = new Entry("-123456789");

        assertEquals("INTEGER", entry.getType());
    }

    @Test
    public void shouldReturnIntegerForVeryLongNegativeIntegerValue() {
        Entry entry = new Entry("-1234567890123456789");

        assertEquals("INTEGER", entry.getType());
    }

    @Test
    public void shouldReturnDecimalForShortDecimalValue() {
        Entry entry = new Entry("123.456");

        assertEquals("DECIMAL(6,3)", entry.getType());
    }

    @Test
    public void shouldReturnDecimalForLongDecimalValue() {
        Entry entry = new Entry("123.456789");

        assertEquals("DECIMAL(9,6)", entry.getType());
    }

    @Test
    public void shouldReturnDecimalForVeryLongDecimalValue() {
        Entry entry = new Entry("123.4567890123456789");

        assertEquals("DECIMAL(19,16)", entry.getType());
    }

    @Test
    public void shouldReturnDecimalForShortNegativeDecimalValue() {
        Entry entry = new Entry("-123.456");

        assertEquals("DECIMAL(6,3)", entry.getType());
    }

    @Test
    public void shouldReturnDecimalForLongNegativeDecimalValue() {
        Entry entry = new Entry("-123.456789");

        assertEquals("DECIMAL(9,6)", entry.getType());
    }

    @Test
    public void shouldReturnDecimalForVeryLongNegativeDecimalValue() {
        Entry entry = new Entry("-123.4567890123456789");

        assertEquals("DECIMAL(19,16)", entry.getType());
    }

    @Test
    public void shouldReturnDateForDashSeparatedYearFirstDate() {
        Entry entry = new Entry("2021-01-01");

        assertEquals("DATE", entry.getType());
    }

    @Test
    public void shouldReturnDateForSlashSeparatedYearFirstDate() {
        Entry entry = new Entry("2021/01/01");

        assertEquals("DATE", entry.getType());
    }

    @Test
    public void shouldReturnDateForSlashSeparatedDayFirstDate() {
        Entry entry = new Entry("01/01/2021");

        assertEquals("DATE", entry.getType());
    }

    @Test
    public void shouldReturnDateForDashSeparatedDayFirstDate() {
        Entry entry = new Entry("01-01-2021");

        assertEquals("DATE", entry.getType());
    }

    @Test
    public void shouldReturnVarcharForEmptyString() {
        Entry entry = new Entry("");

        assertEquals("VARCHAR(1)", entry.getType());
    }

    @Test
    public void shouldReturnVarcharFor3CharacterString() {
        Entry entry = new Entry("x".repeat(3));

        assertEquals("VARCHAR(3)", entry.getType());
    }

    @Test
    public void shouldReturnVarcharFor255CharacterString() {
        Entry entry = new Entry("x".repeat(255));

        assertEquals("VARCHAR(255)", entry.getType());
    }

    @Test
    public void shouldReturnTextFor256CharacterString() {
        Entry entry = new Entry("x".repeat(256));

        assertEquals("TEXT", entry.getType());
    }

    @Test
    public void shouldReturnTextFor1000CharacterString() {
        Entry entry = new Entry("x".repeat(1000));

        assertEquals("TEXT", entry.getType());
    }

}
