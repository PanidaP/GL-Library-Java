package GL.Object;

import java.time.LocalDate;

public class History {
    String bookcode,librarianApprove,librarianAccect,customer;
    LocalDate borrow,back;
    long overReturn;
    //====================== Setter Section ========================//

    public void setBookcode(String bookcode) {
        this.bookcode = bookcode;
    }

    public void setLibrarianApprove(String librarianApprove) {
        this.librarianApprove = librarianApprove;
    }

    public void setLibrarianAccect(String librarianAccect) {
        this.librarianAccect = librarianAccect;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setBorrow(LocalDate borrow) {
        this.borrow = borrow;
    }

    public void setBack(LocalDate back) {
        this.back = back;
    }

    public void setOverReturn(long overReturn) {
        this.overReturn = overReturn;
    }

    //====================== Getter Section ========================//

    public String getBookcode() {
        return bookcode;
    }

    public String getLibrarianApprove() {
        return librarianApprove;
    }

    public String getLibrarianAccect() {
        return librarianAccect;
    }

    public String getCustomer() {
        return customer;
    }

    public LocalDate getBorrow() {
        return borrow;
    }

    public LocalDate getBack() {
        return back;
    }

    public long getOverReturn() {
        return overReturn;
    }

    //====================== Constructor Section ========================//

    public History(){

    }

    public History(String bookcode, String librarianApprove, String librarianAccect, String customer, LocalDate borrow, LocalDate back, long overReturn) {
        this.bookcode = bookcode;
        this.librarianApprove = librarianApprove;
        this.librarianAccect = librarianAccect;
        this.customer = customer;
        this.borrow = borrow;
        this.back = back;
        this.overReturn = overReturn;
    }
    @Override
    public String toString() {
        return "History {" +
                "Book Code = " + bookcode +
                " | Date Borrow = " + borrow +
                " | Date must Return = " + back +
                " | Librarian Approve = " + librarianApprove +
                " | Librarian Accept = " + librarianAccect +
                " | Customer " + customer +'}';
    }
}
