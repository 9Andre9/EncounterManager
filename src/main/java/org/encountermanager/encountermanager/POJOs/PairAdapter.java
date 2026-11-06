package org.encountermanager.encountermanager.POJOs;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class PairAdapter extends TypeAdapter<Pair> {

    @Override
    public void write(JsonWriter out, Pair pair) throws IOException {
        out.beginObject();

        out.name("ownMon").value(pair.getOwnMon());
        out.name("partnerMon").value(pair.getPartnerMon());
        out.name("route").value(pair.getRoute());
        out.name("deceased").value(pair.isDeceased());

        out.endObject();
    }

    @Override
    public Pair read(JsonReader in) throws IOException {
        String ownMon = null;
        String partnerMon = null;
        String route = null;
        boolean deceased = false;

        in.beginObject();

        while(in.hasNext()) {
            switch (in.nextName()) {
                case "ownMon":
                    ownMon = in.nextString();
                    break;
                case "partnerMon":
                    partnerMon = in.nextString();
                    break;
                case "route":
                    route = in.nextString();
                    break;
                case "deceased":
                    deceased = in.nextBoolean();
                    break;
                default:
                    in.skipValue();
            }
        }

        in.endObject();

        return new Pair(ownMon, partnerMon, route, deceased);
    }
}
