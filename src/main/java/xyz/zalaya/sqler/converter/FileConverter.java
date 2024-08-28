package xyz.zalaya.sqler.converter;

import xyz.zalaya.sqler.models.Table;

public interface FileConverter {

    /**
     * Converts a table to a SQL script.
     * @param table The table to convert.
     * @return The SQL script.
     */
    String convert(Table table);

}
