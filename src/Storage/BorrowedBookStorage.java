package Storage;

import Store.BorrowedBook;

public interface BorrowedBookStorage {
    void addBorrowedBook(BorrowedBook book);
    BorrowedBook getBook(String bookId);
    void removeBorrowedBook(String bookId);
}
