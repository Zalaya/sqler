package xyz.zalaya.domain.model.common.type.pattern;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import xyz.zalaya.domain.model.common.type.SqlType;

import java.util.regex.Pattern;

@Getter
@EqualsAndHashCode
@ToString
public class PatternTypePair {

    private final Pattern pattern;
    private final SqlType type;

    public PatternTypePair(Pattern pattern, SqlType type) {
        this.pattern = pattern;
        this.type = type;
    }

}
