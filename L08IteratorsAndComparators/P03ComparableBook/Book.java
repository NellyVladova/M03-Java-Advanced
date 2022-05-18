package JavaAdvanced.L08IteratorsAndComparators.P03ComparableBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    private void setAuthors(String... authors) {
        if (authors.length == 0) {
            this.authors = new ArrayList<>();
        } else {
            this.authors = Arrays.asList(authors);
        }
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", this.title, this.year);
    }

    @Override
    public int compareTo(Book anotherBook) {
        int result = this.title.compareTo(anotherBook.getTitle());
        if (result == 0) {
            return Integer.compare(this.year, anotherBook.getYear());
        }
        return result;
    }
}

