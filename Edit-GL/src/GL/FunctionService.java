package GL;

import GL.Object.Book;
import GL.Enum.Category;
import GL.Enum.Position;
import GL.Enum.Status;
import GL.Object.History;
import GL.Object.Customer;
import GL.Object.Librarian;
import GL.service.LibraryService;
import GL.view.AllUserScreen;
import GL.view.CustomerScreen;
import GL.view.LibrarianScreen;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class FunctionService {

    //++++++++++++++++++++++++ Menu ++++++++++++++++++++++++//

    public static void menu(String ans) {
        //************************* Login Section *************************//
        LibraryService service = LibraryService.getInstance();
        LibrarianScreen librarianScreen = new LibrarianScreen();
        if (ans.equals("1")) {
            //************************* Administrator Section *************************//
            String[] arrLogin = librarianScreen.displayLogin();
            Librarian loggedInLibrarian = null;
            for (Librarian librarian : service.getLibrarians().getLibrarians()) {
                if (librarian.getId().equals(arrLogin[0])) {
                    if (librarian.getPass().equals(arrLogin[1])) {
                        loggedInLibrarian = librarian;
                    }
                }
            }
            if (loggedInLibrarian == null) {
                librarianScreen.loginShow("1");
            } else {
                service.setLogin(loggedInLibrarian);
                libralianMenu();
            }
        } else if (ans.equals("2")) {
            //************************* Employee Section *************************//
            customerMenu();
        } else {
            librarianScreen.loginShow("");
        }
    }

    //++++++++++++++++++++++++ Librarian Menu ++++++++++++++++++++++++//

    public static void libralianMenu() {
        boolean loop = false;
        LibrarianScreen librarianScreen = new LibrarianScreen();
        AllUserScreen allUserScreen = new AllUserScreen();
        librarianScreen.loginShow("2");
        loop = true;
        do {
            int ans_2 = librarianScreen.displayLibrarianMenu();
            switch (ans_2) {
                case 1:
                    //************************* Add Section *************************//
                    librarianScreen.displayAdd();
                    break;
                case 2:
                    //************************* Remove Section *************************//
                    librarianScreen.removeDisplay();
                    break;
                case 3:
                    //************************* Search Section *************************//
                    allUserScreen.displaySearch();
                    break;
                case 4:
                    //************************* Check Section *************************//
                    allUserScreen.displayCheck();
                    break;
                case 5:
                    //************************* Sort Section *************************//
                    librarianScreen.displaySort();
                    break;
                case 6:
                    //************************* Approve Section *************************//
                    librarianScreen.approve();
                    break;
                case 7:
                    //************************* Accept Section *************************//
                    librarianScreen.accept();
                    break;
                case 8:
                    //************************* Edit Date Section *************************//
                    allUserScreen.edit();
                    break;
                case 9:
                    //************************* History Section *************************//
                    allUserScreen.showHistory();
                    break;
                case 10:
                    //************************* Register Section *************************//
                    librarianScreen.scanRegis();
                    break;
                case 11:
                    //************************* Back Section *************************//
//                    menu();
                    allUserScreen.display();
                    break;
                case 0:
                    //************************* Terminate Section *************************//
                    allUserScreen.thanks();
                    loop = false;
                    break;
                default:
                    throw new IllegalStateException(String.valueOf(ans_2));
            }
        }
        while (loop);
    }

    //+++++++++++++++++++++++ Customer Menu +++++++++++++++++++++++//

    public static void customerMenu() {
        CustomerScreen customerScreen = new CustomerScreen();
        AllUserScreen allUserScreen = new AllUserScreen();
        boolean loop = true;
        do {
            int ans_2 = customerScreen.displayCustomerMenu();
            switch (ans_2) {
                case 1:
                    //************************* Search Section *************************//
                    allUserScreen.displaySearch();
                    break;
                case 2:
                    //************************* Check Section *************************//
                    allUserScreen.displayCheck();
                    break;
                case 3:
                    //************************* Borrow Section *************************//
                    customerScreen.borrow();
                    break;
                case 4:
                    //************************* Return Section *************************//
                    customerScreen.returnBook();
                    break;
                case 5:
                    //************************* Edit Return Section *************************//
                    allUserScreen.edit();
                    break;
                case 6:
                    //************************* History Section *************************//
                    allUserScreen.showHistory();
                    break;
                case 7:
                    //************************* Back Section *************************//
//                    menu();
                    allUserScreen.display();
                    break;
                case 8:
                    //************************* Terminate Section *************************//
                    allUserScreen.thanks();
                    loop = false;
                    break;
                default:
                    throw new IllegalStateException(String.valueOf(ans_2));
            }
        } while (loop);
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Add <<<<<<<<<<<<<<<<<<<<<<<<<<<<<//
    public static void addBook(String[] arrAdd) {
        LibraryService service = LibraryService.getInstance();
        AllUserScreen allUserScreen = new AllUserScreen();
        Book book_add = new Book();
        String bName = arrAdd[0];
        String category1 = arrAdd[1];
        String codeCat = arrAdd[2];

        Category category = Category.valueOf(category1);

        int code = 0;
        for (int i = 0; i < service.getShelf().getBooks().size(); i++) {
            if (codeCat.equals(service.getShelf().getBooks().get(i).getBookcode().substring(0, 2))) {
                Collections.sort(service.getShelf().getBooks(), bookComparator);
                for (Book book : service.getShelf().getBooks()) {
                    code = Integer.parseInt(service.getShelf().getBooks().get(i).getBookcode().substring(2));
                    code++;
                }
            }
        }
        DecimalFormat decimalFormat = new DecimalFormat("000");
        String bookCode = codeCat + decimalFormat.format(code);

        book_add.setBookname(bName);
        book_add.setBookcategory(category);
        book_add.setBookcode(bookCode);
        book_add.setStatus(Status.available);
        book_add.setUuid(UUID.randomUUID());

        service.getShelf().getBooks().add(book_add);

        allUserScreen.allBook();

    }

    //+++++++++++++++++++++++ Sort +++++++++++++++++++++++//

    public static void sort(String ans) {
        LibraryService service = LibraryService.getInstance();
        switch (ans) {
            case "1":
                //************************* by Name *************************//
                Collections.sort(service.getShelf().getBooks(), comparatorName);
                for (Book book : service.getShelf().getBooks()) {
                    System.out.println(book);
                }
                break;
            case "2":
                //************************* by Category *************************//
                Collections.sort(service.getShelf().getBooks(), comparatorCat);
                for (Book book : service.getShelf().getBooks()) {
                    System.out.println(book);
                }
                break;
            case "3":
                //************************* by Code *************************//
                Collections.sort(service.getShelf().getBooks(), comparatorCode);
                for (Book book : service.getShelf().getBooks()) {
                    System.out.println(book);
                }
                break;
            case "4":
                //************************* by Status *************************//
                Collections.sort(service.getShelf().getBooks(), comparatorStat);
                for (Book book : service.getShelf().getBooks()) {
                    System.out.println(book);
                }
                break;
        }
    }

    //**************************Sort by Name**************************//
    public static Comparator<Book> comparatorName = new Comparator<Book>() {
        public int compare(Book b1, Book b2) {
            String BookName1 = b1.getBookname().toUpperCase();
            String BookName2 = b2.getBookname().toUpperCase();
            return BookName1.compareTo(BookName2);
        }
    };
    //**************************Sort by Category**************************//
    public static Comparator<Book> comparatorCat = new Comparator<Book>() {
        public int compare(Book b1, Book b2) {
            return b1.getBookcategory().toString().compareTo(b2.getBookcategory().toString());
        }
    };
    //**************************Sort by Code**************************//
    public static Comparator<Book> comparatorCode = new Comparator<Book>() {
        public int compare(Book b1, Book b2) {
            String BookCode1 = b1.getBookcode().toUpperCase();
            String BookCode2 = b2.getBookcode().toUpperCase();
            return BookCode1.compareTo(BookCode2);
        }
    };
    //**************************Sort by Status**************************//
    public static Comparator<Book> comparatorStat = new Comparator<Book>() {

        public int compare(Book b1, Book b2) {
            String BookStat1 = b1.getStatus().toString();
            String BookStat2 = b2.getStatus().toString();
            return BookStat1.compareTo(BookStat2);
        }
    };

    //+++++++++++++++++++++++ Search +++++++++++++++++++++++//
    public static void search(String ans) {
        LibraryService service = LibraryService.getInstance();
        AllUserScreen allUserScreen = new AllUserScreen();
        switch (ans) {
            case "1":
                //**************************Search by Name**************************//
                String[] arr = allUserScreen.searchDisplay(1);
                Iterator<Book> iterator = service.getShelf().getBooks().iterator();
                while (iterator.hasNext()) {
                    Book book = iterator.next();
                    if (book.getBookname().equalsIgnoreCase(arr[0])) {
                        allUserScreen.Print(book);
                    }
                }
                break;
            case "2":
                //**************************Search by Category**************************//
                String[] arr1 = allUserScreen.searchDisplay(2);
                for (Book book : service.getShelf().getBooks()) {
                    if (book.getBookcategory().equals(Category.valueOf(arr1[1]))) {
                        allUserScreen.Print(book);
                    }
                }
                break;
            case "3":
                //**************************Search by Code**************************//
                String[] arr2 = allUserScreen.searchDisplay(3);
                Iterator<Book> iterator1 = service.getShelf().getBooks().iterator();
                while (iterator1.hasNext()) {
                    Book book = iterator1.next();
                    if (book.getBookcode().equalsIgnoreCase(arr2[2])) {
                        allUserScreen.Print(book);
                    }
                }
                break;
            case "4":
                //**************************Search by Code**************************//
                String[] arr3 = allUserScreen.searchDisplay(4);
                Iterator<Book> iterator2 = service.getShelf().getBooks().iterator();
                while (iterator2.hasNext()) {
                    Book book = iterator2.next();
                    if (book.getStatus().equals(Status.valueOf(arr3[3]))) {
                        allUserScreen.Print(book);
                    }
                }
                break;

        }
    }

    //+++++++++++++++++++++++ Check +++++++++++++++++++++++//
    public static void check(String ans) {
        LibraryService service = LibraryService.getInstance();
        AllUserScreen allUserScreen = new AllUserScreen();
        switch (ans) {
            case "1":
                //**************************Check by Name**************************//
                String[] arr = allUserScreen.checkDisplay(1);
                Iterator<Book> iterator = service.getShelf().getBooks().iterator();
                while (iterator.hasNext()) {
                    Book book = iterator.next();
                    if (book.getBookname().equalsIgnoreCase(arr[0])) {
                        allUserScreen.printCheck(book, 1);
                    }
                }
                break;
            case "2":
                //**************************Check by Category**************************//
                String[] arr2 = allUserScreen.checkDisplay(2);
                Iterator<Book> iterator1 = service.getShelf().getBooks().iterator();
                while (iterator1.hasNext()) {
                    Book book = iterator1.next();
                    if (book.getBookcategory().equals(Category.valueOf(arr2[1]))) {
                        allUserScreen.printCheck(book, 2);
                    }
                }
                break;
            case "3":
                //**************************Check by Code**************************//
                String[] arr3 = allUserScreen.checkDisplay(3);
                Iterator<Book> iterator3 = service.getShelf().getBooks().iterator();
                while (iterator3.hasNext()) {
                    Book book = iterator3.next();
                    if (book.getBookcode().equalsIgnoreCase(arr3[2])) {
                        allUserScreen.printCheck(book, 3);
                    }
                }
                break;
        }
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Remove <<<<<<<<<<<<<<<<<<<<<<<<<<<<<//
    public static void remove(String code) {
        LibraryService service = LibraryService.getInstance();
        AllUserScreen allUserScreen = new AllUserScreen();
        Iterator<Book> iterator = service.getShelf().getBooks().iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getBookcode().equals(code)) {
                iterator.remove();
                System.out.println("Book code [" + book.getBookcode() + "] has been remove.");
            } else if (book.getBookcode().equalsIgnoreCase(code)) {
                allUserScreen.noBook();
            }

        }
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Borrow <<<<<<<<<<<<<<<<<<<<<<<<<<<<<//
    public static void borrow(String code) {
        LibraryService service = LibraryService.getInstance();
        AllUserScreen allUserScreen = new AllUserScreen();
        CustomerScreen customerScreen = new CustomerScreen();
        String fName = null;
        String lName = null;
        boolean Set = true;
        Iterator<Book> iterator = service.getShelf().getBooks().iterator();
        while (iterator.hasNext()) { //Next is have an Object
            Book book = iterator.next(); //Next Object
            if (book.getBookcode().equals(code)) {
                allUserScreen.Print(book);
                if (book.getStatus() == Status.available) {
                    String[] arr = customerScreen.scanBorrow();
                    String fname = arr[0];
                    String lname = arr[1];
                    Set = true;
                    Iterator<Customer> iterator1 = service.getCustomers().getCustomers().iterator();
                    while (iterator1.hasNext()) {
                        Customer customers = iterator1.next();
                        if (customers.getFirstName().equals(fname) && customers.getLastName().equals(lname)) {
                            book.setStatus(Status.wait);
                            service.setCustomerBorrow(customers);
                            customerScreen.displayBorrow(book, 1, fname, lname);
                            Set = false;
                        } else if (customers.getFirstName().equalsIgnoreCase(fname) && customers.getFirstName().equalsIgnoreCase(lname)) {
                            customerScreen.displayBorrow(book, 2, fname, lname);
                            Set = false;
                        }
                    }
                } else if (book.getStatus().equals(Status.unavailable) && book.getStatus().equals(Status.unaccept)
                        && book.getStatus().equals(Status.wait)) {
                    customerScreen.displayBorrow(book, 3, fName, lName);
                }
            } else if (Set) {
                Set = false;
            }
        }
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Approve <<<<<<<<<<<<<<<<<<<<<<<<<<<<<//
    public static void approve(Status status) {

        LibraryService service = LibraryService.getInstance();
        AllUserScreen allUserScreen = new AllUserScreen();
        LibrarianScreen librarianScreen = new LibrarianScreen();
        LocalDate today = LocalDate.now();
        Iterator<Book> iterator = service.getShelf().getBooks().iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getStatus().equals(status)) {
                allUserScreen.Print(book);
                String code = librarianScreen.scanApprove();
                if (book.getBookcode().equals(code)) {
                    History history = new History();
                    book.setStatus(Status.unavailable);
                    history.setCustomer(service.getCustomerBorrow().getFirstName());
                    history.setBorrow(today);
                    history.setBack(today.plusDays(7));
                    history.setBookcode(book.getBookcode());
                    history.setLibrarianApprove(service.getLogin().getFirstName());
                    service.getHistoryList().getHistories().add(history);
                    librarianScreen.displayApprove(book);
                }

            }
        }
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Return <<<<<<<<<<<<<<<<<<<<<<<<<<<<<//
    public static void returnBook(String id) {
        LibraryService service = LibraryService.getInstance();
        AllUserScreen allUserScreen = new AllUserScreen();
        Iterator<Book> iterator = service.getShelf().getBooks().iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getBookcode().equals(id)) {
                if (book.getStatus() == Status.unavailable) {
                    book.setStatus(Status.unaccept);
                }
            }
        }

    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Accept <<<<<<<<<<<<<<<<<<<<<<<<<<<<<//
    public static void accept(Status status) {
        LibraryService service = LibraryService.getInstance();
        LocalDate today = LocalDate.now();
        AllUserScreen allUserScreen = new AllUserScreen();
        LibrarianScreen librarianScreen = new LibrarianScreen();
        Iterator<Book> iterator = service.getShelf().getBooks().iterator();
        long late = 0;
        try {
            while (iterator.hasNext()) {
                Book book = iterator.next();
                if (book.getStatus().equals(status)) {
                    allUserScreen.Print(book);
                    String code = librarianScreen.scanAccept();
                    if (book.getBookcode().equals(code)) {
                        boolean check = true;
                        for (History history : service.getHistoryList().getHistories()) {
                            History history1 = new History();
                            if (history.getBookcode().equals(code)) {
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                                LocalDate date1 = LocalDate.parse(history.getBorrow().toString(), formatter);
                                LocalDate date2 = LocalDate.parse(today.toString(), formatter);
                                LocalDate date3 = LocalDate.parse(history.getBack().toString(), formatter);
                                long returnDays = ChronoUnit.DAYS.between(date1, date2);
                                long mustReturn = ChronoUnit.DAYS.between(date1, date3);
                                if (returnDays <= mustReturn) {
                                    book.setStatus(Status.available);
                                    history1.setBookcode(book.getBookcode());
                                    history1.setBorrow(history.getBorrow());
                                    history1.setOverReturn(0);
                                    history1.setBack(today);
                                    history1.setLibrarianApprove(history.getLibrarianApprove());
                                    history1.setLibrarianAccect(service.getLogin().getFirstName());
                                    history1.setCustomer(history.getCustomer());
                                    service.getShelf().getBooks().add(book);
                                    service.getHistoryList().getHistories().add(history1);
                                    allUserScreen.Print(book);
                                    librarianScreen.displayAccept(late, 1);
                                } else if (returnDays > mustReturn) {
                                    late = returnDays - mustReturn;
                                    book.setStatus(Status.available);
                                    history1.setOverReturn(late);
                                    history1.setBookcode(book.getBookcode());
                                    history1.setBorrow(history.getBorrow());
                                    history1.setOverReturn(0);
                                    history1.setBack(today);
                                    history1.setLibrarianApprove(history.getLibrarianApprove());
                                    history1.setLibrarianAccect(service.getLogin().getFirstName());
                                    history1.setCustomer(history.getCustomer());
                                    service.getShelf().getBooks().add(book);
                                    service.getHistoryList().getHistories().add(history1);
                                    librarianScreen.displayAccept(late, 2);
                                }
                                check = false;
                            }
                        }
                        if (check) {
                            History history = new History();
                            history.setBack(LocalDate.now());
                            service.getHistoryList().getHistories().add(history);
                        }
                    }
                } else if (book.getStatus().equals(Status.unavailable) && book.getStatus().equals(Status.wait)
                        && book.getStatus().equals(Status.available)) {
                    librarianScreen.displayAccept(late, 3);
                }
            }
        } catch (ConcurrentModificationException e) {
        }
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Edit Date <<<<<<<<<<<<<<<<<<<<<<<<<<<<<//
    public static void editReturn(String code) {
        LibraryService service = LibraryService.getInstance();
        AllUserScreen allUserScreen = new AllUserScreen();
        boolean check = true;
        Iterator<Book> iterator = service.getShelf().getBooks().iterator();
        int plusDay = 0;
        while (iterator.hasNext()) {
            Book book = iterator.next();
            try {
                for (History history : service.getHistoryList().getHistories()) {
                    if (history.getBookcode().equals(code) && book.getBookcode().equals(code)) {
                        check = true;
                        if (book.getStatus().equals(Status.unavailable)) {
                            check = true;
                            allUserScreen.Print(book);
                            plusDay = allUserScreen.scanEdit(history);
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                            LocalDate date2 = LocalDate.parse(history.getBorrow().plusDays(15).toString(), formatter);
                            LocalDate date3 = LocalDate.parse(history.getBack().toString(), formatter);
                            long extendDays = ChronoUnit.DAYS.between(date3, date2);
                            if (plusDay <= extendDays) {
                                allUserScreen.displayEdit(book, history, plusDay, 1);
                                history.setBack(history.getBack().plusDays(plusDay));
                                service.getHistoryList().getHistories().add(history);

                            } else {
                                allUserScreen.displayEdit(null, null, 0, 2);
                                continue;
                            }
                        } else if (book.getStatus().equals(Status.unaccept) || book.getStatus().equals(Status.wait)
                                || book.getStatus().equals(Status.available)) {
                            check = false;
                            continue;
                        }
                    }
                    check = false;
                }
            } catch (ConcurrentModificationException e) {

            }
        }
        if (!check) {
            allUserScreen.displayEdit(null, null, 0, 3);
        }
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>> sort Code for Make code <<<<<<<<<<<<<<<<<<<<<<<<<<<//
    public static Comparator<Book> bookComparator = new Comparator<Book>() {
        public int compare(Book b1, Book b2) {
            String code1 = b1.getBookcode().substring(2);
            String code2 = b2.getBookcode().substring(2);
            return code1.compareTo(code2);
        }
    };

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Register <<<<<<<<<<<<<<<<<<<<<<<<<<<<<//
    public static void register(String[] arr) {
        LibraryService service = LibraryService.getInstance();
        LibrarianScreen librarianScreen = new LibrarianScreen();
        String fName = arr[0];
        String lName = arr[1];
        String id = arr[2];

        boolean isValid = true;
        for (Customer customer1 : service.getCustomers().getCustomers()) {
            if (customer1.getFirstName().equals(fName) && customer1.getLastName().equals(lName)) {
                librarianScreen.displayRegis(1);
                System.exit(0);
                isValid = false;
            } else if (customer1.getId().equals(id)) {
                librarianScreen.displayRegis(2);
                librarianScreen.scanRegis();
                isValid = false;
            }
        }

        if (isValid) {
            Customer customer = new Customer();
            customer.setFirstName(fName);
            customer.setLastName(lName);
            customer.setId(id);
            customer.setPosition(Position.Customer);
            customer.setUserUuid(UUID.randomUUID());
            service.getCustomers().getCustomers().add(customer);
            Random random = new Random();
            int pass = random.nextInt(10000);
            customer.setPass(String.valueOf(pass));
        }
    }

}

