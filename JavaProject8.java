
import java.util.Scanner;

// * This program has Shift Left Method use

// CLASS BOOK for only 1 book.
class book {

    String title, author;
    double price;
    boolean isBorrowed;

    book(String i, String j, double k, boolean b) {
        title = i;
        author = j;
        price = k;
        isBorrowed = false;
    }

    void displayBook() {
        System.out.print("\nTitle: " + title);
        System.out.print("\nAuthor: " + author);
        System.out.printf("\nPrice: RM%.2f", price);
        
        if (isBorrowed) {
            System.out.print("\nStatus: Borrowed");
        } else {
            System.out.print("\nStatus: Available");
        }

        System.out.print("\n");
    }
}

// CLASS LIBRARY for many books. There are include with all of manipulating logic system and save data array thing.
class library {

    book[] books = new book[100];
    int bookCount = 0;

    void addBook() {

        Scanner input = new Scanner(System.in);
        String bookTitle, bookAuthor;
        double bookPrice;

        System.out.print("\nEnter book title: ");
        bookTitle = input.nextLine();

        System.out.print("Enter author: ");
        bookAuthor = input.nextLine();

        while (true) {
            System.out.print("Enter price: ");
            bookPrice = input.nextDouble();
            // nextLine() only use if use before nextDouble or nextInt thing.
            input.nextLine();

            if (bookPrice > 0) {
                break;
            } else {
                System.out.print("\nInvalid! Price cannot be negative...");
                input.nextLine();
            }
        }

        books[bookCount] = new book(bookTitle, bookAuthor, bookPrice, false);

        System.out.print("\nBook added successfully!\n");

        bookCount++;
    }

    void displayAllBooks() {
        System.out.print("\n==========================");
        System.out.print("\n        BOOK LIST");
        System.out.print("\n==========================");
        System.out.print("\n");

        if (bookCount == 0) {
            System.out.print("\nNo books found!");
        } else {
            for (int i = 0; i < bookCount; i++) {
                System.out.print("\nBook " + ( i + 1 ) + ":");
                books[i].displayBook();
                System.out.print("\n--------------------------\n");
            }
        }
    }

    void borrowBook() {
        Scanner input = new Scanner(System.in);
        int indexBorrow;

        System.out.print("\n        BOOK LIST");
        System.out.print("\n--------------------------");
        for (int i = 0; i < bookCount; i++) {
            System.out.print("\n" + (i + 1) + ". " + books[i].title);
        }

        System.out.print("\nEnter book number to borrow: ");
        indexBorrow = input.nextInt();

        if (indexBorrow <= 0 || indexBorrow > bookCount) {
            System.out.print("\nInvalid book number!\n");
            return;
        }

        if (books[indexBorrow - 1].isBorrowed) {
            System.out.print("\nBook already borrow.\n");
        } else {
            books[indexBorrow - 1 ].isBorrowed = true;
            System.out.print("\nBook borrowed successfully!\n");
        }
    }

    void returnBook() {
        Scanner input = new Scanner(System.in);
        int indexBorrow;

        System.out.print("\n        BOOK LIST");
        System.out.print("\n--------------------------");

        for (int i = 0; i < bookCount; i++) {
            System.out.print("\n" + (i + 1) + ". " + books[i].title);
        }

        System.out.print("\n\nEnter book number to return: ");
        indexBorrow = input.nextInt();

        if (indexBorrow <= 0 || indexBorrow > bookCount) {
            System.out.print("\nInvalid book number!\n");
            return;
        } 

        if (books[indexBorrow - 1].isBorrowed) {
            books[indexBorrow - 1].isBorrowed = false;
            System.out.print("\nBook returned successfully!\n");

            for (int i = 0; i < bookCount; i++) {
                if ((indexBorrow - 1) == i) {
                   books[i].displayBook();
                }
            }

        } else {
            System.out.print("\nBook already available.\n");
        }

    }

    void deleteBook() {
        Scanner input = new Scanner(System.in);
        int indexDelete;

        System.out.print("\n==========================");
        System.out.print("\n      DELETE BOOK");
        System.out.print("\n==========================");
        System.out.print("\n");

        for (int i = 0; i < bookCount; i++) {
            System.out.print("\n" + (i + 1) + ". " + books[i].title);
        }

        System.out.print("\nEnter book number to delete: ");
        indexDelete = input.nextInt();

        if (indexDelete <= 0 || indexDelete > bookCount) {
            System.out.print("\nInvalid book number!");
            return;
        }

        // Delete Function -> Shift Left Method 

        for (int i = indexDelete - 1; i < (bookCount - 1); i++) {
            books[i] = books[i + 1];
        }

        System.out.print("\n\nBook delete successfully!");

        bookCount--;
    }
}

public class JavaProject8 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        library lib = new library();
        int startMenu;

        while (true) {
            System.out.print("\n==========================");
            System.out.print("\n   LIBRARY MANAGEMENT");
            System.out.print("\n==========================");
            System.out.print("\n1. Add Book");
            System.out.print("\n2. Display All Books");
            System.out.print("\n3. Borrow Book");
            System.out.print("\n4. Return Book");
            System.out.print("\n5. Delete Book");
            System.out.print("\n8. Exit");
            System.out.print("\n==========================");

            System.out.print("\nChoose Option: ");
            startMenu = input.nextInt();

            switch (startMenu) {
                case 1:
                    lib.addBook();
                    break;

                case 2:
                    lib.displayAllBooks();
                    break;

                case 3:
                    lib.borrowBook();
                    break;

                case 4:
                    lib.returnBook();
                    break;
                
                case 5: 
                    lib.deleteBook();
                    break;

                case 8:
                    System.out.print("\nThank you for using Library System!");
                    System.out.print("\nProgram terminated.");
                    System.exit(0);
        
                default:
                    break;
            }
        }
    }
}
