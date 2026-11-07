package org.encountermanager.encountermanager.viewModel;

import javafx.beans.property.*;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import org.encountermanager.encountermanager.helper.PairConverter;
import org.encountermanager.encountermanager.persistence.PairStore;

public class TablePair {
    private final StringProperty ownMonName = new SimpleStringProperty("");
    private final StringProperty partnerMonName = new SimpleStringProperty("");
    private final StringProperty route = new SimpleStringProperty();
    private final StringProperty killedBy = new SimpleStringProperty();

    private PairStore pairStore = PairStore.getInstance();

    // Own Mon
    public String getOwnMonName() {
        return ownMonName.get();
    }
    public StringProperty ownMonNameProperty() {
        return ownMonName;
    }
    public void setOwnMonName(String name) {
        this.ownMonName.set(name);
    }

    // Partner Mon
    public String getPartnerMonName() {
        return partnerMonName.get();
    }
    public StringProperty partnerMonNameProperty() {
        return partnerMonName;
    }
    public void setPartnerMonName(String name) {
        this.partnerMonName.set(name);
    }

    // Route
    public String getRoute() {
        return route.get();
    }
    public StringProperty routeProperty() {
        return route;
    }
    public void setRoute(String route) {
        this.route.set(route);
    }

    // KilledBy
    public String getKilledBy() {
        return killedBy.get();
    }
    public StringProperty killedByProperty() {
        return killedBy;
    }
    public void setKilledBy(String killedBy) {
        this.killedBy.set(killedBy);
    }

    public TablePair() {}

    public TablePair(String ownMon, String partnerMon, String route, String killedBy) {
        setOwnMonName(ownMon);
        setPartnerMonName(partnerMon);
        setRoute(route);
        setKilledBy(killedBy);
    }

    public ObservableList<TablePair> getPairsForTable() {
        return pairStore.getPairs();
    }

    public FilteredList<TablePair> getFilteredPairs() {
        return new FilteredList<>(getPairsForTable());
    }

    public void save(CreatePair createPair) {

        var tableModel = PairConverter.convertCreateToTableModel(createPair);

        pairStore.appendPair(tableModel);
    }

    public void clearEncounter() {
        pairStore.clear();
    }
}
