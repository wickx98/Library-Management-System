package Storage;

import Store.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryBookStorage implements BookStorage {

    public InMemoryBookStorage() {
        if(Database.books == null) {
            Database.books = new HashMap<>();
        }
    }

    @Override
    public void addBook(Book book) {
        Database.books.put(book.getId(), book);
    }

    @Override
    public Book getBook(String bookId) {
        return Database.books.get(bookId);
    }

    @Override
    public void removeBook(String bookId) {
        Database.books.remove(bookId);
    }

    public HashMap<String,Book> getAllBooks(){
        return Database.books;
    }

    public void displayBooks() {
        List<Book> bookList = new ArrayList<>(Database.books.values());

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
