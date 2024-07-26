package main.Notification;

public interface LibraryNotification {
    void register(BookOutOfStockImpl bookOutOfStock);
    void unregister(BookOutOfStockImpl bookOutOfStock);
    void notifyPatrons(String isbn);
}
