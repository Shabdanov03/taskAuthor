import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Author author = new Author("Shabdanov Ilim", "ilim@email", 'm');
        Author author1 = new Author("Djoldoshev nurik", "nurik@email", 'm');
        Author author2 = new Author("Nurmatova Samira", "samira@email", 'f');
        Author author3 = new Author("Dastan Akbaraliev", "dastan@email", 'm');
        Author author4 = new Author("Muratova Nuriza", "nuriza@email", 'f');

        Book book = new Book("book1", author, 500, 100);
        Book book1 = new Book("book2", author, 400, 560);
        Book book2 = new Book("book3", author2, 550, 250);
        Book book3 = new Book("book4", author, 300, 100);
        Book book4 = new Book("book5", author4, 800, 700);
        Book book5 = new Book("book6", author2, 900, 110);
        Book book6 = new Book("book7", author3, 700, 800);
        Book book7 = new Book("book8", author1, 200, 100);
        Book book8 = new Book("book9", author, 560, 440);
        Book book9 = new Book("book10", author1, 1000, 300);

        Book[] books = {book, book1, book2, book3, book4, book5, book6, book7, book8, book9};

        while (true) {
            System.out.println("1. Max price books. 2.Min price books. 3. Search Book");
            int number = new Scanner(System.in).nextInt();
            if (number == 1) {
                getMinMaxBook(books, true);
            } else if (number == 2) {
                getMinMaxBook(books, false);
            } else if (number == 3) {
                System.out.println(" Author name : ");
                String fullName = new Scanner(System.in).nextLine();
                searchBook(books, fullName);
            } else {
                System.out.println("Error");
                break;
            }
        }

    }

    public static void getMinMaxBook(Book[] books, boolean reverse) {
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                if (b1.getPrice() != b2.getPrice())
                    return b1.getPrice() - b2.getPrice();
                return b1.getName().compareTo(b2.getName());
            }
        });
        Book[] reverseBooks = new Book[books.length];
        if (reverse) {
            for (int i = books.length - 1, j = 0; i >= 0; i--) {
                reverseBooks[j] = books[i];
                j++;
            }
            System.out.println(Arrays.toString(reverseBooks));
        } else System.out.println(Arrays.toString(books));
    }

    public static void searchBook(Book[] books, String fullName) {
        for (Book book : books) {
            if (Objects.equals(book.getAuthor().getFullName(), fullName)) {
                System.out.println(book);
            }
        }
    }
}