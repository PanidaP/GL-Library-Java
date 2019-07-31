package GL.view;

import GL.Object.Book;
import GL.Enum.Category;
import GL.Enum.Status;
import GL.FunctionService;
import GL.service.LibraryService;

import java.util.Scanner;

public class LibrarianScreen {

    //>>>>>>>>>>>>>>>>>>>>>>>>>>> Login Display <<<<<<<<<<<<<<<<<<<<<<<<<<<//
    public String[] displayLogin() {
        System.out.println("Please enter Librarian ID : ");
        Scanner scan1 = new Scanner(System.in);
        String libId = scan1.nextLine();
        System.out.println("Please enter password : ");
        Scanner scan2 = new Scanner(System.in);
        String libPass = scan2.nextLine();
        String[] arrLogin = {libId,libPass};
        return arrLogin;
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>> Menu Display (L) <<<<<<<<<<<<<<<<<<<<<<<<<<<//
    public int displayLibrarianMenu(){
        Scanner want = new Scanner(System.in);
        System.out.println("\nWhat  do you want to do? (Please enter number of choice)");
        System.out.println("1 - Add Book\t2 - Remove\t\t3 - Search\n4 - Check\t\t5 - Sort\t\t" +
                "6 - Approve\n7 - Accept\t\t8 - Edit return 9 - History\n10 - Register\t11 - Back\t\t0 - Exit");
        int ans_2 = want.nextInt();
        return ans_2;
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>> Sort Display <<<<<<<<<<<<<<<<<<<<<<<<<<<//
    public void displaySort(){
        System.out.println("\nWhat  do you want to do? (Please enter number of choice)");
        System.out.println("1 - Sort by Name\t2 - Sort by Category\t3 - Sort by Code\n4 - Sort by Status");
        Scanner want3 = new Scanner(System.in);
        String ans = want3.nextLine();
        FunctionService.sort(ans);
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>> Add Display <<<<<<<<<<<<<<<<<<<<<<<<<<<//
    public void displayAdd(){
        FunctionService functionService = new FunctionService();
        Scanner sb = new Scanner(System.in);
        System.out.print("Please enter book name : ");
        String bName = sb.nextLine();
        System.out.println("Book name : " + bName);
        System.out.print("Please enter book category : ");
        String bCat = sb.nextLine();
        Category category = Category.valueOf(bCat);
        System.out.println("Book category : " + bCat);
        String codeCat = Category.valueOf(bCat).getCode();

        String[] arrAdd = {bName, String.valueOf(category),codeCat};
        functionService.addBook(arrAdd);
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>> Scan Register Display <<<<<<<<<<<<<<<<<<<<<<<<<<<//
    public  void scanRegis(){
        Scanner sb = new Scanner(System.in);
        System.out.print("Please enter your Firstname : ");
        String fName = sb.nextLine();
        System.out.print("Please enter your Lastname : ");
        String lName = sb.nextLine();
        System.out.print("Please enter ID : ");
        String id = sb.nextLine();
        String[] arr = {fName,lName,id};
        FunctionService.register(arr);
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>> Register Display <<<<<<<<<<<<<<<<<<<<<<<<<<<//
    public void displayRegis(int n){
        switch (n){
            case 1:
                System.out.println("Can not register by this name.");
                break;
            case 2:
                System.out.println("Please create new ID.");
                break;
        }
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>> Scan Accept Display <<<<<<<<<<<<<<<<<<<<<<<<<<<//
    public String scanAccept(){
        Scanner n = new Scanner(System.in);
        System.out.println("Please enter book code you want to accept : ");
        String code = n.nextLine();
        return code;
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>> Accept Display <<<<<<<<<<<<<<<<<<<<<<<<<<<//
    public void displayAccept(long late,int n){
        LibraryService service = LibraryService.getInstance();
        switch (n){
            case 1:
                System.out.println("Librarian accept book to return : " + service.getLogin().getFirstName());
                break;
            case 2:
                System.out.println("Return late for " + late + " days");
                System.out.println("Librarian accept book to return : " + service.getLogin().getFirstName());
                break;
            case 3:
                System.out.println("Do not have a book waiting for accept.");
                break;
        }
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>> Scan Approve Display <<<<<<<<<<<<<<<<<<<<<<<<<<<//
    public String scanApprove(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter book code you want to approve : ");
        String code = scanner.nextLine();
        return code;
    }


    //>>>>>>>>>>>>>>>>>>>>>>>>>>> Approve Display <<<<<<<<<<<<<<<<<<<<<<<<<<<//
    public void displayApprove(Book book){
        System.out.println("Book name " + book.getBookname() + " just borrowing.");
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>> Remove Display [C] <<<<<<<<<<<<<<<<<<<<<<<<<<<//*C = Controller
    public void removeDisplay(){
        Scanner dc = new Scanner(System.in);
        System.out.println("Please enter book code you want to remove :");
        String id = dc.nextLine();
        FunctionService.remove(id);
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>> Approve Display <<<<<<<<<<<<<<<<<<<<<<<<<<<//
    public void loginShow(String ans){
        switch (ans){
            case "1":
                System.out.println("<<<<<<Fail>>>>>>");
                break;
            case "2":
                System.out.println(">>>>>>Success<<<<<<");
                break;
            default:
                System.out.println("Please login again later.");
        }
    }


    //+++++++++++++++++++++++ Approve +++++++++++++++++++++++//

    public static void approve(){
        System.out.println("\nThere are the book waiting for approve.");
        Status id = Status.wait;
        FunctionService.approve(id);
    }

    //+++++++++++++++++++++++ Approve +++++++++++++++++++++++//

    public static void accept() {
        System.out.println("\nThere are the book waiting for accept.");
        Status id = Status.unaccept;
        FunctionService.accept(id);
    }

}
