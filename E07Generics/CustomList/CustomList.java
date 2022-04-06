package JavaAdvanced.E07Generics.CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> customList;

    public CustomList() {
        this.customList = new ArrayList<>();
    }

    public void add(T element){
        this.customList.add(element);
    }

    public T remove(int index){
        if(index >= 0 && index < this.customList.size()) {
            return this.customList.remove(index);
        }
        throw new IndexOutOfBoundsException("Invalid index!");
    }

    public boolean contains(T element){
        return this.customList.contains(element);
    }

    public void swap (int firstIndex, int secondIndex) {
        if (firstIndex >= 0 && firstIndex <= this.customList.size() - 1 && secondIndex >= 0 && secondIndex <= this.customList.size() - 1) {
            T elementAtIndexOne = this.customList.get(firstIndex);
            T elementAtIndexTwo = this.customList.get(secondIndex);

            this.customList.set(firstIndex, elementAtIndexTwo);
            this.customList.set(secondIndex, elementAtIndexOne);
        }else {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    public int countGreaterThan(T element){
        int count = 0;
        for (T currElement : this.customList){
            if(currElement.compareTo(element) > 0){
                count++;
            }
        }
        return count;
    }

    public T getMax() {
        return Collections.max(this.customList);
    }

    public T getMin() {
        return Collections.min(this.customList);
    }

    public void print(){
        for(T element : this.customList){
            System.out.println(element);
        }
    }

    public void sort(){
        this.customList.sort(Comparable::compareTo);
    }
}

