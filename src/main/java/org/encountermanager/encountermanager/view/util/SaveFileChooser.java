package org.encountermanager.encountermanager.view.util;

import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.util.Optional;

public class SaveFileChooser {

    private FileChooser fileChooser = new FileChooser();

    public SaveFileChooser() {
        createView();
    }

    public void createView() {
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("JSON Files (*.json)", "*.json")
        );
    }

    public Optional<File> save(Window ownerWindow) {
        fileChooser.setTitle("Save File");
        fileChooser.setInitialFileName("myfile.txt");

        return Optional.ofNullable(fileChooser.showSaveDialog(ownerWindow));
    }

    public Optional<File> load(Window ownerWindow) {
        fileChooser.setTitle("Load File");

        return Optional.ofNullable(fileChooser.showOpenDialog(ownerWindow));
    }
}
