package GL.view;

import GL.Object.Book;
import GL.FunctionService;
import GL.Object.History;
import GL.service.LibraryService;

import java.util.Scanner;

public class AllUserScreen {

    //>>>>>>>>>>>>>>>>>>>>>>>>>>> Home Display <<<<<<<<<<<<<<<<<<<<<<<<<<<//
    public void display() {
        Scanner pos = new Scanner(System.in);
        System.out.println("Please enter your position");
        System.out.println("1 - Administrator");
        System.out.println("2 - Employee");
        String ans = pos.nextLine();
        FunctionService.menu(ans);
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>> Search Display <<<<<<<<<<<<<<<<<<<<<<<<<<<//
    public void displaySearch() {
        System.out.println("\nWhat  do you want to do? (Please enter number of choice)");
        System.out.println("1 - Search by Name\t2 - Search by Category\t3 - Search by Code\n4 - Search by Status");
        Scanner want1 = new Scanner(System.in);
        String ans = want1.nextLine();
        FunctionService.search(ans);
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>> Check Display <<<<<<<<<<<<<<<<<<<<<<<<<<<//
    public void displayCheck() {
        System.out.println("\nWhat  do you want to do? (Please enter number of choice)");
        System.out.println("1 - Check by Name\t2 - Check by Category\t3 - Check by Code");
        Scanner want2 = new Scanner(System.in);
        String ans = want2.nextLine();
        FunctionService.check(ans);
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Print Check Display <<<<<<<<<<<<<<<<<<<<<<<<<<<<<//
    public void printCheck(Book book, int n) {
        switch (n) {
            case 1:
                System.out.println("==========================");
                System.out.println("Book Name : " + book.getBookname());
                System.out.println("Book Status : " + book.getStatus());
                System.out.println("==========================");
                break;
            case 2:
                System.out.println("==========================");
                System.out.println("Book Name : " + book.getBookname());
                System.out.println("Book Category : " + book.getBookcategory());
                System.out.println("Book Status : " + book.getStatus());
                System.out.println("==========================");
                break;
            case 3:
                System.out.println("==========================");
                System.out.println("Book Name : " + book.getBookname());
                System.out.println("Book Code : " + book.getBookcode());
                System.out.println("Book Status : " + book.getStatus());
                System.out.println("==========================");
                break;
        }


    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>> Show History <<<<<<<<<<<<<<<<<<<<<<<<<<<//
    public void showHistory() {
        LibraryService service = LibraryService.getInstance();
        for (History history : service.getHistoryList().getHistories()
        ) {
            System.out.println("==========================");
            System.out.println("Book Code    : " + history.getBookcode());
            System.out.println("Day Borrow   : " + history.getBorrow());
            System.out.println("Day Return   : " + history.getBack());
            System.out.println("Borrow by    : " + history.getCustomer());
            System.out.println("Approve by   : " + history.getLibrarianApprove());
            System.out.println("Accept by    : " + history.getLibrarianAccect());
            System.out.println("==========================");
        }

    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Print <<<<<<<<<<<<<<<<<<<<<<<<<<<<<//
    public void Print(Book book) {
        System.out.println("==========================");
        System.out.println("Book Name   : " + book.getBookname());
        System.out.println("Book Category   : " + book.getBookcategory());
        System.out.println("Book Code   : " + book.getBookcode());
        System.out.println("Book Status : " + book.getStatus());
        System.out.println("==========================");
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Print <<<<<<<<<<<<<<<<<<<<<<<<<<<<<//
    public void noBook() {
        System.out.println("'Sorry your book is not exist to my Grouplease Library");
    }

    public void thanks() {
        System.out.println("Thank you.");
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Print All Book <<<<<<<<<<<<<<<<<<<<<<<<<<<<<//
    public void allBook() {
        LibraryService service = LibraryService.getInstance();
        System.out.println("=====================");
        for (int i = 0; i < service.getShelf().getBooks().size(); i++) {
            System.out.println(service.getShelf().getBooks().get(i));
        }
        System.out.println("=====================");
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Scan Edit <<<<<<<<<<<<<<<<<<<<<<<<<<<<<//
    public int scanEdit(History history) {

        System.out.println("Date to return : " + history.getBack());
        Scanner n1 = new Scanner(System.in);
        System.out.println("How many days you want to extend : ");
        int plusDay = n1.nextInt();

        return plusDay;
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Edit Display <<<<<<<<<<<<<<<<<<<<<<<<<<<<<//
    public void displayEdit(Book book, History history, int plusDay, int n) {
        switch (n) {
            case 1:
                System.out.println(book.getBookname() + " is extend return date to " + history.getBack().plusDays(plusDay));
                break;
            case 2:
                System.out.println("Can not extend date because it over date to return. ");
                break;
            case 3:
                System.out.println("+++++> Done <+++++");
                break;
        }
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Search Display [C] <<<<<<<<<<<<<<<<<<<<<<<<<<<<<// *C = Conttroller
    public String[] searchDisplay(int n){
        String id2 = "";
        String id3 = "";
        String id4 = "";
        String id5 = "";
        switch (n){
            case 1:
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please enter book name : ");
                id2 = scanner.nextLine();
                break;
            case 2:
                Scanner n2 = new Scanner(System.in);
                System.out.println("Please enter book category : ");
                id3 = n2.nextLine();
                break;
            case 3:
                Scanner n3 = new Scanner(System.in);
                System.out.println("Please enter book code : ");
                id4 = n3.nextLine();
                break;
            case 4:
                Scanner n4 = new Scanner(System.in);
                System.out.println("Please enter book status : ");
                id5 = n4.nextLine();
            break;
        }
        String[] arr ={id2,id3,id4,id5};
        return arr;
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Check Display [C] <<<<<<<<<<<<<<<<<<<<<<<<<<<<<// *C = Conttroller
    public String[] checkDisplay(int n){
        String id2 = "";
        String id3 = "";
        String id4 = "";
        switch (n){
            case 1:
                Scanner scanner = new Scanner(System.in);
                System.out.println("\nPlease Enter the book you want to check : ");
                id2 = scanner.nextLine();
                break;
            case 2:
                Scanner n2 = new Scanner(System.in);
                System.out.println("Please enter book category : ");
                id3 = n2.nextLine();
                break;
            case 3:
                Scanner n3 = new Scanner(System.in);
                System.out.println("Please enter book code : ");
                id4 = n3.nextLine();
                break;
        }
        String[] arr ={id2,id3,id4};
        return arr;
    }
    //+++++++++++++++++++++++ Edit +++++++++++++++++++++++//
    public static void edit(){
        Scanner dc = new Scanner(System.in);
        System.out.println("\nPlease enter book code you want to edit date for borrow : ");
        String id = dc.nextLine();
        FunctionService.editReturn(id);
    }

}
