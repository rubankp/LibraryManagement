package main.Notification;

public class BookOutOfStockImpl implements BookOutOfStock {
    private String name;
    private String isbn;

    public BookOutOfStockImpl(String name, String isbn) {
        this.name = name;
        this.isbn = isbn;
    }

    @Override
    public void update(String title) {
        System.out.println("Patron " + name + " has been notified about the book " + title);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    
}
