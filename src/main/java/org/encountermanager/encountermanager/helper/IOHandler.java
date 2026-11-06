package org.encountermanager.encountermanager.helper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.encountermanager.encountermanager.POJOs.Pair;
import org.encountermanager.encountermanager.POJOs.PairAdapter;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class IOHandler {

    private Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(Pair.class, new PairAdapter()).create();

    public void writeToFile(File file, List<Pair> pairs) {
        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(pairs, writer);
        } catch (IOException e) {
            System.out.println("Could not write");
        }
    }

    public List<Pair> readFromFile(File file) {
        try (FileReader reader = new FileReader(file)) {
            Type type = new TypeToken<ArrayList<Pair>>() {}.getType();

            return gson.fromJson(reader, type);
        } catch (IOException e) {
            System.out.println("Could not read");
        }

        return new ArrayList<>();
    }
}
