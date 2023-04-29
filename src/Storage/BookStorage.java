package Storage;

import Store.Book;

import java.util.List;

public interface BookStorage {
    void addBook(Book book);
    Book getBook(String bookId);
    void removeBook(String bookId);
    void displayBooks();
}
