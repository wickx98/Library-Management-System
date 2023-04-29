package Store;

public class BorrowedBook {

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public String getDataBorrowed() {
        return dataBorrowed;
    }

    public void setDataBorrowed(String dataBorrowed) {
        this.dataBorrowed = dataBorrowed;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getDateReturned() {
        return dateReturned;
    }

    public void setDateReturned(String dateReturned) {
        this.dateReturned = dateReturned;
    }

    String bookId;
     String borrowerName;

     String dataBorrowed;

     String dueDate;

     String dateReturned;

    public BorrowedBook(String bookId, String borrowerName, String dataBorrowed, String dueDate, String dateReturned) {
        this.bookId = bookId;
        this.borrowerName = borrowerName;
        this.dataBorrowed = dataBorrowed;
        this.dueDate = dueDate;
        this.dateReturned = dateReturned;
    }
}
