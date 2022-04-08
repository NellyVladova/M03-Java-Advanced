package JavaAdvanced.AdvancedExams.E15December2021.aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private String name;
    private int capacity;
    private int size;
    private List<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool(){
        return this.fishInPool.size();
    }

    public void add(Fish fish){
        if(!this.fishInPool.contains(fish) && getFishInPool() < getCapacity()){
            this.fishInPool.add(fish);
        }
    }

    public boolean remove(String name){
        for (Fish fish : this.fishInPool){
            if(fish.getName().equals(name)){
                this.fishInPool.remove(fish);
                return true;
            }
        }
        return false;
    }

    public Fish findFish(String name){
        for (Fish fish : this.fishInPool){
            if (fish.getName().equals(name)){
                return fish;
            }
        }
        return null;
    }

    public String report(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Aquarium: %s ^ Size: %d", this.name, this.size)).append(System.lineSeparator());
        for (Fish fish : this.fishInPool){
            stringBuilder.append(fish.toString()).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
