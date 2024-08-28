package domain.ports.outbound;

import java.io.InputStream;

public interface FileReaderPort {

    /**
     * Reads the content of a file and returns it as an InputStream.
     * @param filePath The path to the file to read.
     * @return An InputStream with the content of the file.
     */
    InputStream read(String filePath);

}
