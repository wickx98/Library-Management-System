package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    @Override
    public void displayMenu() {

    }

    @Override
    public void addBook() {

    }

    @Override
    public void displayBooks() {

    }

    @Override
    public void displayBookDetails() {

    }

    @Override
    public void searchBook() {

    }

    @Override
    public void removeBook() {

    }

    @Override
    public void exit() {
        frame.dispose();
    }

    @Override
    public void start() {
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
                removeBook();
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

    private void borrowBook(){

    }

    private void returnBook(){

    }

    private void displayBorrowedBooks(){

    }

    private void displayOverdueBooks(){

    }
}
