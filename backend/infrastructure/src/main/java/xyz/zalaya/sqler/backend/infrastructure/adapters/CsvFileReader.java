package xyz.zalaya.sqler.backend.infrastructure.adapters;

import xyz.zalaya.sqler.backend.domain.models.Table;
import xyz.zalaya.sqler.backend.domain.ports.outbound.FileReader;

import java.io.File;

public class CsvFileReader implements FileReader {

    @Override
    public Table read(File file) {
        return null;
    }

}
