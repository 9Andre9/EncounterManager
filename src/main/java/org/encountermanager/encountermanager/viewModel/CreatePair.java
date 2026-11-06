package org.encountermanager.encountermanager.viewModel;

import javafx.beans.property.*;
import org.encountermanager.encountermanager.helper.PokemonData;
import org.encountermanager.encountermanager.persistence.PairStore;

public class CreatePair {
    private final StringProperty ownMonName = new SimpleStringProperty("");
    private final StringProperty partnerMonName = new SimpleStringProperty("");
    private final StringProperty route = new SimpleStringProperty("");

    private final PairStore pairStore = PairStore.getInstance();

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

    public boolean isValidMon(String mon) {
        return PokemonData.contains(mon);
    }

    public boolean isMonAssigned(String mon) {
        var evoLine = PokemonData.getEvolutionLine(mon);

        for (var evo : evoLine) {
            if (pairStore.isMonPresent(evo)) {
                return true;
            }
        }

        return false;
    }

    public boolean isRouteAssigned(String route) {
        return pairStore.isRoutePresent(route);
    }

    public void reset() {
        this.setOwnMonName("");
        this.setPartnerMonName("");
        this.setRoute("");
    }
}
