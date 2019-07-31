package GL.Object;

import GL.Enum.Category;
import GL.Enum.Status;

import java.util.Objects;
import java.util.UUID;

public class Book {
    private String bookname;
    private Category bookcategory;
    private String bookcode;
    private Status status;
    private String author,abstract1;
    private UUID uuid;


    //====================== Setter Section ========================//

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public void setBookcode(String bookcode) {
        this.bookcode = bookcode;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAbstract1(String abstract1) {
        this.abstract1 = abstract1;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setBookcategory(Category bookcategory) {
        this.bookcategory = bookcategory;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
    //====================== Getter Section ========================//

    public String getBookname() {
        return bookname;
    }

    public String getBookcode() {
        return bookcode;
    }

    public String getAuthor() {
        return author;
    }

    public String getAbstract1() {
        return abstract1;
    }

    public Status getStatus() {
        return status;
    }

    public Category getBookcategory() {
        return bookcategory;
    }

    public UUID getUuid() {
        return uuid;
    }
//====================== Constructor Section ========================//

    public Book(){

    }

    public Book(String bookname, Category bookcategory, String bookcode, Status status, String author, String abstract1) {
        this.bookname = bookname;
        this.bookcategory = bookcategory;
        this.bookcode = bookcode;
        this.status = status;
        this.author = author;
        this.abstract1 = abstract1;
    }

    public Book(String bookname, Category bookcategory, String bookcode, Status status, String author, String abstract1, UUID uuid) {
        this.bookname = bookname;
        this.bookcategory = bookcategory;
        this.bookcode = bookcode;
        this.status = status;
        this.author = author;
        this.abstract1 = abstract1;
        this.uuid = uuid;
    }

    //====================== To String Section ========================//
    @Override
    public String toString() {
        return "Book {" +
                "Book Name = " + bookname +
                " | Book Category = " + bookcategory +
                " | Book Code = " + bookcode + " | Book Status = " + status +'}';
    }
    //====================== Equal Section ========================//
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bookcode, book.bookcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookcode);
    }
}
