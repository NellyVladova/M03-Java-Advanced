package JavaAdvanced.E06DefiningClasses.P06PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Trainer> trainersInfo = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Tournament")) {
            String[] data = input.split("\\s+");

            String trainerName = data[0];
            String pokemonName = data[1];
            String element = data[2];
            int health = Integer.parseInt(data[3]);

            Pokemon pokemon = new Pokemon(pokemonName, element, health);

            trainersInfo.putIfAbsent(trainerName, new Trainer());
            trainersInfo.get(trainerName).addPokemon(pokemon);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("End")) {
            for (Map.Entry<String, Trainer> trainerEntry : trainersInfo.entrySet()) {
                if (trainerEntry.getValue().pokeCollectionSize() > 0) {
                    boolean havePokemon = false;
                    for (Pokemon currPokemon : trainerEntry.getValue().getPokemonList()) {
                        if (currPokemon.getElement().equals(input)) {
                            havePokemon = true;
                            trainerEntry.getValue().setNumOfBadges();
                            break;
                        }
                    }
                    if (!havePokemon) {
                        trainerEntry.getValue().missingPokemonPenalty();
                    }
                }
            }
            input = scanner.nextLine();
        }

        trainersInfo.entrySet().stream()
                .sorted((left, right) -> Integer.compare(right.getValue().getNumOfBadges(), left.getValue().getNumOfBadges()))
                .forEach(trainer -> {
                    System.out.printf("%s %s %s%n", trainer.getKey(),
                            trainer.getValue().getNumOfBadges(),
                            trainer.getValue().pokeCollectionSize());
                });
    }
}
