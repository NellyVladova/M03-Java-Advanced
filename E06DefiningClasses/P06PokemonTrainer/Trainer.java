package JavaAdvanced.E06DefiningClasses.P06PokemonTrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Trainer {
    private int numOfBadges;
    private List<Pokemon> pokemonList;

    public Trainer() {
        this.numOfBadges = 0;
        this.pokemonList = new ArrayList<>();
    }

    public void setNumOfBadges() {
        this.numOfBadges++;
    }

    public List<Pokemon> getPokemonList() {
        return new ArrayList<>(this.pokemonList);
    }

    public int getNumOfBadges() {
        return numOfBadges;
    }

    public int pokeCollectionSize() {
        return this.pokemonList.size();
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemonList.add(pokemon);
    }

    private UnaryOperator<Pokemon> damagePokemon = pokemon ->
            new Pokemon(pokemon.getName(), pokemon.getElement(), pokemon.getHealth() - 10);

    public void missingPokemonPenalty() {
        this.pokemonList = this.pokemonList
                .stream()
                .map(damagePokemon)
                .filter(pokemon -> pokemon.getHealth() > 0)
                .collect(Collectors.toList());
    }
}
