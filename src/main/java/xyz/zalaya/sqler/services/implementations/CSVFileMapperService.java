package xyz.zalaya.sqler.services.implementations;

import xyz.zalaya.sqler.models.Table;
import xyz.zalaya.sqler.services.FileMapperService;

import java.io.InputStream;

public class CSVFileMapperService implements FileMapperService {

    @Override
    public Table map(String fileName, String fileExtension, InputStream stream) {
        return null;
    }

}
