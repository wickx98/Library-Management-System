package Storage;

import Store.Book;
import Store.BorrowedBook;

public interface BorrowedBookStorage {
    void addBorrowedBook(Book book);
    BorrowedBook getBook(String bookId);
    void removeBorrowedBook(String bookId);
}
