package infrastructure.adapter.reader.factory;

import domain.port.outbound.FileReaderPort;
import infrastructure.adapter.reader.CsvFileReaderAdapter;
import infrastructure.adapter.reader.JsonFileReaderAdapter;

public class FileReaderFactory {

    public static FileReaderPort create(String fileExtension) {
        return switch (fileExtension) {
            case "csv" -> new CsvFileReaderAdapter();
            case "json" -> new JsonFileReaderAdapter();
            default -> throw new IllegalArgumentException("File extension not supported.");
        };
    }

}
