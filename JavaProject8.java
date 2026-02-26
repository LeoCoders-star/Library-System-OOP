import java.util.Scanner;

class book {
    String title, author;
    double price;
    boolean isBorrowed;

    book(String i, String j, double k, boolean b) {
        title = i;
        author = j;
        price = k;
        isBorrowed = b;
    }

    void displayBook() {
        System.out.print("\nTitle: " + title);
        System.out.print("\nAuthor: " + author);
        System.out.print("\nPrice: RM" + price);
        
        if (isBorrowed == true) {
            System.out.print("\nStatus: Available");
        } else {
            System.out.print("\nStatus: Not Available");
        }

        System.out.print("\n");
    }
}

class library {

}

public class JavaProject8 {
    static int bookCount = 0;

    public static void addBook() {

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int startMenu;

        while (true) {
            System.out.print("\n==========================");
            System.out.print("\n   LIBRARY MANAGEMENT");
            System.out.print("\n==========================");
            System.out.print("\n1. Add Book");
            System.out.print("\n2. Display All Books");
            System.out.print("\n3. Borrow Book");
            System.out.print("\n4. Return Book");
            System.out.print("\n5. Exit");
            System.out.print("\n==========================");

            System.out.print("\nChoose Option: ");
            startMenu = input.nextInt();

            switch (startMenu) {
                case 1:
                    addBook();
                    break;
        
                default:
                    break;
            }
        }
    }
}
