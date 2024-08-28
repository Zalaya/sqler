package xyz.zalaya.sqler.utilities;

import xyz.zalaya.sqler.models.Entry;

import java.util.List;

public class ColumnTypeInferer {

    private static final String BOOLEAN_TYPE = "BOOLEAN";
    private static final String INTEGER_TYPE = "INTEGER";
    private static final String DECIMAL_TYPE = "DECIMAL";
    private static final String VARCHAR_TYPE = "VARCHAR";

    public static String inferColumnType(List<Entry> entries) {
        boolean hasBoolean = entries.stream().anyMatch(entry -> isBoolean(entry.getValue()));
        boolean hasDecimal = entries.stream().anyMatch(entry -> isDecimal(entry.getValue()));
        boolean hasInteger = entries.stream().anyMatch(entry -> isInteger(entry.getValue()));

        if (entries.stream().anyMatch(entry -> !isBoolean(entry.getValue()) && !isDecimal(entry.getValue()) && !isInteger(entry.getValue()))) {
            return VARCHAR_TYPE + "(" + getMaxVarcharLength(entries) + ")";
        }

        return determineColumnType(hasBoolean, hasDecimal, hasInteger, entries);
    }

    private static String determineColumnType(boolean hasBoolean, boolean hasDecimal, boolean hasInteger, List<Entry> entries) {
        if (hasBoolean && !hasDecimal && !hasInteger) return BOOLEAN_TYPE;
        if (!hasBoolean && hasDecimal && !hasInteger) return DECIMAL_TYPE + "(" + getDecimalPrecision(entries) + ")";
        if (!hasBoolean && !hasDecimal && hasInteger) return INTEGER_TYPE;

        return VARCHAR_TYPE + "(" + getMaxVarcharLength(entries) + ")";
    }

    private static boolean isBoolean(String value) {
        return "true".equalsIgnoreCase(value) || "false".equalsIgnoreCase(value);
    }

    private static boolean isDecimal(String value) {
        return !value.isEmpty() && value.matches("-?\\d*\\.\\d+");
    }

    private static boolean isInteger(String value) {
        return !value.isEmpty() && value.matches("-?\\d+");
    }

    private static int getMaxVarcharLength(List<Entry> entries) {
        int maxLength = 1;

        for (Entry record : entries) {
            int length = record.getValue().length();

            if (length > maxLength) {
                maxLength = length;
            }
        }

        return maxLength;
    }

    private static String getDecimalPrecision(List<Entry> entries) {
        int maxIntegerDigits = 0;
        int maxDecimalDigits = 0;

        for (Entry record : entries) {
            String value = record.getValue();

            if (isDecimal(value)) {
                int integerDigits = value.indexOf('.') > 0 ? value.indexOf('.') : value.length();
                int decimalDigits = value.length() - value.indexOf('.') - 1;

                maxIntegerDigits = Math.max(maxIntegerDigits, integerDigits);
                maxDecimalDigits = Math.max(maxDecimalDigits, decimalDigits);
            }
        }

        return (maxIntegerDigits + maxDecimalDigits) + "," + maxDecimalDigits;
    }

}