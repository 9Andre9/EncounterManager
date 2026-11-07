package org.encountermanager.encountermanager.view.util;

import javafx.scene.control.Label;
import javafx.scene.control.cell.ComboBoxTableCell;

import java.util.Objects;

public class ComboBoxWithStyledLabel<S, T> extends ComboBoxTableCell<S, T> {

    private static final String BUTTON_STYLE =
            "-fx-background-color: #e8e8e8;" +
                    "-fx-border-color: #b0b0b0;" +
                    "-fx-border-radius: 4px;" +
                    "-fx-background-radius: 4px;" +
                    "-fx-padding: 3px 8px;" +
                    "-fx-cursor: hand;";

    @SafeVarargs
    public ComboBoxWithStyledLabel(T ...items) {
        super(items);
    }

    @Override
    public void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);

        if (!(empty || item == null)) {
            if (!Objects.equals(item, "Alive")) {
                setStyle("-fx-background-color: red;");
            } else {
                setStyle("-fx-background-color: green;");
            }
        } else {
            setStyle("");
        }

        if (empty) {
            setGraphic(null);
            setText(null);
        } else if (!isEditing()) {
            Label label = new Label(
                    item == null ? "" : item.toString()
            );

            if (!Objects.equals(item, "Alive")) {
                label.setStyle(BUTTON_STYLE + "-fx-background-color: red;");
            } else {
                label.setStyle(BUTTON_STYLE + "-fx-background-color: green;");
            }

            label.setMaxWidth(Double.MAX_VALUE);

            label.setOnMouseEntered(e ->
                    label.setStyle(BUTTON_STYLE +
                            "-fx-background-color: #d0d0d0;")
            );

            label.setOnMouseExited(e ->
                    label.setStyle(BUTTON_STYLE)
            );

            setText(null);
            setGraphic(label);
        }
    }
}