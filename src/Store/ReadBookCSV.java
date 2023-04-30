package Store;

import Storage.Database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReadBookCSV implements ReadCSV{
    @Override
    public void read(String filePath) {

            HashMap<String,Book> books = new HashMap<>();

            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    String id = values[0];
                    String title = values[1];
                    String author = values[2];
                    String publisher = values[3];
                    String publishedDate = values[4];
                    Book book = new Book(id, title, author, publisher, publishedDate);
                    books.put(book.getId(),book);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            Database.books = books;
        }
    }
