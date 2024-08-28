package xyz.zalaya.sqler.mapper;

import xyz.zalaya.sqler.models.Table;

import java.io.File;

public interface FileMapper {

    Table map(File file);

    default boolean isSupported(File file) {
        for (String extension : new String[]{ "csv" }) {
            if (file.getName().endsWith("." + extension)) {
                return true;
            }
        }

        return false;
    }

}
