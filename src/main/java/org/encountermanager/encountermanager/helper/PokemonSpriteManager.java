package org.encountermanager.encountermanager.helper;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class PokemonSpriteManager {

    private static final String MODULE_BASE = "/org/encountermanager/encountermanager";

    private static final String JSON_PATH =
            MODULE_BASE + "/pokesprite/data/pokemon.json";

    private static final String SPRITE_DIRECTORY =
            MODULE_BASE + "/pokesprite/pokemon-gen7x/regular/";

    private final Map<String, String> spriteMap = new HashMap<>();

    public PokemonSpriteManager() {
        loadPokemon();
    }

    private void loadPokemon() {

        try (InputStream input =
                     getClass().getResourceAsStream(JSON_PATH)) {

            if (input == null) {
                throw new IllegalStateException(
                        "Could not find pokemon.json: " + JSON_PATH
                );
            }

            InputStreamReader reader =
                    new InputStreamReader(input, StandardCharsets.UTF_8);

            JsonObject pokemonData =
                    JsonParser.parseReader(reader).getAsJsonObject();

            for (Map.Entry<String, JsonElement> entry :
                    pokemonData.entrySet()) {

                JsonObject pokemon = entry.getValue().getAsJsonObject();

                // Get English name
                String name = pokemon
                        .getAsJsonObject("name")
                        .get("eng")
                        .getAsString();

                // Get English sprite slug
                String slug = pokemon
                        .getAsJsonObject("slug")
                        .get("eng")
                        .getAsString();

                // Check whether a default Gen 7 sprite exists
                if (!hasDefaultGen7Sprite(pokemon)) {
                    continue;
                }

                // Build the sprite resource path
                String spritePath = SPRITE_DIRECTORY + slug + ".png";

                // Store name -> sprite path
                spriteMap.put(
                        normalize(name),
                        spritePath
                );
            }

            System.out.println(
                    "Loaded " + spriteMap.size() + " Pokémon sprites."
            );

        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to load Pokémon sprites.", e
            );
        }
    }

    private boolean hasDefaultGen7Sprite(JsonObject pokemon) {

        if (!pokemon.has("gen-7")) {
            return false;
        }

        JsonObject gen7 = pokemon.getAsJsonObject("gen-7");

        if (!gen7.has("forms")) {
            return false;
        }

        JsonObject forms = gen7.getAsJsonObject("forms");

        // "$" represents the default Pokémon form
        return forms.has("$");
    }

    private String normalize(String name) {
        return name.trim().toLowerCase(Locale.ROOT);
    }

    public String getSpritePath(String pokemonName) {

        if (pokemonName == null) {
            return null;
        }

        String path = spriteMap.get(normalize(pokemonName));

        if (path == null) {
            return null;
        }

        // Check whether the actual image exists
        if (getClass().getResource(path) == null) {
            return null;
        }

        return path;
    }

    public int getLoadedPokemonCount() {
        return spriteMap.size();
    }
}

