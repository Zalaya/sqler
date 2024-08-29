package xyz.zalaya.domain.model.common;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Type {

    private final String type;

    public Type(String type) {
        this.type = type;
    }

}
