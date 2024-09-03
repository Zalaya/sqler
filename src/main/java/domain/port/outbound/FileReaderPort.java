package domain.port.outbound;

import domain.model.Table;

import java.io.File;

public interface FileReaderPort {

    /**
     * The method processes the file, parses its content, and creates a Table with rows and columns
     * based on the file's data. The file should be properly formatted and accessible.
     *
     * @param file The file to be read, which must not be null and should point to an existing file.
     * @return The Table object containing the structured data from the file.
     */
    Table read(File file);

}
