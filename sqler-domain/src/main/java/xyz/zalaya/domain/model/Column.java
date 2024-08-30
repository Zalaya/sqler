package xyz.zalaya.domain.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Column {

    private final String name;
    private String type;
    private final List<Entry> entries;

    public Column(String name) {
        this.name = name;
        this.type = null;
        this.entries = new ArrayList<>();
    }

    public Column(List<Entry> entries) {
        this.name = "";
        this.type = getColumnTypeFromEntries(entries);
        this.entries = entries;
    }

    public void addEntry(Entry entry) {
        entries.add(entry);
        type = getColumnTypeFromEntries(entries);
    }

    public static String getColumnTypeFromEntries(List<Entry> entries) {
        String predominantType = entries.get(0).getType();

        for (int i = 1; i < entries.size() - 1; i++) {
            predominantType = getPredominantEntry(entries.get(i), entries.get(i + 1));
        }

        return predominantType;
    }

    private static String getPredominantEntry(Entry entry1, Entry entry2) {
        if (entry1.getType().startsWith("VARCHAR") && entry2.getType().startsWith("VARCHAR")) return "VARCHAR(" + Math.max(entry1.getValue().length(), entry2.getValue().length()) + ")";
        if (entry1.getType().equals(entry2.getType())) return entry1.getType();
        if (entry1.getType().equals("TEXT") || entry2.getType().equals("TEXT")) return "TEXT";
        if (entry1.getType().startsWith("DECIMAL") && entry2.getType().startsWith("DECIMAL")) return "DECIMAL(" + Math.max(extractPrecision(entry1.getType()), extractPrecision(entry2.getType())) + "," + Math.max(extractScale(entry1.getType()), extractScale(entry2.getType())) + ")";

        return "VARCHAR(" + Math.max(entry1.getValue().length(), entry2.getValue().length()) + ")";
    }

    private static int extractPrecision(String decimalType) {
        return Integer.parseInt(decimalType.replaceAll("DECIMAL\\((\\d+),(\\d+)\\)", "$1"));
    }

    private static int extractScale(String decimalType) {
        return Integer.parseInt(decimalType.replaceAll("DECIMAL\\((\\d+),(\\d+)\\)", "$2"));
    }

}
