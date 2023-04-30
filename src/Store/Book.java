package Store;

import static Storage.Database.books;
import static Storage.Database.borrowedBooks;

public class Book {
    private String id;
    private String title;
    private String author;
    private String publisher;
    private String publishedDate;

    private boolean available;
    private String dueDate;

    public Book(String id, String title, String author, String publisher, String publishedDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishedDate = publishedDate;

    }

    // getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public boolean isAvailable(String bookId) {
        if (!books.containsKey(bookId)) {
            System.out.println("Book not found.");
            return false;
        }
        Book book = books.get(bookId);
        if (borrowedBooks.containsKey(bookId)) {
            System.out.println("Book is currently borrowed.");
            return false;
        }
        return true;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

 


}

