package JavaAdvanced.L08IteratorsAndComparators.P04BookComparator;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    public int compare(Book book1, Book book2) {
        int result = book1.getTitle().compareTo(book2.getTitle());
        if(result == 0){
            return Integer.compare(book1.getYear(), book2.getYear());
        }
        return result;
    }
}

