package main.Library;

import java.util.List;
import main.Book.Book;
import main.Patron.Patron;

public class CentralLibrarySystem {

  
    private List<Book> books;
    private List<Patron> patrons;
    private List<Library> libraries;    

    public CentralLibrarySystem(String name, String address, String branch, List<Book> books, List<Patron> patrons, List<Library> libraries) {
        this.books = books;
        this.patrons = patrons;
        this.libraries = libraries;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Patron> getPatrons() {
        return patrons;
    }

    public void setPatrons(List<Patron> patrons) {
        this.patrons = patrons;
    }

    public List<Library> getLibraries() {
        return libraries;
    }

    public void setLibraries(List<Library> libraries) {
        this.libraries = libraries;
    }

    public void transferBook(String isbn, String fromBranch, String toBranch, int quantity) {
        try{
            Library fromBranchLocal = null;
            Library toBranchLocal = null;
            for (Library l : libraries) {
                if (l.getBranch().equals(fromBranch)) {
                    fromBranchLocal = l;
                } else if (l.getBranch().equals(toBranch)) {
                    toBranchLocal = l;
                } 
            }
            if(fromBranchLocal == null || toBranchLocal == null) {
                System.out.println("Branch not found");
            }
            fromBranchLocal.updateInventoryBetweenBranches(isbn, -quantity);
            toBranchLocal.updateInventoryBetweenBranches(isbn, quantity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    public void addLibrary(Library library) {
        libraries.add(library);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void removePatron(Patron patron) {
        patrons.remove(patron);
    }

    public void removeLibrary(Library library) {
        libraries.remove(library);
    }

    public void searchBook(String q){
        for (Book b : books) {
            if(b.getTitle().contains(q) || b.getIsbn().contains(q)) {
                System.out.println(b.getTitle() + " " + b.getIsbn());
            }
        }
    }

    public void getBookByIsbn(String isbn) {
        for (Book b : books) {
            if(b.getIsbn().equals(isbn)) {
                System.out.println(b.getTitle() + " " + b.getIsbn());
            }
        }
    }

    public void getBookByTitle(String title) {
        for (Book b : books) {
            if(b.getTitle().equals(title)) {
                System.out.println(b.getTitle() + " " + b.getIsbn());
            }
        }
    }
   
}