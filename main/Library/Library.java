package main.Library;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import main.Inventory.Inventory;
import main.Notification.BookOutOfStockImpl;
import main.Notification.LibraryNotificationImpl;
import main.PatronManagement.PatronManagement;

public class Library {
    
    private String name;
    private String address;
    private String branch;
    private List<Inventory> inventory = new ArrayList<>();
    private List<PatronManagement> patronManagements = new ArrayList<>();
    private final LibraryNotificationImpl libraryNotification = LibraryNotificationImpl.getInstance();

    public Library(String name, String address, String branch) {
        this.name = name;
        this.address = address;
        this.branch = branch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public List<Inventory> getInventory() {
        return inventory;
    }

    public void addInventory(Inventory inventory) {
        this.inventory.add(inventory);
    }

    public void updateInventoryBetweenBranches(String isbn, int quantity){
        Boolean found = false;
        for (Inventory i : inventory) {
            if (i.getBook().getIsbn().equals(isbn)) {
                found = true;
                i.updateQuantity(i.getQuantity() + quantity);
            }
        }
        if(!found) {
            throw new IllegalArgumentException("Book not found in the inventory");
        }
    }

    public void updateInventory(String isbn, int quantity) {
        Boolean found = false;
        for (Inventory i : inventory) {
            if (i.getBook().getIsbn().equals(isbn)) {
                found = true;
                i.updateQuantity(quantity);
            }
        }
        if(!found) {
            throw new IllegalArgumentException("Book not found in the inventory");
        }
    }

    public void updateInventory(String isbn, double price) {
        Boolean found = false;
        for (Inventory i : inventory) {
            if (i.getBook().getIsbn().equals(isbn)) {
                i.updatePrice(price);
            }
        }
        if(!found) {
            throw new IllegalArgumentException("Book not found in the inventory");
        }
    }

    public void updateInventory(String isbn, int quantity, double price) {
        Boolean found = false;
        for (Inventory i : inventory) {
            if (i.getBook().getIsbn().equals(isbn)) {
                i.updateQuantity(quantity);
                i.updatePrice(price);
            }
        }
        if(!found) {
            throw new IllegalArgumentException("Book not found in the inventory");
        }
    }

    public void removeInventory(Inventory inventory) {
        this.inventory.remove(inventory);
    }

    public List<PatronManagement> getPatronManagements() {
        return patronManagements;
    }

    public void borrowBook(PatronManagement patronManagement) {
        for (Inventory i : inventory) {
            if (i.getBook().getIsbn().equals(patronManagement.getBook().getIsbn())) {
                if(i.getQuantity() == 0) {
                    System.out.println("Book is out of stock, you will be added to the waiting list");
                    BookOutOfStockImpl bookOutOfStock = new BookOutOfStockImpl(patronManagement.getPatron().getName(), patronManagement.getBook().getIsbn());
                    libraryNotification.register(bookOutOfStock);
                    return;
                }
                i.updateQuantity(i.getQuantity() - 1);
            }
        }
    
        this.patronManagements.add(patronManagement);
    }

    public void returnBook(PatronManagement patronManagement, Date returnDate) {
        Boolean found = false;
        for (PatronManagement p : patronManagements) {
            if (p.getPatron().getLibraryCardNumber() == patronManagement.getPatron().getLibraryCardNumber() && p.getBook().getIsbn().equals(patronManagement.getBook().getIsbn())) {
                p.setReturnedDate(returnDate);
                found = true;
            }
        }
        if(!found) {
            throw new IllegalArgumentException("Book not found in the patron management");
        }
        for (Inventory i : inventory) {
            if (i.getBook().getIsbn().equals(patronManagement.getBook().getIsbn())) {
                i.updateQuantity(i.getQuantity() + 1);
            }
        }
    }

    public void printInventory() {
        for (Inventory i : inventory) {
            System.out.println(branch +  "Title: " + i.getBook().getTitle() + " ISBN: " + i.getBook().getIsbn() + " Quantity: " + i.getQuantity() + " Price: " + i.getPrice());
        }
    }

    public void printPatronManagements() {
        for (PatronManagement p : patronManagements) {
            System.out.println("Patron: " + p.getPatron().getName() + " Book: " + p.getBook().getTitle() + " Borrowed Date: " + p.getBorrowedDate() + " Returned Date: " + p.getReturnedDate());
        }
    }

    public void printBorrowedBooks() {
        for (PatronManagement p : patronManagements) {
            if(p.getReturnedDate() == null) {
                System.out.println("Patron: " + p.getPatron().getName() + " Book: " + p.getBook().getTitle() + " Borrowed Date: " + p.getBorrowedDate());
            }
        }
    }
    


}

