package infrastructure.adapters.outbound.csv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import domain.models.Column;
import domain.models.Entry;
import domain.models.Row;
import domain.models.Table;
import domain.ports.outbound.FileMapperPort;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVFileMapperAdapter implements FileMapperPort {

    @Override
    public Table map(String fileName, InputStream stream) {
        List<String[]> data = readAll(stream);
        List<Column> columns = mapColumns(data);
        List<Row> rows = mapRows(columns, data);

        return new Table(fileName.split("\\.")[0], columns, rows);
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
        List<Entry> entries = new ArrayList<>();

        for (int i = 0; i < columns.size(); i++) {
            String value = data.length > i ? data[i] : "";
            Entry entry = new Entry(columns.get(i), value.trim());

            entries.add(entry);
            columns.get(i).addEntry(entry);
        }

        return new Row(entries);
    }

    private List<String[]> readAll(InputStream stream) {
        try (CSVReader reader = new CSVReader(new InputStreamReader(stream))) {
            return reader.readAll();
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }
    }

}
