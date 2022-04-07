package JavaAdvanced.E08IteratorsAndComparators.P04Froggy;

import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer>{
    private List<Integer> numbers;

    public Lake(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public Iterator<Integer> iterator(){
        return new Frog();
    }

    private class Frog implements Iterator<Integer>{
        private int position;
        private int lastIndexOfEvenNumber = numbers.size() % 2 == 0 ? numbers.size() - 2 : numbers.size() - 1;

        @Override
        public boolean hasNext() {
            return this.position < numbers.size();
        }

        @Override
        public Integer next() {
            int index = numbers.get(position);
            if (this.position == this.lastIndexOfEvenNumber) {
                this.position = 1;
                return index;
            }
            position += 2;
            return index;
        }
    }
}
