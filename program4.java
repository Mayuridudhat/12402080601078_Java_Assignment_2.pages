import java.util.*;

class Book implements Comparable<Book> {
    int id;
    String title;
    double price;

    Book(int id, String title, double price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    // Default sorting by ID using Comparable
    @Override
    public int compareTo(Book other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Book[ID=" + id + ", Title=" + title + ", Price=$" + price + "]";
    }
}

// Custom sorting by Title using Comparator
class TitleComparator implements Comparator<Book> {
    public int compare(Book b1, Book b2) {
        return b1.title.compareTo(b2.title);
    }
}

// Custom sorting by Price using Comparator
class PriceComparator implements Comparator<Book> {
    public int compare(Book b1, Book b2) {
        return Double.compare(b1.price, b2.price);
    }
}

public class Program4 {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(3, "Java Programming", 45.50));
        books.add(new Book(1, "Python Basics", 30.00));
        books.add(new Book(2, "Data Structures", 55.00));

        System.out.println("=== Original List ===");
        books.forEach(System.out::println);

        System.out.println("\n=== Sorted by ID (Comparable) ===");
        Collections.sort(books);
        books.forEach(System.out::println);

        System.out.println("\n=== Sorted by Title (Comparator) ===");
        books.sort(new TitleComparator());
        books.forEach(System.out::println);

        System.out.println("\n=== Sorted by Price (Comparator) ===");
        books.sort(new PriceComparator());
        books.forEach(System.out::println);
    }
}