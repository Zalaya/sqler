package xyz.zalaya.sqler.services.mapper.implementations;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import xyz.zalaya.sqler.models.Column;
import xyz.zalaya.sqler.models.Record;
import xyz.zalaya.sqler.models.Row;
import xyz.zalaya.sqler.models.Table;
import xyz.zalaya.sqler.services.mapper.FileMapperService;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVFileMapperService implements FileMapperService {

    @Override
    public Table map(String fullFileName, InputStream stream) {
        List<String[]> data = readAll(stream);
        List<Column> columns = mapColumns(data);
        List<Row> rows = mapRows(columns, data);

        return new Table(fullFileName.split("\\.")[0], columns, rows);
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

        for (int i = 1; i < data.size(); i++) {
            rows.add(mapRow(columns, data.get(i)));
        }

        return rows;
    }

    private Row mapRow(List<Column> columns, String[] data) {
        List<Record> records = new ArrayList<>();

        for (int i = 0; i < columns.size(); i++) {
            String value = data.length > i ? data[i] : "";
            records.add(new Record(columns.get(i), value.trim()));
        }

        return new Row(records);
    }

    private List<String[]> readAll(InputStream stream) {
        try (CSVReader reader = new CSVReader(new InputStreamReader(stream))) {
            return reader.readAll();
        } catch (IOException | CsvException e) {
            return new ArrayList<>();
        }
    }

}
