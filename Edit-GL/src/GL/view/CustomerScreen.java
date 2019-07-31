package GL.view;

import GL.Object.Book;
import GL.FunctionService;

import java.util.Scanner;

public class CustomerScreen {

    //>>>>>>>>>>>>>>>>>>>>>>>>>>> Menu Display [C] <<<<<<<<<<<<<<<<<<<<<<<<<<<//
    public int displayCustomerMenu(){
        Scanner want = new Scanner(System.in);
        System.out.println("\nWhat  do you want to do");
        System.out.println("1 - Search\t\t2 - Check\t\t3 - Borrow\n4 - Return\t\t5 - Edit return 6 - History\n7 - Back\t\t8 - Exit");
        int ans_2 = want.nextInt();
        return ans_2;
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>> Scan Borrow Display <<<<<<<<<<<<<<<<<<<<<<<<<<<//
    public String[] scanBorrow(){
        System.out.println("You can borrow this book.");
        Scanner n = new Scanner(System.in);
        System.out.println("Please enter your Firstname : ");
        String fname = n.nextLine();
        System.out.println("Please enter your Lastname : ");
        String lname = n.nextLine();
        String[] arr = {fname,lname};
        return arr;
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>> Borrow Display <<<<<<<<<<<<<<<<<<<<<<<<<<<//
    public void displayBorrow(Book book,int n,String fName,String lName){
        switch (n){
            case 1:
                System.out.println("Book name " + book.getBookname() + " just being borrowed by [" + fName + " " + lName + "]");
                System.out.println("Please wait an approve form the librarian.");
                break;
            case 2:
                System.out.println("You are not our customer.");
                break;
            case 3:
                System.out.println("You can not borrow this book.");
                break;
        }
    }

    //+++++++++++++++++++++++ Borrow +++++++++++++++++++++++//
    public static void borrow() {
        Scanner dc = new Scanner(System.in);
        System.out.println("\nPlease enter Book code to borrow : ");
        String id = dc.nextLine();
        FunctionService.borrow(id);
    }
    //+++++++++++++++++++++++ Return +++++++++++++++++++++++//

    public static void returnBook() {
        Scanner dc = new Scanner(System.in);
        System.out.println("\nPlease enter Book code to return : ");
        String id = dc.nextLine();
        FunctionService.returnBook(id);
    }

}
