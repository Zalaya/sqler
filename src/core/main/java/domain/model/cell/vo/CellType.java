package core.main.java.domain.model.cell.vo;

import shared.main.java.domain.annotation.ValueObject;
import shared.main.java.domain.model.StringValueObject;

@ValueObject
public class CellType extends StringValueObject {

    public CellType(String value) {
        super(value);
    }

}
