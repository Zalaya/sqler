package xyz.zalaya.sqler.services.mapper;

import xyz.zalaya.sqler.models.Table;

import java.io.InputStream;

public interface FileMapperService {

    Table map(String fullFileName, InputStream stream);

}
