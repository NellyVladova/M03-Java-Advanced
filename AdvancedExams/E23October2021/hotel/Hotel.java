package JavaAdvanced.AdvancedExams.E23October2021.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person){
        if(getCount() < this.capacity){
            roster.add(person);
        }
    }

    public boolean remove(String name){
        for (Person person : this.roster){
            if(person.getName().equals(name)){
                this.roster.remove(person);
                return true;
            }
        }
        return false;
    }

    public Person getPerson(String name, String hometown){
        for (Person person : this.roster){
            if(person.getName().equals(name) && person.getHometown().equals(hometown)){
                return person;
            }
        }
        return null;
    }

    public int getCount(){
        return this.roster.size();
    }

    public String getStatistics(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("The people in the hotel %s are:", this.name)).append(System.lineSeparator());
        for (Person person : this.roster){
            stringBuilder.append(person.toString()).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}

