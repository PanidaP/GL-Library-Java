package GL.User;

import GL.Object.Customer;
import GL.Object.Librarian;

import java.util.ArrayList;
import java.util.List;

public class UserData {
    private List<Librarian> librarians = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    //====================== Setter Section ========================//

    public void setLibrarians(List<Librarian> librarians) {
        this.librarians = librarians;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    //====================== Getter Section ========================//

    public List<Librarian> getLibrarians() {
        return librarians;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
