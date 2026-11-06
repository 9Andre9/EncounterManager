package org.encountermanager.encountermanager.view.util;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class HorizontalSpacer extends HBox {

    public HorizontalSpacer() {
        createView();
    }

    public void createView() {

        HBox.setHgrow(this, Priority.ALWAYS);
    }
}
