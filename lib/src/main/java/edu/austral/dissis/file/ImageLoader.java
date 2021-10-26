package edu.austral.dissis.file;

import javafx.scene.image.Image;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;

public class ImageLoader {
    private final FileLoader fileLoader = new FileLoader();

    @NotNull
    public Image loadFromResources(@NotNull String path, double width, double height) throws IOException {
        return loadFromInputStream(fileLoader.loadFromResources(path), width, height);
    }

    @NotNull
    public Image loadFromFileSystem(@NotNull String path, double width, double height) throws IOException {
        return loadFromInputStream(fileLoader.loadFromFileSystem(path), width, height);
    }

    @NotNull
    private Image loadFromInputStream(@NotNull InputStream inputStream, double width, double height) {
        return new Image(inputStream, width, height, true, true);
    }
}
