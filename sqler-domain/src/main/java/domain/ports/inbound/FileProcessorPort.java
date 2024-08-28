package domain.ports.inbound;

import java.io.File;

public interface FileProcessorPort {

    /**
     * Processes the input file, maps the content to a Table object and converts it into a SQL script.
     * @param file The file to process.
     * @return The SQL script generated from the file content.
     */
    String process(File file);

}
