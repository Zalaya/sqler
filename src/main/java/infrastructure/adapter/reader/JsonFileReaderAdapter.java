package infrastructure.adapter.reader;

import domain.model.Table;
import domain.port.outbound.FileReaderPort;

import java.io.File;

public class JsonFileReaderAdapter implements FileReaderPort {

    @Override
    public Table read(File file) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
