package Storage;

import Store.Book;
import Store.BorrowedBook;

import java.util.HashMap;

public class Database {
    public static HashMap<String, Book> books;

    public static HashMap<String, BorrowedBook> borrowedBooks;

}
