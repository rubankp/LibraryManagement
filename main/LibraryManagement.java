package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import main.Book.Book;
import main.Inventory.Inventory;
import main.Library.CentralLibrarySystem;
import main.Library.Library;
import main.Patron.Patron;
import main.PatronManagement.PatronManagement;

public class LibraryManagement {
    public static void main(String[] args) {
        
        Book book1 = new Book("The Alchemist", "Paulo Coelho", "9780062315007");
        Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565");
        Book book3 = new Book("Book 3", "Harper Lee", "9780061120084");

        Library library1 = new Library("India Library", "India", "Banglore");
        Library library2 = new Library("USA Library", "USA", "New York");
        Patron patron1 = new Patron("John", "123 street Banglore", "test@gmail.com", "1234567890", "1111-2222-3333-4444");  
        Patron patron2 = new Patron("Doe", "123 street New York", "test2@gmail.com", "1234567891", "1111-2222-3333-4445");

        CentralLibrarySystem centralLibrarySystem = new CentralLibrarySystem("Central Library", "Central Library Address", "Central Branch", List.of(book1, book2, book3), List.of(patron1, patron2), List.of(library1, library2));


        Inventory inventory1 = new Inventory(book1, 10, 10.00);
        Inventory inventory2 = new Inventory(book2, 20, 20.00);
        Inventory inventory3 = new Inventory(book3, 0, 30.00);
        Inventory inventory4 = new Inventory(book3, 100, 30.00);

        library1.addInventory(inventory1);
        library1.addInventory(inventory2);
        library1.addInventory(inventory4);
        library1.printInventory();
        library2.addInventory(inventory3);
        library2.printInventory();

       

        PatronManagement patronManagement1 = new PatronManagement(1, patron1, book1, new Date(), new Date());
        PatronManagement patronManagement2 = new PatronManagement(2, patron2, book3, new Date(), new Date());

        library1.borrowBook(patronManagement2);
        library2.borrowBook(patronManagement1);
        library1.borrowBook(patronManagement2);
        library2.borrowBook(patronManagement2);

        library1.printPatronManagements();
        library2.printPatronManagements();

        library1.printInventory();
        library2.printInventory();

        centralLibrarySystem.transferBook(book3.getIsbn(), library1.getBranch(), library2.getBranch(), 4);

        library1.printInventory();
        library2.printInventory();

        library1.returnBook(patronManagement2, new Date());
        library1.printInventory();

        library1.updateInventory(book3.getIsbn(), 100);

        library1.printInventory();



    }
}
