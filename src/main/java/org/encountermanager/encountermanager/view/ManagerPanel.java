package org.encountermanager.encountermanager.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ManagerPanel extends BorderPane {

    private ManagerToolBar toolBar = new ManagerToolBar();
    private PairTable pairTable = new PairTable();

    private Button clearEncounter = new Button("Clear Encounter");
    private TextField searchTable = new TextField();
    private Label searchTableLabel = new Label("Search table: ");

    public ManagerPanel() {
        createView();
    }

    public void createView() {

        this.setTop(toolBar);

        clearEncounter.setOnAction( pairTable::clear );

        setupSearchField();
        HBox hbox = new HBox(searchTableLabel, searchTable);
        hbox.setSpacing( 10 );

        VBox vbox = new VBox( hbox, pairTable, clearEncounter );
        vbox.setPadding( new Insets(10) );
        vbox.setSpacing( 10 );

        this.setCenter( vbox );
    }

    private void setupSearchField() {
        searchTable.textProperty().addListener((observable, oldValue, newValue) -> {
            pairTable.getFilteredState().setPredicate(pair -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String filter = newValue.toLowerCase();

                return pair.getOwnMonName().toLowerCase().contains(filter) || pair.getPartnerMonName().toLowerCase().contains(filter) || pair.getRoute().toLowerCase().contains(filter);
            });
        });
    }
}
