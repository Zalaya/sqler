package infrastructure.adapters.outbound.common;

import domain.models.Column;
import domain.models.Row;
import domain.models.Table;
import domain.ports.outbound.FileConverterPort;
import infrastructure.utilities.ColumnTypeInferer;

import java.util.List;

public class GenericFileConverterAdapter implements FileConverterPort {

    @Override
    public String convert(Table table) {
        StringBuilder builder = new StringBuilder();

        builder.append("CREATE TABLE IF NOT EXISTS ").append(table.getName()).append(" (").append("\n");
        builder.append(convertColumns(table.getColumns()));
        builder.append(");").append("\n").append("\n");

        builder.append(convertRows(table.getRows(), table.getName()));

        return builder.toString();
    }

    private String convertColumns(List<Column> columns) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < columns.size(); i++) {
            builder.append("    ").append(columns.get(i).getName());
            builder.append(" ").append(ColumnTypeInferer.infer(columns.get(i).getEntries()));

            if (i < columns.size() - 1) {
                builder.append(",").append("\n");
            } else {
                builder.append("\n");
            }
        }

        return builder.toString();
    }

    private String convertRows(List<Row> rows, String tableName) {
        StringBuilder builder = new StringBuilder();

        for (Row row : rows) {
            builder.append("INSERT INTO ").append(tableName).append(" VALUES (");
            builder.append(convertRow(row));
            builder.append(");").append("\n");
        }

        return builder.toString();
    }

    private String convertRow(Row row) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < row.getEntries().size(); i++) {
            builder.append("'").append(row.getEntries().get(i).getValue()).append("'");

            if (i < row.getEntries().size() - 1) {
                builder.append(", ");
            }
        }

        return builder.toString();
    }

}
