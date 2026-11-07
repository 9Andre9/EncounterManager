package org.encountermanager.encountermanager.POJOs;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class PairAdapter extends TypeAdapter<Pair> {

    private final String OwnMonField = "ownMon";
    private final String PartnerMonField = "partnerMon";
    private final String RouteField = "route";
    private final String KilledByField = "killedBy";

    @Override
    public void write(JsonWriter out, Pair pair) throws IOException {
        out.beginObject();

        out.name(OwnMonField).value(pair.getOwnMon());
        out.name(PartnerMonField).value(pair.getPartnerMon());
        out.name(RouteField).value(pair.getRoute());
        out.name(KilledByField).value(pair.getKilledBy());

        out.endObject();
    }

    @Override
    public Pair read(JsonReader in) throws IOException {
        String ownMon = null;
        String partnerMon = null;
        String route = null;
        String killedBy = null;

        in.beginObject();

        while(in.hasNext()) {
            switch (in.nextName()) {
                case OwnMonField:
                    ownMon = in.nextString();
                    break;
                case PartnerMonField:
                    partnerMon = in.nextString();
                    break;
                case RouteField:
                    route = in.nextString();
                    break;
                case KilledByField:
                    killedBy = in.nextString();
                    break;
                default:
                    in.skipValue();
            }
        }

        in.endObject();

        return new Pair(ownMon, partnerMon, route, killedBy);
    }
}
