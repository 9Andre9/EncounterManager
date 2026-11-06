package org.encountermanager.encountermanager.view;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import org.encountermanager.encountermanager.view.util.HorizontalSpacer;
import org.encountermanager.encountermanager.model.IOManager;
import org.encountermanager.encountermanager.view.util.SaveFileChooser;

public class ManagerToolBar extends ToolBar {

    private Button pairButton = new Button("Pairs");
    private Button addPairButton = new Button("Add Pair");
    private MenuButton fileContextButton = new MenuButton("File");

    private MenuItem openFile = new MenuItem("Open");
    private MenuItem saveFile = new MenuItem("Save");

    private HorizontalSpacer spacer = new HorizontalSpacer();

    private AddPairDialog addPairDialog = new AddPairDialog();
    private SaveFileChooser saveFileChooser = new SaveFileChooser();

    private IOManager ioManager = new IOManager();

    public ManagerToolBar() {
        createView();
    }

    public void createView() {

        addPairButton.setOnAction( this::handleAddPair );
        openFile.setOnAction( this::handleOpenFile );
        saveFile.setOnAction( this::handleSaveFile );

        fileContextButton.getItems().addAll(openFile, saveFile);

        this.getItems().addAll(pairButton, spacer, addPairButton, fileContextButton);
    }

    private void handleAddPair(ActionEvent evt) {
        addPairDialog.open(evt);
    }

    private void handleOpenFile(ActionEvent evt) {
        var file = saveFileChooser.load(this.getScene().getWindow());
        if (file.isEmpty()) { return; }
        ioManager.loadPokemon(file.get());
    }

    private void handleSaveFile(ActionEvent evt) {
        var file = saveFileChooser.save(this.getScene().getWindow());
        if (file.isEmpty()) { return; }
        ioManager.savePokemon(file.get());
    }
}
