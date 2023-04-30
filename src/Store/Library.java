package Store;


import Storage.BookStorage;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private final BookStorage bookStorage;
    private Map<String, Book> books;

    public Library() {
        books = new HashMap<>();
        bookStorage = null;
    }

    public Library(BookStorage bookStorage) {
        this.bookStorage = bookStorage;
        this.books = new HashMap<>();

    }
    public void addBook(Book book) {
        books.put(book.getId(), book);

    }

    public void removeBook(String bookId) {
        books.remove(bookId);
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("There are no books in the library.");
            return;
        }
        System.out.println("List of books:");
        System.out.println("---------------");
        for (Book book : books.values()) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }
    }

    public void displayBookDetails(String bookId) {
        Book book = books.get(bookId);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        System.out.println("Book details:");
        System.out.println("--------------");
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Publisher: " + book.getPublisher());
        System.out.println("Published date: " + book.getPublishedDate());
    }

    public List<Book> searchBook(String searchTerm) {
        List<Book> matchingBooks = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getTitle().toLowerCase().contains(searchTerm.toLowerCase())) {
                matchingBooks.add(book);
            }
        }
        if (matchingBooks.isEmpty()) {
            System.out.println("No books found matching the search term.");
        } else {
            System.out.println("Matching books:");
            System.out.println("----------------");
            for (Book book : matchingBooks) {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        }
        return matchingBooks;
    }
}
