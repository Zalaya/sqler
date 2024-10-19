package xyz.zalaya.sqler.backend.domain.ports.outbound;

import xyz.zalaya.sqler.backend.domain.models.Table;

public interface FileReaderPort {

    /**
     * Reads a file and returns a Table object with the data.
     * @param filePath The path to the file.
     * @return A Table object with the data.
     */
    Table read(String filePath);

}
