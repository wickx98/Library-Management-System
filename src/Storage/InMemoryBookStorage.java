package Storage;

import Store.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryBookStorage implements BookStorage {
    private Map<String, Book> books;

    public InMemoryBookStorage() {
        books = new HashMap<>();
    }

    @Override
    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    @Override
    public Book getBook(String bookId) {
        return books.get(bookId);
    }

    @Override
    public void removeBook(String bookId) {
        books.remove(bookId);
    }

    @Override
    public void displayBooks() {
        List<Book> bookList = new ArrayList<>(books.values());

        if (bookList.isEmpty()) {
            System.out.println("No books to display.");
            return;
        }

        System.out.println("Books in the library:");
        for (Book book : bookList) {
            System.out.println(book);
        }
    }
}
