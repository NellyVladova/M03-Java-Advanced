package JavaAdvanced.AdvancedExams.E19February2022.parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot){
        if(count() < this.capacity){
            this.data.add(parrot);
        }
    }

    public boolean remove(String name){
        for (Parrot parrot : this.data){
            if (parrot.getName().equals(name)){
                this.data.remove(parrot);
                return true;
            }
        }
        return false;
    }

    public Parrot sellParrot(String name){
        for (Parrot parrot : this.data){
            if (parrot.getName().equals(name)){
                parrot.setAvailable(false);
                return parrot;
            }
        }
        return null;
    }

    public List<Parrot> sellParrotBySpecies(String species){
        List<Parrot> soldParrots = new ArrayList<>();
        for (Parrot parrot : this.data){
            if(parrot.getSpecies().equals(species)){
                parrot.setAvailable(false);
                soldParrots.add(parrot);
            }
        }
        return soldParrots;
    }

    public int count(){
        return this.data.size();
    }

    public String report(){
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(String.format("Parrots available at %s:", this.name)).append(System.lineSeparator());
        for (Parrot parrot : this.data){
            if (parrot.isAvailable()){
                strBuilder.append(parrot).append(System.lineSeparator());
            }
        }
        return strBuilder.toString().trim();
    }
}

