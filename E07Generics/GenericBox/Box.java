package JavaAdvanced.E07Generics.GenericBox;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Comparable<T>>{
    private List<T> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public void add(T element){
        this.elements.add(element);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (T element : elements){
            sb.append(String.format("%s: %s\n", element.getClass().getName(), element));
        }
        return sb.toString().trim();
    }

    public void swap(int indexOne, int indexTwo){
        T elementAtIndexOne = this.elements.get(indexOne);
        T elementAtIndexTwo = this.elements.get(indexTwo);

        this.elements.set(indexOne, elementAtIndexTwo);
        this.elements.set(indexTwo, elementAtIndexOne);
    }

    public int countGreaterThan(T element){
        int count = 0;
        for (T currElement : elements){
            if(currElement.compareTo(element) > 0){
                count++;
            }
        }

        return count;
    }
}
