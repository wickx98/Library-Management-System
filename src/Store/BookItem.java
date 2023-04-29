package Store;

public class BookItem implements LibraryItem {
    private Book book;

    public BookItem(Book book) {
        this.book = book;
    }

    @Override
    public String getId() {
        return book.getId();
    }

    @Override
    public String getTitle() {
        return book.getTitle();
    }

    @Override
    public String getAuthor() {
        return book.getAuthor();
    }

    @Override
    public String getPublisher() {
        return book.getPublisher();
    }

    @Override
    public String getPublishedDate() {
        return book.getPublishedDate();
    }
}
