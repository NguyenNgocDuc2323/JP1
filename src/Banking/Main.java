package Banking;
import E3.Gender;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Author> authors = new ArrayList<>();
        List<Book> books = new ArrayList<>();

        authors.add(new Author("Bean", "bean@hotmail.com", Gender.M));
        authors.add(new Author("Mark", "mark@hotmail.com", Gender.M));
        authors.add(new Author("Harry", "harry@hotmail.com", Gender.F));

        books.add(new Book("Java", authors.get(0), 205, 1000));
        books.add(new Book("C#", authors.get(1), 180, 500));
        books.add(new Book("Python", authors.get(2), 200, 1500));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please Input Book Name: ");
        String bookName = scanner.nextLine();
        List<Book> filBooks = books.stream()
                .filter(book -> containsIgnoreCase(book.getName(), bookName))
                .sorted(Comparator.comparing(Book::getName))
                .toList();

        if (filBooks.size() > 0) {
            filBooks.forEach(System.out::println);
        } else {
            System.out.println("Book not found");
        }
    }
    public static boolean containsIgnoreCase(String parrentString, String childString) {
        int length = childString.length();
        int max = parrentString.length() - length;
        for (int i = 0; i <= max; i++) {
            if (parrentString.regionMatches(true, i, childString, 0, length)) {
                return true;
            }
        }
        return false;
    }
}
