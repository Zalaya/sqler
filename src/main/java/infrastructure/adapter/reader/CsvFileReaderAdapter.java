package infrastructure.adapter.reader;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import domain.model.Column;
import domain.model.Row;
import domain.model.Table;
import domain.port.outbound.FileReaderPort;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CsvFileReaderAdapter implements FileReaderPort {

    @Override
    public Table read(File file) {
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(file)).withCSVParser(new CSVParserBuilder().withSeparator(';').build()).build()) {
            List<String[]> data = reader.readAll();
            return new Table(file.getName(), getColumns(data), getRows(data));
        } catch (IOException | CsvException e) {
            return new Table(file.getName());
        }
    }

    private List<Column> getColumns(List<String[]> data) {
        List<Column> columns = Arrays.stream(data.get(0)).map(header -> new Column(header.trim())).toList();

        for (int i = 1; i < data.size(); i++) {
            for (int j = 0; j < data.get(i).length; j++) {
                columns.get(j).addValue(data.get(i)[j].trim());
            }
        }

        return columns;
    }

    private List<Row> getRows(List<String[]> data) {
        return data.stream().skip(1).map(rowData -> new Row(
            Stream.of(rowData).map(String::trim).toList())
        ).toList();
    }

}
