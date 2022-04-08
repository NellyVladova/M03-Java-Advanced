package JavaAdvanced.AdvancedExams.E26June2021.groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private int capacity;
    private List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet){
        if(getCount() < this.capacity){
            this.data.add(pet);
        }
    }

    public boolean remove(String name){
        for (Pet pet : this.data){
            if(pet.getName().equals(name)){
                this.data.remove(pet);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner){
        for (Pet pet : this.data){
            if(pet.getName().equals(name) && pet.getOwner().equals(owner)){
                return pet;
            }
        }
        return null;
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The grooming salon has the following clients:").append(System.lineSeparator());
        for (Pet pet : this.data){
            stringBuilder.append(pet.getName()).append(" ").append(pet.getOwner()).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}

