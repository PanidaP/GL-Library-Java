package GL;


import GL.Book.Shelf;
import GL.History.HistoryList;
import GL.User.UserData;
import GL.service.LibraryService;
import GL.view.AllUserScreen;

public class Main {

    public static void main(String[] args) {

        LibraryService service = LibraryService.getInstance();

        UserData librarians = new UserData();
        TestData.LibrarianList(librarians);
        service.setLibrarians(librarians);

        UserData customers = new UserData();
        TestData.CustomerList(customers);
        service.setCustomers(customers);

        Shelf shelf = new Shelf();
        TestData.BookList(shelf);
        service.setShelf(shelf);

        HistoryList historyList = new HistoryList();
        TestData.HistoriesData(historyList);
        service.setHistoryList(historyList);

        AllUserScreen allUserScreen = new AllUserScreen();
        allUserScreen.display();

    }
}
