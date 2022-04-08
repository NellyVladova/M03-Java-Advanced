package JavaAdvanced.AdvancedExams.E19August2020.vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet){
        if(getCount() < this.capacity){
            this.data.add(pet);
        }
    }

    public boolean remove(String name){
        for(Pet pet : this.data){
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

    public Pet getOldestPet(){
        int maxAge = 0;
        Pet pet = null;
        for (Pet currPet : this.data){
            if(currPet.getAge() > maxAge){
                maxAge = currPet.getAge();
                pet = currPet;
            }
        }
        return pet;
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The clinic has the following patients:").append(System.lineSeparator());
        for (Pet pet : this.data){
            stringBuilder.append(pet.getName()).append(" ").append(pet.getOwner()).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}

