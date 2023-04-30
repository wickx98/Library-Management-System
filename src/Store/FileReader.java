package Store;

public class FileReader {
    public FileReader(){
        ReadBookCSV readBookCSV = new ReadBookCSV();
        readBookCSV.read(FilePaths.BOOK_PATH);
        ReadBorrowedBookCSV readBorrowedBookCSV = new ReadBorrowedBookCSV();
        readBorrowedBookCSV.read(FilePaths.BORROWED_BOOKS);
    }
}
