package domain.ports.inbound;

import java.io.File;

public interface FileSupportCheckPort {

    /**
     * Checks if the file is supported by the application.
     * @param file The file to be checked.
     * @return True if the file is supported, false otherwise.
     */
    boolean isSupported(File file);

}
