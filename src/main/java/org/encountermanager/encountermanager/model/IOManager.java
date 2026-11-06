package org.encountermanager.encountermanager.model;

import org.encountermanager.encountermanager.helper.IOHandler;
import org.encountermanager.encountermanager.helper.PairConverter;
import org.encountermanager.encountermanager.persistence.PairStore;

import java.io.File;

public class IOManager {

    private IOHandler ioHandler = new IOHandler();
    private PairStore pairStore = PairStore.getInstance();

    public void loadPokemon(File file) {
        var pairs = ioHandler.readFromFile(file);

        var convertedPairs = PairConverter.convertPairsForTable(pairs);

        pairStore.setPairs(convertedPairs);
    }

    public void savePokemon(File file) {
        var pairs = pairStore.getPairs();

        var convertedPairs = PairConverter.convertPairsForSaving(pairs);

        ioHandler.writeToFile(file, convertedPairs);
    }
}
