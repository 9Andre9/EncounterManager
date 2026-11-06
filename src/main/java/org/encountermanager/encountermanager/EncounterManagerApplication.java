package org.encountermanager.encountermanager;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.encountermanager.encountermanager.view.ManagerPanel;

import java.io.IOException;

public class EncounterManagerApplication extends Application {

    private final ManagerPanel managerPanel = new ManagerPanel();

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(managerPanel, 1000, 500);
        stage.setTitle("Encounter Manager");
        stage.setScene(scene);
        stage.show();
    }
}
