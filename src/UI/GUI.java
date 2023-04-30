package UI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

import Storage.BookStorage;
import Storage.BorrowedBookStorage;
import Storage.InMemoryBookStorage;
import Storage.InMemoryBorrowedBookStorage;
import Store.Book;
import Store.BorrowedBook;

public class GUI implements  UserInterface {

    private JFrame frame;
    private JButton addBookButton;
    private JButton removeBookButton;
    private JButton displayBooksButton;
    private JButton borrowBookButton;
    private JTextField searchBookField;
    private JButton returnBookButton;
    private JButton displayBorrowedBooksButton;
    private JButton displayOverdueBooksButton;
    private JTable table;
    private boolean bookView;
    private boolean borrowedBookView;
    private HashMap<String,Book> books;
    private HashMap<String, BorrowedBook> borrowed;
    private DefaultTableModel model;

    final String[] columnNames = {"ID", "Title", "Author", "Publisher", "Published Date"};

    @Override
    public void displayMenu() {

    }

    @Override
    public void addBook() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AddBook();
            }
        });
        exit();
    }

    @Override
    public void displayBooks() {
        getBooks();
        booksView();

        DefaultTableModel newModel = new DefaultTableModel(columnNames,0);
        List<Book> bookList =new ArrayList<>(books.values());
        for(Book book : bookList){
            Object[] rowData = {book.getId(), book.getTitle(), book.getAuthor(), book.getPublisher(), book.getPublishedDate()};
            newModel.addRow(rowData);
        }
        table.setModel(newModel);
        model = newModel;
    }

    @Override
    public void displayBookDetails() {

    }

    @Override
    public void searchBook() {
        getBooks();
        booksView();
        String val = searchBookField.getText();
        DefaultTableModel newModel = new DefaultTableModel(columnNames,0);
        List<Book> bookList =new ArrayList<>(books.values());
        for(Book book : bookList){
            if(book.getTitle().toLowerCase().contains(searchBookField.getText().toLowerCase())){
                Object[] rowData = {book.getId(), book.getTitle(), book.getAuthor(), book.getPublisher(), book.getPublishedDate()};
                newModel.addRow(rowData);
            }

        }
        table.setModel(newModel);
        model = newModel;
    }

    @Override
    public void removeBook() {
        int rowIndex = table.getSelectedRow();
        String id = model.getValueAt(rowIndex,0).toString();
        Book book = books.get(id);

        model.removeRow(rowIndex);
        BookStorage storage = new InMemoryBookStorage();
        storage.removeBook(id);
        displayBooks();
    }

    @Override
    public void exit() {
        frame.dispose();
    }

    @Override
    public void start() {
        bookView = false;
        borrowedBookView = false;
        frame = new JFrame();
        frame.setTitle("Library Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();

        JPanel addBookPanel = new JPanel();
        addBookButton = new JButton("Add New Book");
        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBook();
            }
        });
        addBookPanel.add(addBookButton);

        JPanel removeBookPanel = new JPanel();
        removeBookButton = new JButton("RemoveBook");
        removeBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runRemoveBook();
            }
        });
        removeBookPanel.add(removeBookButton);

        JPanel displayBooksPanel = new JPanel();
        displayBooksButton = new JButton("Display Books");
        displayBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayBooks();
            }
        });
        displayBooksPanel.add(displayBooksButton);

        JPanel searchBookPanel = new JPanel();
        searchBookField = new JTextField(20);
        searchBookField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchBook();
            }
        });
        searchBookPanel.add(searchBookField);

        JPanel borrowBookPanel = new JPanel();
        borrowBookButton = new JButton("Borrow Book");
        borrowBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrowBook();
            }
        });
        borrowBookPanel.add(borrowBookButton);

        JPanel returnBookPanel = new JPanel();
        returnBookButton = new JButton("Return Book");
        returnBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                returnBook();
            }
        });
        returnBookPanel.add(returnBookButton);

        JPanel displayBorrowedBooksPanel = new JPanel();
        displayBorrowedBooksButton = new JButton("Display Borrowed Books");
        displayBorrowedBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayBorrowedBooks();
            }
        });
        displayBorrowedBooksPanel.add(displayBorrowedBooksButton);

        JPanel displayOverdueBooksPanel = new JPanel();
        displayOverdueBooksButton = new JButton("Display Overdue Books");
        displayOverdueBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayOverdueBooks();
            }
        });
        displayOverdueBooksPanel.add(displayOverdueBooksButton);

        JPanel tablePanel = new JPanel();
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        tablePanel.add(scrollPane);

        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.add(addBookPanel);
        panel.add(removeBookPanel);
        panel.add(displayBooksPanel);
        panel.add(searchBookPanel);
        panel.add(borrowBookPanel);
        panel.add(returnBookPanel);
        panel.add(displayBorrowedBooksPanel);
        panel.add(displayOverdueBooksPanel);
        panel.add(tablePanel);

        frame.add(panel);

        frame.setSize(500,550);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public void borrowBook(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BorrowBook();
            }
        });
        frame.dispose();
    }

    public void returnBook(){
        int rowIndex = table.getSelectedRow();
        String id = model.getValueAt(rowIndex,0).toString();
        Book book = books.get(id);

        model.removeRow(rowIndex);
        BorrowedBookStorage storage = new InMemoryBorrowedBookStorage();
        storage.removeBorrowedBook(id);
        displayBorrowedBooks();
    }

    public void displayBorrowedBooks(){
        getBooks();
        getBorrowedBooks();
        borrowedBook();
        List<Book> borrowedBooksList = new ArrayList<>();
        for(Map.Entry<String,BorrowedBook> entry : borrowed.entrySet()){
            String id = entry.getKey();
            if(books.containsKey(id)){
                borrowedBooksList.add(books.get(id));
            }
        }

        DefaultTableModel newModel = new DefaultTableModel(columnNames,0);
        for (Book book : borrowedBooksList) {
            Object[] rowData = {book.getId(), book.getTitle(), book.getAuthor(), book.getPublisher(), book.getPublishedDate()};
            newModel.addRow(rowData);
        }
        table.setModel(newModel);
        model = newModel;

    }

    public void displayOverdueBooks(){
        getBorrowedBooks();
        borrowedBook();
        List<Book> borrowedBooksList = new ArrayList<>();
        for(Map.Entry<String,BorrowedBook> entry : borrowed.entrySet()){
            String id = entry.getKey();
            if(books.containsKey(id) && getOverDue(entry.getValue().getDueDate())){
                borrowedBooksList.add(books.get(id));
            }
        }

        DefaultTableModel newModel = new DefaultTableModel(columnNames,0);
        for (Book book : borrowedBooksList) {
            Object[] rowData = {book.getId(), book.getTitle(), book.getAuthor(), book.getPublisher(), book.getPublishedDate()};
            newModel.addRow(rowData);
        }
        table.setModel(newModel);
        model = newModel;
    }

    private void getBooks(){
        InMemoryBookStorage storage = new InMemoryBookStorage();
        this.books = storage.getAllBooks();
    }

    private void getBorrowedBooks(){
        InMemoryBorrowedBookStorage storage = new InMemoryBorrowedBookStorage();
        borrowed = storage.getAll();
    }

    private void booksView(){
        bookView = true;
        borrowedBookView = false;
    }

    private void runRemoveBook(){
        if(bookView && !borrowedBookView){
            removeBook();
        }
    }

    private void runReturnBook(){
        if(!bookView && borrowedBookView){
            returnBook();
        }
    }

    private boolean getOverDue(String inputDate) {
        boolean overDue = false;

        LocalDate today = LocalDate.now();
        LocalDate date = LocalDate.parse(inputDate, DateTimeFormatter.ISO_LOCAL_DATE);

        if (date.isBefore(today) || date.isEqual(today)) {
            overDue = true;
        }

        return overDue;
    }

    private void borrowedBook(){
        bookView= false;
        borrowedBookView =true;
    }
}
