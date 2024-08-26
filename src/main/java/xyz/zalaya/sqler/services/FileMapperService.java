package xyz.zalaya.sqler.services;

import xyz.zalaya.sqler.models.Table;

import java.io.InputStream;

public interface FileMapperService {

    Table map(String fileName, String fileExtension, InputStream stream);

}
