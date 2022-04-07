package JavaAdvanced.E08IteratorsAndComparators.P06StrategyPattern;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2){
        int nameLength = Integer.compare(p1.getName().length(), p2.getName().length());
        if(nameLength == 0){
            return Character.compare(p1.getName().toUpperCase().charAt(0), p2.getName().toUpperCase().charAt(0));
        }
        return nameLength;
    }
}
