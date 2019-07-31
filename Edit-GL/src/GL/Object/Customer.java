package GL.Object;

import GL.Enum.Position;
import GL.Object.User;

public class Customer extends User {
    public Customer(){

    }

    public Customer(String firstName, String lastName, String id, String pass, Position position) {
        super(firstName, lastName, id, pass, position);
    }
    //====================== To String Section ========================//
    @Override
    public String toString() {
        return "Customer {" +
                "Firstname = " + firstName + " | Lastname = " + lastName + " | ID = " + id + ' ' + '}';
    }
}
