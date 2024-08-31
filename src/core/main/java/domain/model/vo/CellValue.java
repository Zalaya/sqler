package core.main.java.domain.model.vo;

import shared.main.java.domain.annotation.ValueObject;
import shared.main.java.domain.model.StringValueObject;

@ValueObject
public class CellValue extends StringValueObject {

    public CellValue(String value) {
        super(value);
    }

}
