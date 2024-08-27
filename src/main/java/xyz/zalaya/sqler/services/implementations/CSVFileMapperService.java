package xyz.zalaya.sqler.services.implementations;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import xyz.zalaya.sqler.models.Column;
import xyz.zalaya.sqler.models.Record;
import xyz.zalaya.sqler.models.Row;
import xyz.zalaya.sqler.models.Table;
import xyz.zalaya.sqler.services.FileMapperService;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVFileMapperService implements FileMapperService {

    @Override
    public Table map(String fileName, String fileExtension, InputStream stream) {
        List<String[]> data = readAll(stream);
        List<Column> columns = mapColumns(data);
        List<Row> rows = mapRows(columns, data);

        return new Table(fileName, columns, rows);
    }

    private List<Column> mapColumns(List<String[]> data) {
        List<Column> columns = new ArrayList<>();

        for (String header : data.get(0)) {
            columns.add(new Column(header));
        }

        return columns;
    }

    private List<Row> mapRows(List<Column> columns, List<String[]> data) {
        List<Row> rows = new ArrayList<>();

        for (String[] rowData : data) {
            rows.add(mapRow(columns, rowData));
        }

        return rows;
    }

    private Row mapRow(List<Column> columns, String[] data) {
        List<Record> records = new ArrayList<>();

        for (int i = 0; i < columns.size(); i++) {
            records.add(new Record(columns.get(i), data[i]));
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
