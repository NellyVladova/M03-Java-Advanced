package JavaAdvanced.E08IteratorsAndComparators.P02Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ListyIterator implements Iterable<String> {
    private List<String> data;
    private int index;


    public ListyIterator() {
        this.data = new ArrayList<>();
        this.index = 0;

    }

    public ListyIterator(String... strings) {
        this();
        this.data = Arrays.asList(strings);
    }

    public void print() {
        if (this.index >= this.data.size()) {
            System.out.println("Invalid Operation!");
            return;
        }
        System.out.println(this.data.get(this.index));
    }

    public void create(String[] lines) {
        for (int i = 1; i < lines.length; i++) {
            this.data.add(lines[i]);
        }
    }

    public boolean move() {
        if (this.hasNext()) {
            this.index++;
            return true;
        }
        return false;

    }

    public boolean hasNext() {
        return this.index < this.data.size() - 1;
    }

    public void printAll() {
        if (this.data.isEmpty()) {
            throw new NullPointerException("Invalid Operation!");
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.data) {
            stringBuilder.append(str).append(" ");
        }
        System.out.println(stringBuilder.toString().trim());
    }

    @Override
    public Iterator<String> iterator() {
        return new ListIterator();
    }

    @Override
    public void forEach(Consumer<? super String> action) {
        Iterator<String> iterator = new ListIterator();
        while (iterator.hasNext()) {
            action.accept(iterator.next());
        }
    }

    private class ListIterator implements Iterator<String> {
        private int position;

        @Override
        public boolean hasNext() {
            return this.position + 1 <= data.size();
        }

        @Override
        public String next() {
            return data.get(this.position++);
        }
    }
}
