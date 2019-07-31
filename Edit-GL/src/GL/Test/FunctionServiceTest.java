package GL.Test;

import GL.Object.Book;
import GL.Enum.Category;
import GL.Enum.Position;
import GL.Enum.Status;
import GL.Object.Customer;
import GL.service.LibraryService;
import org.junit.Assert;
import org.junit.Test;

import java.text.DecimalFormat;
import java.util.*;

public class FunctionServiceTest {

    @org.junit.Test
    public void searchName() {
        Book book = new Book();
        List<Book> bookList = new ArrayList<>();
        book.setBookname("a");
        book.setBookcategory(Category.History);
        book.setBookcode("H1002");
        book.setStatus(Status.available);
        bookList.add(book);

        Assert.assertEquals(bookList.get(0).getBookname(),"a");
        Assert.assertEquals(bookList.get(0).getBookcategory(),Category.History);
        Assert.assertEquals(bookList.get(0).getBookcode(),"H1002");
        Assert.assertEquals(bookList.get(0).getStatus(),Status.available);
    }


    @Test
    public void addBook() {
        Book book = new Book();
        List<Book> shelf = new  ArrayList();
        String bName = "a";
        String category1 = "History";
        String codeCat = Category.valueOf(category1).getCode();

        Category category = Category.valueOf(category1);

        int code = 0;
        for (int i = 0; i < shelf.size(); i++) {
            if (codeCat.equals(shelf.get(i).getBookcode().substring(0, 2))) {
                Collections.sort(shelf, ComparatorCode);
                for (Book book1 : shelf) {
                    code = Integer.parseInt(shelf.get(i).getBookcode().substring(2));
                    code++;
                }
            }
        }
        DecimalFormat decimalFormat = new DecimalFormat("000");
        String bookCode = codeCat + decimalFormat.format(code);

        book.setBookname(bName);
        book.setBookcategory(category);
        book.setBookcode(bookCode);
        book.setStatus(Status.available);
        book.setUuid(UUID.randomUUID());

        shelf.add(book);

        Assert.assertEquals(shelf.get(0).getBookname(),"a");
        Assert.assertEquals(shelf.get(0).getBookcategory(),Category.History);
        Assert.assertEquals(shelf.get(0).getBookcode(),"H1000");
        Assert.assertEquals(shelf.get(0).getStatus(),Status.available);
    }
    @Test
    public void register() {
        Customer customer = new Customer();
        List<Customer> customers = new ArrayList<>();
        String fName = "a";
        String lName = "a";
        String id = "a";

        boolean isValid = true;
        for (Customer customer1 : customers) {
            if (customer1.getFirstName().equals(fName) && customer1.getLastName().equals(lName)) {
                System.exit(0);
                isValid = false;
            } else if (customer1.getId().equals(id)) {
                register();
                isValid = false;
            }
        }

        if (isValid) {
            Customer customer2 = new Customer();
            customer2.setFirstName(fName);
            customer2.setLastName(lName);
            customer2.setId(id);
            customer2.setPosition(Position.Customer);
            customer2.setUserUuid(UUID.randomUUID());
            customers.add(customer2);
            Random random = new Random();
            int pass = random.nextInt(10000);
            customer2.setPass(String.valueOf(pass));
            System.out.println(customer2.getFirstName() + " " + customer2.getLastName() + " "
                    + customer2.getId() + " " + customer2.getPass() + " " + customer2.getPosition());
            System.out.println(customers);
            Assert.assertEquals(customer2.getFirstName(),"a");
            Assert.assertEquals(customer2.getLastName(),"a");
            Assert.assertEquals(customer2.getId(),"a");
            Assert.assertEquals(customer2.getPosition(),Position.Customer);
        }
    }
    @Test
    public void borrow() {
        List<Book> bookList = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();
        LibraryService service = LibraryService.getInstance();
        String code = "A100";
        boolean Set = true;
        Iterator<Book> iterator = bookList.iterator();
        while (iterator.hasNext()) { //Next is have an Object
            Book book = iterator.next(); //Next Object
            if (book.getBookcode().equals(code)) {
                if (book.getStatus() == Status.available) {
                    String fname = "s";
                    String lname = "s";
                    Set = true;
                    Iterator<Customer> iterator1 = customers.iterator();
                    while (iterator1.hasNext()) {
                        Customer customers1 = iterator1.next();
                        if (customers1.getFirstName().equals(fname) && customers1.getLastName().equals(lname)) {
                            book.setStatus(Status.wait);
                            service.setCustomerBorrow(customers1);
                            Assert.assertEquals(service.getCustomerBorrow(),"s");
                            Set = false;
                        } else if (customers1.getFirstName().equalsIgnoreCase(fname) && customers1.getFirstName().equalsIgnoreCase(lname)) {
                            Set = false;
                        }
                    }
                } else if (book.getStatus().equals(Status.unavailable) && book.getStatus().equals(Status.unaccept)
                        && book.getStatus().equals(Status.wait)) {
                }
            } else if (Set) {
                Set = false;
            }
        }
    }
    @Test
    public void remove() {
        Book book = new Book();
        List<Book> bookList = new ArrayList<>();
        book.setBookname("a");
        book.setBookcode("A100");
        book.setBookcategory(Category.Animal);
        bookList.add(book);
        book.setBookname("b");
        book.setBookcode("H102");
        book.setBookcategory(Category.History);
        bookList.add(book);
        String code = "A100";
        Iterator<Book> iterator = bookList.iterator();
        while (iterator.hasNext()) {
            Book next = iterator.next();
            if (next.getBookcode().equals(code)) {
                iterator.remove();
                System.out.println("Book code [" + next.getBookcode() + "] has been remove.");
            } else if (next.getBookcode().equalsIgnoreCase(code)) {
                iterator.remove();
                System.out.println("Book code [" + next.getBookcode() + "] has been remove.");
            }
            Assert.assertEquals(bookList.get(0).getBookcode(),"H102");
        }
    }






    public static Comparator<Book> ComparatorCode = new Comparator<Book>() {

        public int compare(Book b1, Book b2) {
            String code1 = b1.getBookcode().substring(2);
            String code2 = b2.getBookcode().substring(2);

            return code1.compareTo(code2);
        }
    };

    @Test
    public void editReturn() {

    }
}