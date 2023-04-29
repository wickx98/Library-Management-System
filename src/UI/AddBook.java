package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import Storage.Database;
import Store.Book;
import Storage.InMemoryBookStorage;

public class AddBook extends JFrame {
    private JTextField titleField;
    private JTextField authorField;
    private JTextField publisherField;
    private JTextField publishedDateField;
    private JButton submitButton;

    AddBook(){
        setTitle("Add Book");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();

        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Enter Book Title");
        titleField = new JTextField(20);
        titlePanel.add(titleLabel);
        titlePanel.add(titleField);

        JPanel authorPanel = new JPanel();
        JLabel authorLabel = new JLabel("Enter Author");
        authorField = new JTextField(20);
        authorPanel.add(authorLabel);
        authorPanel.add(authorField);

        JPanel publisherPanel = new JPanel();
        JLabel publisherLabel = new JLabel("Enter Publisher");
        publisherField = new JTextField(20);
        publisherPanel.add(publisherLabel);
        publisherPanel.add(publisherField);

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = now.format(dateFormatter);

        JPanel publishedDatePanel = new JPanel();
        JLabel publishedDateLabel = new JLabel("Enter Published Date");
        publishedDateField = new JTextField(20);
        publishedDateField.setText(formattedDate);
        publishedDatePanel.add(publishedDateLabel);
        publishedDatePanel.add(publishedDateField);

        JPanel submitPanel = new JPanel();
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submit();
            }
        });
        submitPanel.add(submitButton);

        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.add(titlePanel);
        panel.add(authorPanel);
        panel.add(publisherPanel);
        panel.add(publishedDatePanel);
        panel.add(submitPanel);

        add(panel);
        setSize(450,400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void submit(){
        int id = Database.books.size() == 0 ? 0 : Integer.parseInt( Database.books.get(Database.books.size()-1).getId());
        Book newBook = new Book(Integer.toString(id+1),titleField.getText(),authorField.getText(),publisherField.getText(),
                publishedDateField.getText());
        InMemoryBookStorage inMemoryBookStorage = new InMemoryBookStorage();
        new MessageBox("Created");
        UserInterface ui = new GUI();
        ui.start();
        this.dispose();
    }
}
