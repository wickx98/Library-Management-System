package UI;

import Storage.*;
import Store.Book;
import Store.BorrowedBook;
import Store.Library;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static Storage.Database.books;

import static Storage.Database.borrowedBooks;

public class CLI implements UserInterface {
    private Library library;
    private Scanner scanner;

    DatabaseBookStorage Database = new DatabaseBookStorage();
    InMemoryBookStorage inMemory = new InMemoryBookStorage();

    public CLI() {
        library = new Library();
        scanner = new Scanner(System.in);

    }

    @Override
    public void displayMenu() {
        System.out.println("Library Management System");
        System.out.println("------------------------");
        System.out.println("1. Add a book");
        System.out.println("2. Display all books");
        System.out.println("3. Display book details");
        System.out.println("4. Search for a book by title");
        System.out.println("5. Remove a book by ID");
        System.out.println("6. Borrow a book");
        System.out.println("7. Return a book");
        System.out.println("8. Display borrowed books");
        System.out.println("9. Display overdue books");
        System.out.println("Enter 'exit' to quit the program.");


    }

    @Override
    public void addBook() {
        System.out.print("Enter the book ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter the book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter the book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter the book publisher: ");
        String publisher = scanner.nextLine();
        System.out.print("Enter the book published date: ");
        String publishedDate = scanner.nextLine();

        Book book = new Book(id, title, author, publisher, publishedDate);


        BookStorage bookStorage = new InMemoryBookStorage();
        bookStorage.addBook(book);
        System.out.println("Book added successfully!");

    }

    @Override
    public void displayBooks() {

        InMemoryBookStorage bookStorage = new InMemoryBookStorage();
        bookStorage.getAllBooks();

        for(Map.Entry<String,Book> entry : bookStorage.getAllBooks().entrySet() ){
            System.out.println(entry.getValue().getTitle());
        }

    }

    @Override
    public void displayBookDetails() {
        System.out.print("Enter the book ID: ");
        String bookIdToDisplay = scanner.nextLine();
        library.displayBookDetails(bookIdToDisplay);
    }

    @Override
    public void searchBook() {
        System.out.print("Enter the search term: ");
        String searchTerm = scanner.nextLine();
        library.searchBook(searchTerm);
    }

    @Override
    public void removeBook() {
        System.out.print("Enter the book ID: ");
        String removeId = scanner.nextLine();

        library.removeBook(removeId);
        System.out.println("Book removed successfully!");
    }

    @Override
    public void exit() {
        System.out.println("Exiting the program...");
        scanner.close();
        System.exit(0);
    }
    @Override
    public void start() {
        String choice;
        displayMenu();
        do {
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine().toLowerCase();

            switch (choice) {
                case "1":
                    addBook();
                    break;
                case "2":
                    displayBooks();
                    break;
                case "3":
                    displayBookDetails();
                    break;
                case "4":
                    searchBook();
                    break;
                case "5":
                    removeBook();
                    break;
                case "6":
                    borrowBook();
                    break;
                case "7":
                    returnBook();
                    break;
                case "8":
                    displayBorrowedBooks();
                    break;
                case "9":
                    displayOverdueBooks();
                    break;
                case "exit":
                    exit();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
            displayMenu();
        } while (!choice.equals("exit"));
    }

    @Override
    public void borrowBook() {

        System.out.print("Enter the book ID: ");
        String bookId = scanner.nextLine();

        if (books.containsKey(bookId)) {
            Book book = books.get(bookId);

            if (book.isAvailable(bookId)) {
                System.out.print("Enter your name: ");
                String borrowerName = scanner.nextLine();
                System.out.print("Enter the date borrowed (dd/mm/yyyy): ");
                String dateBorrowed = scanner.nextLine();
                System.out.print("Enter the number of days to borrow: ");
                int daysToBorrow = scanner.nextInt();

                // calculate the due date
                LocalDate borrowedDate = LocalDate.parse(dateBorrowed, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                LocalDate dueDate = borrowedDate.plusDays(daysToBorrow);

                // update the book availability and due date
                book.setAvailable(false);
                book.setDueDate(dueDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

                BorrowedBook borrowedBook = new BorrowedBook(bookId,borrowerName,dateBorrowed,dueDate.toString(),"0");
                // add the book to the borrowed books HashMap
                BorrowedBookStorage storage = new InMemoryBorrowedBookStorage();

                storage.addBorrowedBook(borrowedBook);

                System.out.println("Book borrowed successfully!");
            } else {
                System.out.println("Sorry, this book is not available.");
            }
        } else {
            System.out.println("Book with ID " + bookId + " not found.");
        }

    }

    @Override
    public void returnBook() {

    }

    @Override
    public void displayBorrowedBooks() {

    }

    @Override
    public void displayOverdueBooks() {

    }
}
