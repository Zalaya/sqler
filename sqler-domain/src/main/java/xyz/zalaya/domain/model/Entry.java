package xyz.zalaya.domain.model;

import lombok.Getter;

@Getter
public class Entry {

    private final String value;
    private final String type;

    public Entry(String value) {
        this.value = value;
        this.type = getEntryTypeFromValue(value);
    }

    private String getEntryTypeFromValue(String value) {
        if (value.toLowerCase().matches("^(true|false)$")) return "BOOLEAN";
        if (value.matches("^-?\\d+$")) return "INTEGER";
        if (value.matches("^-?\\d+\\.\\d+$")) return "DECIMAL(" + value.replace(".", "").replace("-", "").length() + "," + value.split("\\.")[1].length() + ")";
        if (value.matches("^\\d{4}-\\d{2}-\\d{2}$") || value.matches("^\\d{4}/\\d{2}/\\d{2}$") || value.matches("^\\d{2}/\\d{2}/\\d{4}$") || value.matches("^\\d{2}-\\d{2}-\\d{4}$")) return "DATE";
        if (value.matches("^.{256,}$")) return "TEXT";

        return "VARCHAR(" + Math.max(value.length(), 1) + ")";
    }

}
