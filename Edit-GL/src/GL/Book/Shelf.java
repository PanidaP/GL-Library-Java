package GL.Book;

import GL.Object.Book;

import java.util.ArrayList;
import java.util.List;

//====================== Shelf Class ========================//
public class Shelf{
    private List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
