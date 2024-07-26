package main.Inventory;

import main.Book.Book;
import main.Notification.LibraryNotification;
import main.Notification.LibraryNotificationImpl;

public class Inventory {
        
        private Book book;
        private int quantity;
        private double price;
        private LibraryNotification libraryNotification = LibraryNotificationImpl.getInstance();
    
        public Inventory(Book book, int quantity, double price) {
            this.book = book;
            this.quantity = quantity;
            this.price = price;
        }

        public void updateQuantity(int quantity) {
            System.out.println("inside updateQuantity" + this.quantity +  quantity);
            if(quantity < 0) {
                throw new IllegalArgumentException("Invalid quantity");
            }
            this.quantity = quantity;
            if(this.quantity == 0 && quantity > 0) {
                libraryNotification.notifyPatrons(book.getIsbn());
            }
        }

        public void updatePrice(double price) {
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public Book getBook() {
            return book;
        }

        public void setBook(Book book) {
            this.book = book;
        }

        

    
}
