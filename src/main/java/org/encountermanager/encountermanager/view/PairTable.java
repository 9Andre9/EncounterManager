package org.encountermanager.encountermanager.view;

import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.encountermanager.encountermanager.view.util.ComboBoxWithStyledLabel;
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

    private TableColumn<TablePair, String> setupDeceasedCol() {
        TableColumn<TablePair, String> killedByCol = new TableColumn<>("Pair Killed By");
        killedByCol.setCellValueFactory(
                cellData -> cellData.getValue().killedByProperty()
        );


        killedByCol.setCellFactory(p -> new ComboBoxWithStyledLabel<>("Alive", "You", "Partner"));

        killedByCol.setEditable(true);

        return killedByCol;
    }

    public void clear(ActionEvent event) {
        tablePair.clearEncounter();
    }

    public FilteredList<TablePair> getFilteredState() {
        return filteredPairs;
    }
}
