package E3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Author> authors = new ArrayList<>();
        List<Book> books = new ArrayList<>();
        authors.add(new Author("Duc","nguenngocduc332@gmail.com",Gender.M));
        authors.add(new Author("Huyen","nguenthihuyen@gmail.com",Gender.F));
        authors.add(new Author("Duy","nguenngocduy@gmail.com",Gender.M));

        books.add(new Book("Dế Mèn Phiêu Lưu Kí",authors.get(0),123000,2));
        books.add(new Book("Tấm Cám",authors.get(1),100000,1));
        books.add(new Book("Thánh Gióng",authors.get(2),50000,3));
        System.out.println("Sắp Xếp Theo Tên Tác Giả : ");
        authors.stream()
                .sorted(Comparator.comparing(Author::getName))
                .forEach(author -> System.out.println(author.getName()));
        System.out.println("\nSắp Xếp Theo Tên Sách : ");
        books.stream()
                .sorted(Comparator.comparing(Book::getName))
                .forEach(book -> System.out.println(book.getName()));
        System.out.println("\nGiá Max Của Tất Cả Các Sách : ");
        Optional <Book> maxPrice = books.stream()
                .max(Comparator.comparing(Book::getPrice));
        System.out.println(maxPrice.get().getPrice());
        //B3:
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nMời Nhập Tên Tác Giá : ");
        String authorName = scanner.nextLine();
        System.out.println("\nSách của tác giả " + authorName + ":");
        books.stream()
                .filter(book -> book.getAuthor().getName().equals(authorName))
                .forEach(book -> System.out.println(book.getName()));
    }
}
