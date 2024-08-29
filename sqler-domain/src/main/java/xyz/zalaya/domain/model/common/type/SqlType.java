package xyz.zalaya.domain.model.common.type;

import lombok.Getter;
import xyz.zalaya.domain.model.common.type.pattern.PatternTypePair;
import xyz.zalaya.domain.model.entry.Entry;
import xyz.zalaya.domain.model.entry.EntryValue;

import java.util.List;
import java.util.regex.Pattern;

@Getter
public class SqlType {

    private static final List<PatternTypePair> PATTERNS = List.of(
        new PatternTypePair(Pattern.compile("^(true|false)$", Pattern.CASE_INSENSITIVE), new SqlType("BOOLEAN")),
        new PatternTypePair(Pattern.compile("^-?\\d+$"), new SqlType("INTEGER")),
        new PatternTypePair(Pattern.compile("^-?\\d+\\.\\d+$"), new SqlType("DECIMAL")),
        new PatternTypePair(Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$"), new SqlType("DATE")),
        new PatternTypePair(Pattern.compile("^\\d{4}/\\d{2}/\\d{2}$"), new SqlType("DATE")),
        new PatternTypePair(Pattern.compile("^\\d{8}$"), new SqlType("DATE")),
        new PatternTypePair(Pattern.compile("^\\d{2}/\\d{2}/\\d{4}$"), new SqlType("DATE")),
        new PatternTypePair(Pattern.compile("^\\d{2}-\\d{2}-\\d{4}$"), new SqlType("DATE"))
    );

    private final String type;

    private SqlType(String type) {
        this.type = type;
    }

    public static SqlType fromEntryValue(EntryValue value) {
        for (PatternTypePair pair : PATTERNS) {
            if (pair.getPattern().matcher(value.getValue()).matches()) {
                return determineType(pair.getType(), value.getValue());
            }
        }

        return new SqlType("VARCHAR(1)");
    }

    private static SqlType determineType(SqlType type, String value) {
        return switch (type.getType()) {
            case "VARCHAR" -> new SqlType("VARCHAR(" + Math.max(value.length(), 1) + ")");
            case "DECIMAL" -> new SqlType("DECIMAL(" + (value.replace(".", "").length()) + "," + (value.contains(".") ? value.length() - value.indexOf('.') - 1 : 0) + ")");
            default -> type;
        };
    }

}
