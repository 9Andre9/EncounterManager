package org.encountermanager.encountermanager.POJOs;

public class Pair {
    private String ownMon;
    private String partnerMon;
    private String route;
    private String killedBy;

    public Pair(String ownMon, String partnerMon, String route, String killedBy) {
        this.route = route;
        this.ownMon = ownMon;
        this.partnerMon = partnerMon;
        this.killedBy = killedBy;
    }

    public String getOwnMon() {
        return ownMon;
    }

    public String getPartnerMon() {
        return partnerMon;
    }

    public String getKilledBy() {
        return killedBy;
    }

    public String getRoute() {
        return route;
    }

    public void setKilledBy(String killedBy) {
        this.killedBy = killedBy;
    }
}
