package JavaAdvanced.AdvancedExams.E17Dec2019.christmas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count(){
        return this.data.size();
    }

    public void add(Present present){
        if(this.capacity > this.data.size()){
            this.data.add(present);
        }
    }

    public boolean remove(String name){
        for (Present present : data){
            if(present.getName().equals(name)){
                data.remove(present);
                return true;
            }
        }
        return false;
    }

    public Present heaviestPresent(){
        return this.data.stream().max(Comparator.comparingDouble(Present::getWeight)).orElse(null);
    }

    public Present getPresent(String name){
        return this.data.stream().filter(present -> present.getName().equals(name)).findFirst().orElse(null);
    }

    public String report(){
        StringBuilder sb = new StringBuilder(String.format("%s bag contains:\n", this.getColor()));
        for (Present present : this.data){
            sb.append(present.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
