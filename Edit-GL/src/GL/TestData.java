package GL;

import GL.Object.Book;
import GL.Book.Shelf;
import GL.Enum.Category;
import GL.Enum.Position;
import GL.Enum.Status;
import GL.Object.History;
import GL.History.HistoryList;
import GL.Object.Customer;
import GL.Object.Librarian;
import GL.User.UserData;

import java.time.LocalDate;

public class TestData {
    public static void BookList(Shelf shelf) {
        LocalDate dateSet = LocalDate.of(2019, 06, 20);
        //**************** Book List ****************//
        shelf.getBooks().add(new Book("Sorry,I love 2D", Category.Novel, "N1006", Status.unavailable,
                "fullycup", "Love comedy Fantasy"));
        shelf.getBooks().add(new Book("Zevena", Category.Novel, "N1002", Status.available,
                "Gunthida", "Best Fantasy"));
        shelf.getBooks().add(new Book("World war #2", Category.History, "H1099", Status.unaccept,
                "Hana", "Big war of the world"));
        shelf.getBooks().add(new Book("World war #2", Category.History, "H1102", Status.available,
                "Hana", "Big war of the world"));
        shelf.getBooks().add(new Book("Java", Category.Computer, "C2005", Status.available,
                "People", "learn Java with somebody"));
        shelf.getBooks().add(new Book("D-Day,Can you be my wife", Category.Comic, "C1002", Status.available,
                "EK", "Yaoi Comic NC++"));
        shelf.getBooks().add(new Book("The Boss is a cat..", Category.Animal, "A1000", Status.available,
                "OPMaster", "Cat so cute~~"));
        shelf.getBooks().add(new Book("The Boss is a cat..", Category.Animal, "A1001", Status.wait,
                "OPMaster", "Cat so cute~~"));
    }

    public static void LibrarianList(UserData librarian) {
        librarian.getLibrarians().add(new Librarian("BadRose", "L", "12345", "0000", Position.Libralian));
        librarian.getLibrarians().add(new Librarian("Lady Z", "River", "L1", "0000", Position.Libralian));
    }

    public static void CustomerList(UserData customer) {
        customer.getCustomers().add(new Customer("Dragon", "D", "C1", "1111", Position.Customer));
        customer.getCustomers().add(new Customer("Olive", "M", "C2", "1111", Position.Customer));
    }

    public static void HistoriesData(HistoryList historyList) {
        LocalDate dateSet = LocalDate.of(2019, 06, 20);
        LocalDate dateSet1 = LocalDate.of(2019, 07, 1);
        historyList.getHistories().add(new History("N1006", "Lady Z",null,"Dragon",dateSet,dateSet.plusDays(7),0));
        historyList.getHistories().add(new History("H1099","Lady Z",null,"Olive",dateSet1,dateSet1.plusDays(7),0));
        historyList.getHistories().add(new History("A1001",null,null,"Dragon",dateSet,dateSet.plusDays(7),0));

    }
}
