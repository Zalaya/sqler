package application.usecases;

import domain.ports.inbound.FileSupportCheckPort;

import java.io.File;

public class FileSupportCheckUseCase implements FileSupportCheckPort {

    private static final String[] SUPPORTED_EXTENSIONS = {
        ".csv"
    };

    @Override
    public boolean isSupported(File file) {
        for (String extension : SUPPORTED_EXTENSIONS) {
            if (file.getName().endsWith(extension)) {
                return true;
            }
        }

        return false;
    }

}
