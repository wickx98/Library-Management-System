package Store;

import Storage.Database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReadBorrowedBookCSV implements ReadCSV{
    @Override
    public void read(String filePath) {
        HashMap<String,BorrowedBook> borrowedBooks = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                BorrowedBook book = new BorrowedBook(data[0], data[1], data[2], data[3], data[4]);
                borrowedBooks.put(book.getBookId(),book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Database.borrowedBooks = borrowedBooks;
    }
}
