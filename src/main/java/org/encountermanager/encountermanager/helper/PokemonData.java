package org.encountermanager.encountermanager.helper;

import java.util.*;

public class PokemonData {

    private static final String[] POKEMON = {
        "Bulbasaur", "Ivysaur", "Venusaur", "Charmander", "Charmeleon",
        "Charizard", "Squirtle", "Wartortle", "Blastoise", "Caterpie",
        "Metapod", "Butterfree", "Weedle", "Kakuna", "Beedrill",
        "Pidgey", "Pidgeotto", "Pidgeot", "Rattata", "Raticate",
        "Spearow", "Fearow", "Ekans", "Arbok", "Pikachu",
        "Raichu", "Sandshrew", "Sandslash", "Nidoran♀", "Nidorina",
        "Nidoqueen", "Nidoran♂", "Nidorino", "Nidoking", "Clefairy",
        "Clefable", "Vulpix", "Ninetales", "Jigglypuff", "Wigglytuff",
        "Zubat", "Golbat", "Oddish", "Gloom", "Vileplume",
        "Paras", "Parasect", "Venonat", "Venomoth", "Diglett",
        "Dugtrio", "Meowth", "Persian", "Psyduck", "Golduck",
        "Mankey", "Primeape", "Growlithe", "Arcanine", "Poliwag",
        "Poliwhirl", "Poliwrath", "Abra", "Kadabra", "Alakazam",
        "Machop", "Machoke", "Machamp", "Bellsprout", "Weepinbell",
        "Victreebel", "Tentacool", "Tentacruel", "Geodude", "Graveler",
        "Golem", "Ponyta", "Rapidash", "Slowpoke", "Slowbro",
        "Magnemite", "Magneton", "Farfetch’d", "Doduo", "Dodrio",
        "Seel", "Dewgong", "Grimer", "Muk", "Shellder",
        "Cloyster", "Gastly", "Haunter", "Gengar", "Onix",
        "Drowzee", "Hypno", "Krabby", "Kingler", "Voltorb",
        "Electrode", "Exeggcute", "Exeggutor", "Cubone", "Marowak",
        "Hitmonlee", "Hitmonchan", "Lickitung", "Koffing", "Weezing",
        "Rhyhorn", "Rhydon", "Chansey", "Tangela", "Kangaskhan",
        "Horsea", "Seadra", "Goldeen", "Seaking", "Staryu",
        "Starmie", "Mr. Mime", "Scyther", "Jynx", "Electabuzz",
        "Magmar", "Pinsir", "Tauros", "Magikarp", "Gyarados",
        "Lapras", "Ditto", "Eevee", "Vaporeon", "Jolteon",
        "Flareon", "Porygon", "Omanyte", "Omastar", "Kabuto",
        "Kabutops", "Aerodactyl", "Snorlax", "Articuno", "Zapdos",
        "Moltres", "Dratini", "Dragonair", "Dragonite", "Mewtwo",
        "Mew",

        "Chikorita", "Bayleef", "Meganium", "Cyndaquil", "Quilava",
        "Typhlosion", "Totodile", "Croconaw", "Feraligatr", "Sentret",
        "Furret", "Hoothoot", "Noctowl", "Ledyba", "Ledian",
        "Spinarak", "Ariados", "Crobat", "Chinchou", "Lanturn",
        "Pichu", "Cleffa", "Igglybuff", "Togepi", "Togetic",
        "Natu", "Xatu", "Mareep", "Flaaffy", "Ampharos",
        "Bellossom", "Marill", "Azumarill", "Sudowoodo", "Politoed",
        "Hoppip", "Skiploom", "Jumpluff", "Aipom", "Sunkern",
        "Sunflora", "Yanma", "Wooper", "Quagsire", "Espeon",
        "Umbreon", "Murkrow", "Slowking", "Misdreavus", "Unown",
        "Wobbuffet", "Girafarig", "Pineco", "Forretress", "Dunsparce",
        "Gligar", "Steelix", "Snubbull", "Granbull", "Qwilfish",
        "Scizor", "Shuckle", "Heracross", "Sneasel", "Teddiursa",
        "Ursaring", "Slugma", "Magcargo", "Swinub", "Piloswine",
        "Corsola", "Remoraid", "Octillery", "Delibird", "Mantine",
        "Skarmory", "Houndour", "Houndoom", "Kingdra", "Phanpy",
        "Donphan", "Porygon2", "Stantler", "Smeargle", "Tyrogue",
        "Hitmontop", "Smoochum", "Elekid", "Magby", "Miltank",
        "Blissey", "Raikou", "Entei", "Suicune", "Larvitar",
        "Pupitar", "Tyranitar", "Lugia", "Ho-Oh", "Celebi",

        "Treecko", "Grovyle", "Sceptile", "Torchic", "Combusken",
        "Blaziken", "Mudkip", "Marshtomp", "Swampert", "Poochyena",
        "Mightyena", "Zigzagoon", "Linoone", "Wurmple", "Silcoon",
        "Beautifly", "Cascoon", "Dustox", "Lotad", "Lombre",
        "Ludicolo", "Seedot", "Nuzleaf", "Shiftry", "Taillow",
        "Swellow", "Wingull", "Pelipper", "Ralts", "Kirlia",
        "Gardevoir", "Surskit", "Masquerain", "Shroomish", "Breloom",
        "Slakoth", "Vigoroth", "Slaking", "Nincada", "Ninjask",
        "Shedinja", "Whismur", "Loudred", "Exploud", "Makuhita",
        "Hariyama", "Azurill", "Nosepass", "Skitty", "Delcatty",
        "Sableye", "Mawile", "Aron", "Lairon", "Aggron",
        "Meditite", "Medicham", "Electrike", "Manectric", "Plusle",
        "Minun", "Volbeat", "Illumise", "Roselia", "Gulpin",
        "Swalot", "Carvanha", "Sharpedo", "Wailmer", "Wailord",
        "Numel", "Camerupt", "Torkoal", "Spoink", "Grumpig",
        "Spinda", "Trapinch", "Vibrava", "Flygon", "Cacnea",
        "Cacturne", "Swablu", "Altaria", "Zangoose", "Seviper",
        "Lunatone", "Solrock", "Barboach", "Whiscash", "Corphish",
        "Crawdaunt", "Baltoy", "Claydol", "Lileep", "Cradily",
        "Anorith", "Armaldo", "Feebas", "Milotic", "Castform",
        "Kecleon", "Shuppet", "Banette", "Duskull", "Dusclops",
        "Tropius", "Chimecho", "Absol", "Wynaut", "Snorunt",
        "Glalie", "Spheal", "Sealeo", "Walrein", "Clamperl",
        "Huntail", "Gorebyss", "Relicanth", "Luvdisc", "Bagon",
        "Shelgon", "Salamence", "Beldum", "Metang", "Metagross",
        "Regirock", "Regice", "Registeel", "Latias", "Latios",
        "Kyogre", "Groudon", "Rayquaza", "Jirachi", "Deoxys",

        "Turtwig", "Grotle", "Torterra", "Chimchar", "Monferno",
        "Infernape", "Piplup", "Prinplup", "Empoleon", "Starly",
        "Staravia", "Staraptor", "Bidoof", "Bibarel", "Kricketot",
        "Kricketune", "Shinx", "Luxio", "Luxray", "Budew",
        "Roserade", "Cranidos", "Rampardos", "Shieldon", "Bastiodon",
        "Burmy", "Wormadam", "Mothim", "Combee", "Vespiquen",
        "Pachirisu", "Buizel", "Floatzel", "Cherubi", "Cherrim",
        "Shellos", "Gastrodon", "Ambipom", "Drifloon", "Drifblim",
        "Buneary", "Lopunny", "Mismagius", "Honchkrow", "Glameow",
        "Purugly", "Chingling", "Stunky", "Skuntank", "Bronzor",
        "Bronzong", "Bonsly", "Mime Jr.", "Happiny", "Chatot",
        "Spiritomb", "Gible", "Gabite", "Garchomp", "Munchlax",
        "Riolu", "Lucario", "Hippopotas", "Hippowdon", "Skorupi",
        "Drapion", "Croagunk", "Toxicroak", "Carnivine", "Finneon",
        "Lumineon", "Mantyke", "Snover", "Abomasnow", "Weavile",
        "Magnezone", "Lickilicky", "Rhyperior", "Tangrowth", "Electivire",
        "Magmortar", "Togekiss", "Yanmega", "Leafeon", "Glaceon",
        "Gliscor", "Mamoswine", "Porygon-Z", "Gallade", "Probopass",
        "Dusknoir", "Froslass", "Rotom", "Uxie", "Mesprit",
        "Azelf", "Dialga", "Palkia", "Heatran", "Regigigas",
        "Giratina", "Cresselia", "Phione", "Manaphy", "Darkrai",
        "Shaymin", "Arceus",

        "Victini", "Snivy", "Servine", "Serperior", "Tepig",
        "Pignite", "Emboar", "Oshawott", "Dewott", "Samurott",
        "Patrat", "Watchog", "Lillipup", "Herdier", "Stoutland",
        "Purrloin", "Liepard", "Pansage", "Simisage", "Pansear",
        "Simisear", "Panpour", "Simipour", "Munna", "Musharna",
        "Pidove", "Tranquill", "Unfezant", "Blitzle", "Zebstrika",
        "Roggenrola", "Boldore", "Gigalith", "Woobat", "Swoobat",
        "Drilbur", "Excadrill", "Audino", "Timburr", "Gurdurr",
        "Conkeldurr", "Tympole", "Palpitoad", "Seismitoad", "Throh",
        "Sawk", "Sewaddle", "Swadloon", "Leavanny", "Venipede",
        "Whirlipede", "Scolipede", "Cottonee", "Whimsicott", "Petilil",
        "Lilligant", "Basculin", "Sandile", "Krokorok", "Krookodile",
        "Darumaka", "Darmanitan", "Maractus", "Dwebble", "Crustle",
        "Scraggy", "Scrafty", "Sigilyph", "Yamask", "Cofagrigus",
        "Tirtouga", "Carracosta", "Archen", "Archeops", "Trubbish",
        "Garbodor", "Zorua", "Zoroark", "Minccino", "Cinccino",
        "Gothita", "Gothorita", "Gothitelle", "Solosis", "Duosion",
        "Reuniclus", "Ducklett", "Swanna", "Vanillite", "Vanillish",
        "Vanilluxe", "Deerling", "Sawsbuck", "Emolga", "Karrablast",
        "Escavalier", "Foongus", "Amoonguss", "Frillish", "Jellicent",
        "Alomomola", "Joltik", "Galvantula", "Ferroseed", "Ferrothorn",
        "Klink", "Klang", "Klinklang", "Tynamo", "Eelektrik",
        "Eelektross", "Elgyem", "Beheeyem", "Litwick", "Lampent",
        "Chandelure", "Axew", "Fraxure", "Haxorus", "Cubchoo",
        "Beartic", "Cryogonal", "Shelmet", "Accelgor", "Stunfisk",
        "Mienfoo", "Mienshao", "Druddigon", "Golett", "Golurk",
        "Pawniard", "Bisharp", "Bouffalant", "Rufflet", "Braviary",
        "Vullaby", "Mandibuzz", "Heatmor", "Durant", "Deino",
        "Zweilous", "Hydreigon", "Larvesta", "Volcarona", "Cobalion",
        "Terrakion", "Virizion", "Tornadus", "Thundurus", "Reshiram",
        "Zekrom", "Landorus", "Kyurem", "Keldeo", "Meloetta",
        "Genesect",

        "Chespin", "Quilladin", "Chesnaught", "Fennekin", "Braixen",
        "Delphox", "Froakie", "Frogadier", "Greninja", "Bunnelby",
        "Diggersby", "Fletchling", "Fletchinder", "Talonflame", "Scatterbug",
        "Spewpa", "Vivillon", "Litleo", "Pyroar", "Flabébé",
        "Floette", "Florges", "Skiddo", "Gogoat", "Pancham",
        "Pangoro", "Furfrou", "Espurr", "Meowstic", "Honedge",
        "Doublade", "Aegislash", "Spritzee", "Aromatisse", "Swirlix",
        "Slurpuff", "Inkay", "Malamar", "Binacle", "Barbaracle",
        "Skrelp", "Dragalge", "Clauncher", "Clawitzer", "Helioptile",
        "Heliolisk", "Tyrunt", "Tyrantrum", "Amaura", "Aurorus",
        "Sylveon", "Hawlucha", "Dedenne", "Carbink", "Goomy",
        "Sliggoo", "Goodra", "Klefki", "Phantump", "Trevenant",
        "Pumpkaboo", "Gourgeist", "Bergmite", "Avalugg", "Noibat",
        "Noivern", "Xerneas", "Yveltal", "Zygarde", "Diancie",
        "Hoopa", "Volcanion",

        "Rowlet", "Dartrix", "Decidueye", "Litten", "Torracat",
        "Incineroar", "Popplio", "Brionne", "Primarina", "Pikipek",
        "Trumbeak", "Toucannon", "Yungoos", "Gumshoos", "Grubbin",
        "Charjabug", "Vikavolt", "Crabrawler", "Crabominable", "Oricorio",
        "Cutiefly", "Ribombee", "Rockruff", "Lycanroc", "Wishiwashi",
        "Mareanie", "Toxapex", "Mudbray", "Mudsdale", "Dewpider",
        "Araquanid", "Fomantis", "Lurantis", "Morelull", "Shiinotic",
        "Salandit", "Salazzle", "Stufful", "Bewear", "Bounsweet",
        "Steenee", "Tsareena", "Comfey", "Oranguru", "Passimian",
        "Wimpod", "Golisopod", "Sandygast", "Palossand", "Pyukumuku",
        "Type: Null", "Silvally", "Minior", "Komala", "Turtonator",
        "Togedemaru", "Mimikyu", "Bruxish", "Drampa", "Dhelmise",
        "Jangmo-o", "Hakamo-o", "Kommo-o", "Tapu Koko", "Tapu Lele",
        "Tapu Bulu", "Tapu Fini", "Cosmog", "Cosmoem", "Solgaleo",
        "Lunala", "Nihilego", "Buzzwole", "Pheromosa", "Xurkitree",
        "Celesteela", "Kartana", "Guzzlord", "Necrozma", "Magearna",
        "Marshadow", "Poipole", "Naganadel", "Stakataka", "Blacephalon",
        "Zeraora", "Meltan", "Melmetal"
    };

