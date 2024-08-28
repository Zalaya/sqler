package domain.ports.outbound;

import domain.models.Table;

import java.io.InputStream;

public interface FileMapperPort {

    /**
     * Maps the content of a file to a Table object.
     * @param fileName The name of the file to map.
     * @param stream The InputStream with the content of the file.
     * @return A Table object with the content of the file.
     */
    Table map(String fileName, InputStream stream);

}
