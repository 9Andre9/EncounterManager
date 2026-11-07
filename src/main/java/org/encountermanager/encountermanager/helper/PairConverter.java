package org.encountermanager.encountermanager.helper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.encountermanager.encountermanager.POJOs.Pair;
import org.encountermanager.encountermanager.viewModel.CreatePair;
import org.encountermanager.encountermanager.viewModel.TablePair;

import java.util.List;

public class PairConverter {

    public static TablePair convertCreateToTableModel(CreatePair createPair) {
        return new TablePair(createPair.getOwnMonName(), createPair.getPartnerMonName(), createPair.getRoute(), "Alive");
    }

    public static ObservableList<TablePair> convertPairsForTable(List<Pair> pairs) {
        var observableList = pairs.stream().map(pair -> new TablePair(pair.getOwnMon(), pair.getPartnerMon(), pair.getRoute(), pair.getKilledBy())).toList();
        return FXCollections.observableArrayList(observableList);
    }

    public static List<Pair> convertPairsForSaving(ObservableList<TablePair> pairs) {
        var observableList = pairs.stream().map(pair -> new Pair(pair.getOwnMonName(), pair.getPartnerMonName(), pair.getRoute(), pair.getKilledBy())).toList();
        return FXCollections.observableArrayList(observableList);
    }
}