    private static final Set<String> POKEMON_SET =
            Set.of(POKEMON);

    public static String[] getPokemon() {
        return POKEMON;
    }

    public static boolean contains(String pokemon) {
        return POKEMON_SET.contains(pokemon);
    }

    private static final Map<String, List<String>> EVOLUTION_LINES = new HashMap<>();

    private static void addEvolutionLine(String... pokemon) {
        List<String> evolutionLine = Arrays.asList(pokemon);

        for (String name : pokemon) {
            EVOLUTION_LINES.put(name.toLowerCase(), evolutionLine);
        }
    }

    public static List<String> getEvolutionLine(String pokemonName) {
        if (pokemonName == null) {
            return Collections.emptyList();
        }

        return EVOLUTION_LINES.getOrDefault(
                pokemonName.toLowerCase(),
                Collections.singletonList(pokemonName)
        );
    }

    static {
        // ==================== GENERATION 1 ====================
        addEvolutionLine("Bulbasaur", "Ivysaur", "Venusaur");
        addEvolutionLine("Charmander", "Charmeleon", "Charizard");
        addEvolutionLine("Squirtle", "Wartortle", "Blastoise");
        addEvolutionLine("Caterpie", "Metapod", "Butterfree");
        addEvolutionLine("Weedle", "Kakuna", "Beedrill");
        addEvolutionLine("Pidgey", "Pidgeotto", "Pidgeot");
        addEvolutionLine("Rattata", "Raticate");
        addEvolutionLine("Spearow", "Fearow");
        addEvolutionLine("Ekans", "Arbok");
        addEvolutionLine("Pichu", "Pikachu", "Raichu");
        addEvolutionLine("Sandshrew", "Sandslash");
        addEvolutionLine("Nidoran♀", "Nidorina", "Nidoqueen");
        addEvolutionLine("Nidoran♂", "Nidorino", "Nidoking");
        addEvolutionLine("Cleffa", "Clefairy", "Clefable");
        addEvolutionLine("Vulpix", "Ninetales");
        addEvolutionLine("Igglybuff", "Jigglypuff", "Wigglytuff");
        addEvolutionLine("Zubat", "Golbat", "Crobat");
        addEvolutionLine("Oddish", "Gloom", "Vileplume", "Bellossom");
        addEvolutionLine("Paras", "Parasect");
        addEvolutionLine("Venonat", "Venomoth");
        addEvolutionLine("Diglett", "Dugtrio");
        addEvolutionLine("Meowth", "Persian");
        addEvolutionLine("Psyduck", "Golduck");
        addEvolutionLine("Mankey", "Primeape");
        addEvolutionLine("Growlithe", "Arcanine");
        addEvolutionLine("Poliwag", "Poliwhirl", "Poliwrath", "Politoed");
        addEvolutionLine("Abra", "Kadabra", "Alakazam");
        addEvolutionLine("Machop", "Machoke", "Machamp");
        addEvolutionLine("Bellsprout", "Weepinbell", "Victreebel");
        addEvolutionLine("Tentacool", "Tentacruel");
        addEvolutionLine("Geodude", "Graveler", "Golem");
        addEvolutionLine("Ponyta", "Rapidash");
        addEvolutionLine("Slowpoke", "Slowbro", "Slowking");
        addEvolutionLine("Magnemite", "Magneton", "Magnezone");
        addEvolutionLine("Doduo", "Dodrio");
        addEvolutionLine("Seel", "Dewgong");
        addEvolutionLine("Grimer", "Muk");
        addEvolutionLine("Shellder", "Cloyster");
        addEvolutionLine("Gastly", "Haunter", "Gengar");
        addEvolutionLine("Onix", "Steelix");
        addEvolutionLine("Drowzee", "Hypno");
        addEvolutionLine("Krabby", "Kingler");
        addEvolutionLine("Voltorb", "Electrode");
        addEvolutionLine("Exeggcute", "Exeggutor");
        addEvolutionLine("Cubone", "Marowak");
        addEvolutionLine("Tyrogue", "Hitmonlee", "Hitmonchan", "Hitmontop");
        addEvolutionLine("Lickitung", "Lickilicky");
        addEvolutionLine("Koffing", "Weezing");
        addEvolutionLine("Rhyhorn", "Rhydon", "Rhyperior");
        addEvolutionLine("Happiny", "Chansey", "Blissey");
        addEvolutionLine("Tangela", "Tangrowth");
        addEvolutionLine("Horsea", "Seadra", "Kingdra");
        addEvolutionLine("Goldeen", "Seaking");
        addEvolutionLine("Staryu", "Starmie");
        addEvolutionLine("Scyther", "Scizor");
        addEvolutionLine("Smoochum", "Jynx");
        addEvolutionLine("Elekid", "Electabuzz", "Electivire");
        addEvolutionLine("Magby", "Magmar", "Magmortar");
        addEvolutionLine("Magikarp", "Gyarados");
        addEvolutionLine("Eevee", "Vaporeon", "Jolteon", "Flareon",
                "Espeon", "Umbreon", "Leafeon", "Glaceon", "Sylveon");
        addEvolutionLine("Porygon", "Porygon2", "Porygon-Z");
        addEvolutionLine("Omanyte", "Omastar");
        addEvolutionLine("Kabuto", "Kabutops");
        addEvolutionLine("Dratini", "Dragonair", "Dragonite");

        // ==================== GENERATION 2 ====================

        addEvolutionLine("Chikorita", "Bayleef", "Meganium");
        addEvolutionLine("Cyndaquil", "Quilava", "Typhlosion");
        addEvolutionLine("Totodile", "Croconaw", "Feraligatr");
        addEvolutionLine("Sentret", "Furret");
        addEvolutionLine("Hoothoot", "Noctowl");
        addEvolutionLine("Ledyba", "Ledian");
        addEvolutionLine("Spinarak", "Ariados");
        addEvolutionLine("Chinchou", "Lanturn");
        addEvolutionLine("Togepi", "Togetic", "Togekiss");
        addEvolutionLine("Natu", "Xatu");
        addEvolutionLine("Mareep", "Flaaffy", "Ampharos");
        addEvolutionLine("Marill", "Azumarill");
        addEvolutionLine("Azurill", "Marill", "Azumarill");
        addEvolutionLine("Sudowoodo", "Bonsly");
        addEvolutionLine("Hoppip", "Skiploom", "Jumpluff");
        addEvolutionLine("Aipom", "Ambipom");
        addEvolutionLine("Sunkern", "Sunflora");
        addEvolutionLine("Yanma", "Yanmega");
        addEvolutionLine("Wooper", "Quagsire");
        addEvolutionLine("Murkrow", "Honchkrow");
        addEvolutionLine("Misdreavus", "Mismagius");
        addEvolutionLine("Wynaut", "Wobbuffet");
        addEvolutionLine("Girafarig", "Farigiraf");
        addEvolutionLine("Pineco", "Forretress");
        addEvolutionLine("Dunsparce", "Dudunsparce");
        addEvolutionLine("Gligar", "Gliscor");
        addEvolutionLine("Snubbull", "Granbull");
        addEvolutionLine("Qwilfish", "Overqwil");
        addEvolutionLine("Shuckle", "Shuckle");
        addEvolutionLine("Heracross", "Heracross");
        addEvolutionLine("Sneasel", "Weavile");
        addEvolutionLine("Teddiursa", "Ursaring", "Ursaluna");
        addEvolutionLine("Slugma", "Magcargo");
        addEvolutionLine("Swinub", "Piloswine", "Mamoswine");
        addEvolutionLine("Remoraid", "Octillery");
        addEvolutionLine("Houndour", "Houndoom");
        addEvolutionLine("Phanpy", "Donphan");
        addEvolutionLine("Mantyke", "Mantine");
        addEvolutionLine("Larvitar", "Pupitar", "Tyranitar");

        // ==================== GENERATION 3 ====================

        addEvolutionLine("Treecko", "Grovyle", "Sceptile");
        addEvolutionLine("Torchic", "Combusken", "Blaziken");
        addEvolutionLine("Mudkip", "Marshtomp", "Swampert");
        addEvolutionLine("Poochyena", "Mightyena");
        addEvolutionLine("Zigzagoon", "Linoone");
        addEvolutionLine("Wurmple", "Silcoon", "Beautifly",
                "Cascoon", "Dustox");
        addEvolutionLine("Lotad", "Lombre", "Ludicolo");
        addEvolutionLine("Seedot", "Nuzleaf", "Shiftry");
        addEvolutionLine("Taillow", "Swellow");
        addEvolutionLine("Wingull", "Pelipper");
        addEvolutionLine("Ralts", "Kirlia", "Gardevoir", "Gallade");
        addEvolutionLine("Surskit", "Masquerain");
        addEvolutionLine("Shroomish", "Breloom");
        addEvolutionLine("Slakoth", "Vigoroth", "Slaking");
        addEvolutionLine("Nincada", "Ninjask", "Shedinja");
        addEvolutionLine("Whismur", "Loudred", "Exploud");
        addEvolutionLine("Makuhita", "Hariyama");
        addEvolutionLine("Azurill", "Marill", "Azumarill");
        addEvolutionLine("Skitty", "Delcatty");
        addEvolutionLine("Aron", "Lairon", "Aggron");
        addEvolutionLine("Meditite", "Medicham");
        addEvolutionLine("Electrike", "Manectric");
        addEvolutionLine("Budew", "Roselia", "Roserade");
        addEvolutionLine("Roselia", "Roserade");
        addEvolutionLine("Gulpin", "Swalot");
        addEvolutionLine("Carvanha", "Sharpedo");
        addEvolutionLine("Wailmer", "Wailord");
        addEvolutionLine("Numel", "Camerupt");
        addEvolutionLine("Spoink", "Grumpig");
        addEvolutionLine("Trapinch", "Vibrava", "Flygon");
        addEvolutionLine("Cacnea", "Cacturne");
        addEvolutionLine("Swablu", "Altaria");
        addEvolutionLine("Barboach", "Whiscash");
        addEvolutionLine("Corphish", "Crawdaunt");
        addEvolutionLine("Baltoy", "Claydol");
        addEvolutionLine("Lileep", "Cradily");
        addEvolutionLine("Anorith", "Armaldo");
        addEvolutionLine("Feebas", "Milotic");
        addEvolutionLine("Shuppet", "Banette");
        addEvolutionLine("Duskull", "Dusclops", "Dusknoir");
        addEvolutionLine("Chingling", "Chimecho");
        addEvolutionLine("Snorunt", "Glalie", "Froslass");
        addEvolutionLine("Spheal", "Sealeo", "Walrein");
        addEvolutionLine("Clamperl", "Huntail", "Gorebyss");
        addEvolutionLine("Bagon", "Shelgon", "Salamence");
        addEvolutionLine("Beldum", "Metang", "Metagross");

        // ==================== GENERATION 4 ====================

        addEvolutionLine("Turtwig", "Grotle", "Torterra");
        addEvolutionLine("Chimchar", "Monferno", "Infernape");
        addEvolutionLine("Piplup", "Prinplup", "Empoleon");
        addEvolutionLine("Starly", "Staravia", "Staraptor");
        addEvolutionLine("Bidoof", "Bibarel");
        addEvolutionLine("Kricketot", "Kricketune");
        addEvolutionLine("Shinx", "Luxio", "Luxray");
        addEvolutionLine("Cranidos", "Rampardos");
        addEvolutionLine("Shieldon", "Bastiodon");
        addEvolutionLine("Burmy", "Wormadam", "Mothim");
        addEvolutionLine("Combee", "Vespiquen");
        addEvolutionLine("Buizel", "Floatzel");
        addEvolutionLine("Cherubi", "Cherrim");
        addEvolutionLine("Shellos", "Gastrodon");
        addEvolutionLine("Drifloon", "Drifblim");
        addEvolutionLine("Buneary", "Lopunny");
        addEvolutionLine("Glameow", "Purugly");
        addEvolutionLine("Stunky", "Skuntank");
        addEvolutionLine("Bronzor", "Bronzong");
        addEvolutionLine("Mime Jr.", "Mr. Mime");
        addEvolutionLine("Gible", "Gabite", "Garchomp");
        addEvolutionLine("Riolu", "Lucario");
        addEvolutionLine("Hippopotas", "Hippowdon");
        addEvolutionLine("Skorupi", "Drapion");
        addEvolutionLine("Croagunk", "Toxicroak");
        addEvolutionLine("Finneon", "Lumineon");
        addEvolutionLine("Snover", "Abomasnow");
        addEvolutionLine("Togepi", "Togetic", "Togekiss");
        addEvolutionLine("Rotom", "Rotom");
        addEvolutionLine("Phione", "Manaphy");
        addEvolutionLine("Pansage", "Simisage");
        addEvolutionLine("Pansear", "Simisear");
        addEvolutionLine("Panpour", "Simipour");
        addEvolutionLine("Munna", "Musharna");
        addEvolutionLine("Pidove", "Tranquill", "Unfezant");
        addEvolutionLine("Blitzle", "Zebstrika");
        addEvolutionLine("Roggenrola", "Boldore", "Gigalith");
        addEvolutionLine("Woobat", "Swoobat");
        addEvolutionLine("Drilbur", "Excadrill");
        addEvolutionLine("Timburr", "Gurdurr", "Conkeldurr");
        addEvolutionLine("Tympole", "Palpitoad", "Seismitoad");
        addEvolutionLine("Sewaddle", "Swadloon", "Leavanny");
        addEvolutionLine("Venipede", "Whirlipede", "Scolipede");
        addEvolutionLine("Cottonee", "Whimsicott");
        addEvolutionLine("Petilil", "Lilligant");
        addEvolutionLine("Sandile", "Krokorok", "Krookodile");
        addEvolutionLine("Darumaka", "Darmanitan");
        addEvolutionLine("Dwebble", "Crustle");
        addEvolutionLine("Scraggy", "Scrafty");
        addEvolutionLine("Yamask", "Cofagrigus");
        addEvolutionLine("Tirtouga", "Carracosta");
        addEvolutionLine("Archen", "Archeops");
        addEvolutionLine("Trubbish", "Garbodor");
        addEvolutionLine("Zorua", "Zoroark");
        addEvolutionLine("Minccino", "Cinccino");
        addEvolutionLine("Gothita", "Gothorita", "Gothitelle");
        addEvolutionLine("Solosis", "Duosion", "Reuniclus");
        addEvolutionLine("Ducklett", "Swanna");
        addEvolutionLine("Vanillite", "Vanillish", "Vanilluxe");
        addEvolutionLine("Deerling", "Sawsbuck");
        addEvolutionLine("Karrablast", "Escavalier");
        addEvolutionLine("Foongus", "Amoonguss");
        addEvolutionLine("Frillish", "Jellicent");
        addEvolutionLine("Joltik", "Galvantula");
        addEvolutionLine("Ferroseed", "Ferrothorn");
        addEvolutionLine("Klink", "Klang", "Klinklang");
        addEvolutionLine("Tynamo", "Eelektrik", "Eelektross");
        addEvolutionLine("Elgyem", "Beheeyem");
        addEvolutionLine("Litwick", "Lampent", "Chandelure");
        addEvolutionLine("Axew", "Fraxure", "Haxorus");
        addEvolutionLine("Cubchoo", "Beartic");
        addEvolutionLine("Shelmet", "Accelgor");
        addEvolutionLine("Mienfoo", "Mienshao");
        addEvolutionLine("Golett", "Golurk");
        addEvolutionLine("Pawniard", "Bisharp", "Kingambit");
        addEvolutionLine("Rufflet", "Braviary");
        addEvolutionLine("Vullaby", "Mandibuzz");
        addEvolutionLine("Deino", "Zweilous", "Hydreigon");
        addEvolutionLine("Larvesta", "Volcarona");

        // ==================== GENERATION 5 ====================

        addEvolutionLine("Snivy", "Servine", "Serperior");
        addEvolutionLine("Tepig", "Pignite", "Emboar");
        addEvolutionLine("Oshawott", "Dewott", "Samurott");
        addEvolutionLine("Patrat", "Watchog");
        addEvolutionLine("Lillipup", "Herdier", "Stoutland");
        addEvolutionLine("Purrloin", "Liepard");
        addEvolutionLine("Munna", "Musharna");
        addEvolutionLine("Blitzle", "Zebstrika");
        addEvolutionLine("Tympole", "Palpitoad", "Seismitoad");
        addEvolutionLine("Cottonee", "Whimsicott");
        addEvolutionLine("Petilil", "Lilligant");
        addEvolutionLine("Basculin", "Basculegion");
        addEvolutionLine("Sandile", "Krokorok", "Krookodile");
        addEvolutionLine("Darumaka", "Darmanitan");
        addEvolutionLine("Scraggy", "Scrafty");
        addEvolutionLine("Yamask", "Cofagrigus");
        addEvolutionLine("Zorua", "Zoroark");
        addEvolutionLine("Minccino", "Cinccino");
        addEvolutionLine("Gothita", "Gothorita", "Gothitelle");
        addEvolutionLine("Solosis", "Duosion", "Reuniclus");
        addEvolutionLine("Vanillite", "Vanillish", "Vanilluxe");
        addEvolutionLine("Deerling", "Sawsbuck");
        addEvolutionLine("Karrablast", "Escavalier");
        addEvolutionLine("Foongus", "Amoonguss");
        addEvolutionLine("Frillish", "Jellicent");
        addEvolutionLine("Joltik", "Galvantula");
        addEvolutionLine("Ferroseed", "Ferrothorn");
        addEvolutionLine("Klink", "Klang", "Klinklang");
        addEvolutionLine("Tynamo", "Eelektrik", "Eelektross");
        addEvolutionLine("Elgyem", "Beheeyem");
        addEvolutionLine("Litwick", "Lampent", "Chandelure");
        addEvolutionLine("Axew", "Fraxure", "Haxorus");
        addEvolutionLine("Cubchoo", "Beartic");
        addEvolutionLine("Mienfoo", "Mienshao");
        addEvolutionLine("Golett", "Golurk");
        addEvolutionLine("Pawniard", "Bisharp");
        addEvolutionLine("Rufflet", "Braviary");
        addEvolutionLine("Vullaby", "Mandibuzz");
        addEvolutionLine("Deino", "Zweilous", "Hydreigon");
        addEvolutionLine("Larvesta", "Volcarona");

        // ==================== GENERATION 6 ====================

        addEvolutionLine("Chespin", "Quilladin", "Chesnaught");
        addEvolutionLine("Fennekin", "Braixen", "Delphox");
        addEvolutionLine("Froakie", "Frogadier", "Greninja");
        addEvolutionLine("Bunnelby", "Diggersby");
        addEvolutionLine("Fletchling", "Fletchinder", "Talonflame");
        addEvolutionLine("Scatterbug", "Spewpa", "Vivillon");
        addEvolutionLine("Litleo", "Pyroar");
        addEvolutionLine("Flabébé", "Floette", "Florges");
        addEvolutionLine("Skiddo", "Gogoat");
        addEvolutionLine("Pancham", "Pangoro");
        addEvolutionLine("Espurr", "Meowstic");
        addEvolutionLine("Honedge", "Doublade", "Aegislash");
        addEvolutionLine("Spritzee", "Aromatisse");
        addEvolutionLine("Swirlix", "Slurpuff");
        addEvolutionLine("Inkay", "Malamar");
        addEvolutionLine("Binacle", "Barbaracle");
        addEvolutionLine("Skrelp", "Dragalge");
        addEvolutionLine("Clauncher", "Clawitzer");
        addEvolutionLine("Helioptile", "Heliolisk");
        addEvolutionLine("Tyrunt", "Tyrantrum");
        addEvolutionLine("Amaura", "Aurorus");
        addEvolutionLine("Goomy", "Sliggoo", "Goodra");
        addEvolutionLine("Phantump", "Trevenant");
        addEvolutionLine("Pumpkaboo", "Gourgeist");
        addEvolutionLine("Bergmite", "Avalugg");
        addEvolutionLine("Noibat", "Noivern");

        // ==================== GENERATION 7 ====================

        addEvolutionLine("Rowlet", "Dartrix", "Decidueye");
        addEvolutionLine("Litten", "Torracat", "Incineroar");
        addEvolutionLine("Popplio", "Brionne", "Primarina");
        addEvolutionLine("Pikipek", "Trumbeak", "Toucannon");
        addEvolutionLine("Yungoos", "Gumshoos");
        addEvolutionLine("Grubbin", "Charjabug", "Vikavolt");
        addEvolutionLine("Crabrawler", "Crabominable");
        addEvolutionLine("Cutiefly", "Ribombee");
        addEvolutionLine("Rockruff", "Lycanroc");
        addEvolutionLine("Mareanie", "Toxapex");
        addEvolutionLine("Mudbray", "Mudsdale");
        addEvolutionLine("Dewpider", "Araquanid");
        addEvolutionLine("Fomantis", "Lurantis");
        addEvolutionLine("Morelull", "Shiinotic");
        addEvolutionLine("Salandit", "Salazzle");
        addEvolutionLine("Stufful", "Bewear");
        addEvolutionLine("Bounsweet", "Steenee", "Tsareena");
        addEvolutionLine("Wimpod", "Golisopod");
        addEvolutionLine("Sandygast", "Palossand");
        addEvolutionLine("Jangmo-o", "Hakamo-o", "Kommo-o");
        addEvolutionLine("Cosmog", "Cosmoem", "Solgaleo", "Lunala");
        addEvolutionLine("Poipole", "Naganadel");
    }
}
