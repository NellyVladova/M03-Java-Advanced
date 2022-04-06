package JavaAdvanced.E06DefiningClasses.P07Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private Car car;
    private Company company;
    private List<Parent> parentList;
    private List<Children> childrenList;
    private List<Pokemon> pokemonList;


    public Person(Car car, Company company, List<Parent> parentList,
                  List<Children> childrenList, List<Pokemon> pokemonList) {
        this.car = car;
        this.company = company;
        this.parentList = parentList;
        this.childrenList = childrenList;
        this.pokemonList = pokemonList;
    }

    public Person(){
        this.parentList = new ArrayList<>();
        this.childrenList = new ArrayList<>();
        this.pokemonList = new ArrayList<>();
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Parent> getParentList() {
        return parentList;
    }

    public List<Children> getChildrenList() {
        return childrenList;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Company:\n" );
        if(company != null){
            stringBuilder.append(company).append("\n");
        }
        stringBuilder.append("Car:\n");
        if(car != null){
            stringBuilder.append(car).append("\n");
        }
        stringBuilder.append("Pokemon:\n");
        for (Pokemon pokemon : pokemonList){
            stringBuilder.append(pokemon).append("\n");
        }
        stringBuilder.append("Parents:\n");
        for (Parent parent : parentList){
            stringBuilder.append(parent).append("\n");
        }
        stringBuilder.append("Children:\n");
        for (Children children : childrenList){
            stringBuilder.append(children).append("\n");
        }

        return stringBuilder.toString();
    }
}
