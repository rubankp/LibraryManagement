package main.PatronManagement;

import java.util.Date;

import main.Book.Book;
import main.Patron.Patron;

public class PatronManagement {

    private int id;
    private Patron patron;
    private Book book;
    private Date borrowedDate;
    private Date dueDate;
    private Date returnedDate;

    public PatronManagement(int id, Patron patron, Book book, Date borrowedDate, Date dueDate) {
        this.id = id;
        this.patron = patron;
        this.book = book;
        this.borrowedDate = borrowedDate;
        this.dueDate = dueDate;
    }

    public Patron getPatron() {
        return patron;
    }

    
    public void setPatron(Patron patron) {
        this.patron = patron;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
}
