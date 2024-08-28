package infrastructure.factory;

import application.usecases.FileProcessorUseCase;
import domain.ports.inbound.FileProcessorPort;
import infrastructure.adapters.outbound.common.GenericFileConverterAdapter;
import infrastructure.adapters.outbound.common.GenericFileReaderAdapter;
import infrastructure.adapters.outbound.csv.CSVFileMapperAdapter;

public class FileProcessorFactory {

    public FileProcessorPort create(String fileExtension) {
        return switch (fileExtension) {
            case ".csv" -> new FileProcessorUseCase(
                new GenericFileReaderAdapter(),
                new CSVFileMapperAdapter(),
                new GenericFileConverterAdapter()
            );
            default -> throw new IllegalArgumentException("Unsupported file extension: " + fileExtension);
        };
    }

}
