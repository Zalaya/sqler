package xyz.zalaya.sqler.backend.infrastructure.adapters;

import xyz.zalaya.sqler.backend.domain.models.Table;
import xyz.zalaya.sqler.backend.domain.ports.outbound.FileReaderPort;

public class CSVFileReaderAdapter implements FileReaderPort {

    @Override
    public Table read(String filePath) {
        return null;
    }

}
