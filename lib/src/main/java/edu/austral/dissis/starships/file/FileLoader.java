package edu.austral.dissis.starships.file;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.net.URL;

public class FileLoader {
    @NotNull
    public InputStream loadFromResources(@NotNull String path) throws IOException {
        final URL resource = FileLoader.class.getClassLoader().getResource(path);
        if (resource == null)
            throw new FileNotFoundException(path);

        return resource.openStream();
    }

    @NotNull
    public InputStream loadFromFileSystem(@NotNull String path) throws IOException {
        final File file = new File(path);
        return new FileInputStream(file);
    }
}
