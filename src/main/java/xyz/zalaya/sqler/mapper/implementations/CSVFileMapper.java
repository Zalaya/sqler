package xyz.zalaya.sqler.mapper.implementations;

import xyz.zalaya.sqler.mapper.FileMapper;
import xyz.zalaya.sqler.models.Column;
import xyz.zalaya.sqler.models.Entry;
import xyz.zalaya.sqler.models.Row;
import xyz.zalaya.sqler.models.Table;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CSVFileMapper implements FileMapper {

    @Override
    public Table map(File file) {
        List<String[]> data = CSVFileReader.read(file);
        List<Column> columns = mapColumns(data);
        List<Row> rows = mapRows(columns, data);

        return new Table(file.getName().split("\\.")[0], columns, rows);
    }

    private List<Column> mapColumns(List<String[]> data) {
        List<Column> columns = new ArrayList<>();

        for (String header : data.get(0)) {
            columns.add(new Column(header.trim()));
        }

        return columns;
    }

    private List<Row> mapRows(List<Column> columns, List<String[]> data) {
        List<Row> rows = new ArrayList<>();

        for (int i =  1; i < data.size(); i++) {
            rows.add(mapRow(columns, data.get(i)));
        }

        return rows;
    }

    private Row mapRow(List<Column> columns, String[] data) {
        List<Entry> entries = new ArrayList<>();

        for (int i = 0; i < columns.size(); i++) {
            String value = data.length > i ? data[i] : "";
            Entry entry = new Entry(columns.get(i), value.trim());

            entries.add(entry);
            columns.get(i).addEntry(entry);
        }

        return new Row(entries);
    }

}
