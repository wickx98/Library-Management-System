package Storage;

import Store.BorrowedBook;

public class DatabaseBorrowedBookStorage implements BorrowedBookStorage{
    @Override
    public void addBorrowedBook(BorrowedBook book) {

    }

    @Override
    public BorrowedBook getBook(String bookId) {
        return Database.borrowedBooks.get(bookId);
    }

    @Override
    public void removeBorrowedBook(String bookId) {

    }
}
