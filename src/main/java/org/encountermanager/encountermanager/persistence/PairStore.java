package org.encountermanager.encountermanager.persistence;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.encountermanager.encountermanager.viewModel.TablePair;

import java.util.Objects;

public class PairStore {

    private static PairStore pairStore;

    private ObservableList<TablePair> pairs = FXCollections.observableArrayList();

    private PairStore() {}

    public static PairStore getInstance() {
        if (pairStore == null) {
            pairStore = new PairStore();
        }

        return pairStore;
    }

    public void setPairs(ObservableList<TablePair> newPairs) {
        pairs.clear();
        pairs.addAll(newPairs);
    }

    public ObservableList<TablePair> getPairs() {
        return pairs;
    }

    public void appendPair(TablePair pair) {
        pairs.add(pair);
    }

    public void clear() {
        pairs.clear();
    }

    public boolean isRoutePresent(String route) {
        for (TablePair pair : pairs) {
            if (Objects.equals(pair.routeProperty().get(), route)) {
                return true;
            }
        }

        return false;
    }

    public boolean isMonPresent(String mon) {
        for (TablePair pair : pairs) {
            if (pair.ownMonNameProperty().get().equals(mon) || pair.partnerMonNameProperty().get().equals(mon)
            ) {
                return true;
            }
        }

        return false;
    }
}
