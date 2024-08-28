package infrastructure.adapters.outbound.common;

import domain.ports.outbound.FileReaderPort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class GenericFileReaderAdapter implements FileReaderPort {

    @Override
    public InputStream read(String filePath) {
        try {
            return new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
