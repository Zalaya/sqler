package application.usecases;

import domain.models.Table;
import domain.ports.inbound.FileProcessorPort;
import domain.ports.outbound.FileConverterPort;
import domain.ports.outbound.FileMapperPort;
import domain.ports.outbound.FileReaderPort;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class FileProcessorUseCase implements FileProcessorPort {

    private final FileReaderPort reader;
    private final FileMapperPort mapper;
    private final FileConverterPort converter;

    public FileProcessorUseCase(FileReaderPort reader, FileMapperPort mapper, FileConverterPort converter) {
        this.reader = reader;
        this.mapper = mapper;
        this.converter = converter;
    }

    @Override
    public String process(File file) {
        try (InputStream stream = reader.read(file.getAbsolutePath())) {
            return converter.convert(mapper.map(file.getName(), stream));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file: " + file.getAbsolutePath(), e);
        }
    }

}
