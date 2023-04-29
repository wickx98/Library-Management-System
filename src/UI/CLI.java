package UI;

import Store.Book;
import Store.Library;

import java.util.Scanner;

public class CLI implements UserInterface {
    private Library library;
    private Scanner scanner;

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
        library.addBook(book);
        System.out.println("Book added successfully!");


    }

    @Override
    public void displayBooks() {
        library.displayBooks();
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
}
