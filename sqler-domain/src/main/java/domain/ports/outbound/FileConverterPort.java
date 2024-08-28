package domain.ports.outbound;

import domain.models.Table;

public interface FileConverterPort {

    /**
     * Converts a Table object to a SQL script.
     * @param table The Table object to convert.
     * @return A String with the SQL script.
     */
    String convert(Table table);

}
