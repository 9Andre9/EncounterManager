package org.encountermanager.encountermanager.POJOs;

public class Pair {
    private String ownMon;
    private String partnerMon;
    private String route;
    private boolean deceased;

    public Pair(String ownMon, String partnerMon, String route, boolean deceased) {
        this.route = route;
        this.ownMon = ownMon;
        this.partnerMon = partnerMon;
        this.deceased = deceased;
    }

    public String getOwnMon() {
        return ownMon;
    }

    public String getPartnerMon() {
        return partnerMon;
    }

    public boolean isDeceased() {
        return deceased;
    }

    public String getRoute() {
        return route;
    }

    public void setDeceased(boolean deceased) {
        this.deceased = deceased;
    }
}
