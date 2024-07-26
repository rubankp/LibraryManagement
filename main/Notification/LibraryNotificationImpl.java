package main.Notification;

import java.util.ArrayList;
import java.util.List;

public class LibraryNotificationImpl implements LibraryNotification {
    private static LibraryNotificationImpl instance;
    private List<BookOutOfStockImpl> bookOutOfStock = new ArrayList<>();

    private LibraryNotificationImpl() {}

    public static synchronized LibraryNotificationImpl getInstance() {
        if (instance == null) {
            instance = new LibraryNotificationImpl();
        }
        return instance;
    }

    @Override
    public void register(BookOutOfStockImpl bookOutOfStock) {
        this.bookOutOfStock.add(bookOutOfStock);
    }

    @Override
    public void unregister(BookOutOfStockImpl bookOutOfStock) {
        this.bookOutOfStock.remove(bookOutOfStock);
    }

    @Override
    public void notifyPatrons(String isbn) {
        System.err.println("inside notifyPatrons" + isbn + " " + bookOutOfStock.get(0).getIsbn());
        for (BookOutOfStockImpl book : bookOutOfStock) {
            if(book.getIsbn().equals(isbn)) {
                book.update(isbn);
                unregister(book);
            }
        }
    }
}