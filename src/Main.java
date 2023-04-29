import Storage.InMemoryBookStorage;
import Store.Book;
import Store.Library;
import UI.CLI;
import UI.UserInterface;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {




            // Create an instance of InMemoryBookStorage
            InMemoryBookStorage bookStorage = new InMemoryBookStorage();

            // Create an instance of Library and pass the bookStorage object
            Library library = new Library(bookStorage);

            // Use the library object to perform operations on the book storage
            library.addBook(new Book("1", "The Catcher in the Rye", "J.D. Salinger", "Little, Brown and Company", "July 16, 1951"));
            library.addBook(new Book("2", "To Kill a Mockingbird", "Harper Lee", "J. B. Lippincott & Co.", "July 11, 1960"));

            library.displayBooks();
            library.searchBook("Mockingbird");
            library.removeBook("1");

            library.displayBooks();
            UserInterface ui = new CLI();

            ui.start();


        }



    }
















