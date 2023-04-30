package Storage;

import Store.Book;
import Store.BorrowedBook;

import java.util.HashMap;

public class InMemoryBorrowedBookStorage implements BorrowedBookStorage{
    public InMemoryBorrowedBookStorage() {
        if(Database.borrowedBooks == null) {
            Database.borrowedBooks = new HashMap<>();
        }
    }

    public void addBorrowedBook(BorrowedBook book) {
        Database.borrowedBooks.put(book.getBookId(), book);
    }

    @Override
    public BorrowedBook getBook(String bookId) {
        return Database.borrowedBooks.get(bookId);
    }

    @Override
    public void removeBorrowedBook(String bookId) {
        Database.borrowedBooks.remove(bookId);
    }

    public HashMap<String,BorrowedBook> getAll(){
        return Database.borrowedBooks;
    }


}
