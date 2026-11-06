package org.encountermanager.encountermanager.view;

import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import org.encountermanager.encountermanager.viewModel.TablePair;

public class PairTable extends TableView<TablePair> {

    private TablePair tablePair = new TablePair();

    private FilteredList<TablePair> filteredPairs = tablePair.getFilteredPairs();

    public PairTable() {
        createView();
    }

    public void createView() {
        this.setItems(filteredPairs);

        TableColumn<TablePair, String> ownMonCol = new TableColumn<>("Your Mon");
        ownMonCol.setCellValueFactory(cellData -> cellData.getValue().ownMonNameProperty());

        TableColumn<TablePair, String> partnerMonCol = new TableColumn<>("Partner Mon");
        partnerMonCol.setCellValueFactory(cellData -> cellData.getValue().partnerMonNameProperty());

        TableColumn<TablePair, String> routeCol = new TableColumn<>("Route");
        routeCol.setCellValueFactory(cellData -> cellData.getValue().routeProperty());

        var deceasedCol = setupDeceasedCol();

        this.getColumns().setAll(ownMonCol, partnerMonCol, routeCol, deceasedCol);

        this.setEditable(true);
    }

    private TableColumn<TablePair, Boolean> setupDeceasedCol() {
        TableColumn<TablePair, Boolean> deceasedCol = new TableColumn<>("Deceased");
        deceasedCol.setCellValueFactory(
                cellData -> cellData.getValue().deceasedProperty()
        );
        deceasedCol.setCellFactory(p -> new CheckBoxTableCell<>() {
            @Override
            public void updateItem(Boolean item, boolean empty) {
                super.updateItem(item, empty);

                if (!(empty || item == null)) {
                    if (item) {
                        setStyle("-fx-background-color: red;");
                    } else {
                        setStyle("-fx-background-color: green;");
                    }
                } else {
                    setStyle("");
                }
            }
        });

        deceasedCol.setEditable(true);

        return deceasedCol;
    }

    public void clear(ActionEvent event) {
        tablePair.clearEncounter();
    }

    public FilteredList<TablePair> getFilteredState() {
        return filteredPairs;
    }
}
