package xyz.zalaya.sqler.backend.domain.ports.outbound;

import xyz.zalaya.sqler.backend.domain.models.Table;

import java.io.File;

public interface FileReader {

    /**
     * Reads a file and returns a Table object with the data.
     * @param file The file to read.
     * @return A Table object with the data.
     */
    Table read(File file);

}
