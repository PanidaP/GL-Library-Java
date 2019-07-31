package GL.service;

import GL.Book.Shelf;
import GL.History.HistoryList;
import GL.Object.Customer;
import GL.Object.Librarian;
import GL.User.UserData;

public class LibraryService {

    private static LibraryService instance;
    
    private UserData librarians;
    private UserData customers;
    private HistoryList historyList;
    private Shelf shelf;
    private Librarian login;
    private Customer customerBorrow;
    
    private LibraryService() {
        
    }
    
    public static LibraryService getInstance() {
        if (instance == null) {
            instance = new LibraryService();
        }
        return instance;
    }

    //========================== Setter ==========================//
    public static void setInstance(LibraryService instance) {
        LibraryService.instance = instance;
    }

    public void setLibrarians(UserData librarians) {
        this.librarians = librarians;
    }

    public void setCustomers(UserData customers) {
        this.customers = customers;
    }

    public void setHistoryList(HistoryList historyList) {
        this.historyList = historyList;
    }

    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
    }

    public void setLogin(Librarian login) {
        this.login = login;
    }

    public void setCustomerBorrow(Customer customerBorrow) {
        this.customerBorrow = customerBorrow;
    }
    //========================== Getter ==========================//

    public UserData getLibrarians() {
        return librarians;
    }

    public UserData getCustomers() {
        return customers;
    }

    public HistoryList getHistoryList() {
        return historyList;
    }

    public Shelf getShelf() {
        return shelf;
    }

    public Librarian getLogin() {
        return login;
    }

    public Customer getCustomerBorrow() {
        return customerBorrow;
    }
}

