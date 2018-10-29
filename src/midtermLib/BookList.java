package midtermLib;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class BookList {

    //Void method containing 12 books that will be stored in ArrayList<Book> if original txt file is empty
    public static void defBookList(ArrayList <Book> books) {
        books.add (new Book("Me Talk Pretty One Day" , "David Sedaris"));          
        books.add (new Book("To Kill A Mocking Bird" , "Harper Lee"));             
        books.add (new Book( "A Heartbreaking Work Of Stagering Genius", "Dave Eggers"));                   
        books.add (new Book("The Road" , "Cormac McCarthy"));               
        books.add (new Book("Seabiscuit", "Laura Hillenbrand"));              
        books.add (new Book("Lonesome Dave", "Larry McMurtry"));             
        books.add (new Book("Watchrs", "Dean Koontz"));               
        books.add (new Book("IT" , "Steven King"));               
        books.add (new Book("Jaws", "Peter Benchly"));              
        books.add (new Book("The Side Of Paradise", "F Scott Fitzgerald"));               
        books.add (new Book("Do Androids Dream of Electric Sheep", "Philip K. Dick"));              
        books.add (new Book("The Zombie Survival Guide", "Max Brooks"));              
    }

    public static void displayBooks(ArrayList <Book> books) { //taking in arraylist from library main as parameter
        System.out.println ("Here are the list of books: ");
        for (int i = 0; i < books.size (); i++) {
            Book b = books.get ( i );
            System.out.println ( "Book " + (i + 1) + " - Status : " + b.getBookStatus ()
                    + " - Due Date : " + b.getDueDate ());
            System.out.println ( "Title : " + b.getTitle () );
            System.out.println ( "Author : " + b.getAuthor () );
            System.out.println ("----------------------------------------------------------------------------");
        }
    }

    //Method to search book by title
    public static void searchBookByTitle(ArrayList <Book> books, Scanner scan) {
        System.out.println ( "Enter in the book's title : " );
        String title = scan.nextLine ();
        searchByString ( books, title, true, scan );
    }

    //Void method to search book by Author
    public static void searchBookByAuthor(ArrayList <Book> books, Scanner scan) {
        boolean found = false;
        System.out.println ( "Enter the author's name : " );
        String author = scan.nextLine ();
        searchByString ( books, author, false, scan );
    }

    private static void searchByString(ArrayList <Book> books, String keyword, boolean searchByTitle, Scanner scan) {
        boolean found = false;
        String desiredMatch = "";
        char userChar = 'g';

        for (Book temp : books) {
            if (searchByTitle)
                desiredMatch = temp.getTitle ().toLowerCase ();
            else
                desiredMatch = temp.getAuthor ().toLowerCase ();
            if (desiredMatch.contains ( keyword.toLowerCase () )) {
                found = true;
                System.out.println (temp);
                if (temp.getBookStatus () != Book.STATUS.BookNotAvailable) {
                    System.out.println ( "Would you like to check out this book (y/n)?" );
                    userChar = scan.nextLine ().charAt ( 0 );
                    if (userChar == 'y' || userChar == 'Y') {
                        CheckOutBook ( temp );
                    }
                }
            }
        }
        if (!found) System.out.println ("Did not find the book.");
    }

    //Void method to select book
    public static Book SelectBook(ArrayList <Book> books, Scanner scan) {
        int bookSel;
        //the book returned to user;
        Book retBook = null;

        do {
            bookSel = scan.nextInt ();
        } while (bookSel < 1 || bookSel > books.size ());
        retBook = books.get ( bookSel - 1 );
        return retBook;
    }

    //Void method to check out book (update STATUS to BookNotAvailable).
    public static void CheckOutBook(Book bookWanted) {
        if (bookWanted.getBookStatus () == Book.STATUS.BookNotAvailable) {
            System.out.println ("Sorry \"" + bookWanted.getTitle () + "\" by \"" + bookWanted.getAuthor () + "\" was already checked out." );
            return;
        } else {
            updateDueDate (bookWanted);
            bookWanted.setBookStatus ( Book.STATUS.BookNotAvailable );
            System.out.println ("You have checked \"" + bookWanted.getTitle () + "\" by \"" + bookWanted.getAuthor () + "." +
                    "The due date is " + bookWanted.getDueDate () + ".");
        }
    }

    public static void ReturnBook(Book bookWanted) {
        if (bookWanted.getBookStatus () == Book.STATUS.BookAvailable) {
            System.out.println ("\"" + bookWanted.getTitle () + "\" by \"" + bookWanted.getAuthor () + "\" is not checked out.");
            return;
        } else {
            bookWanted.setBookStatus (Book.STATUS.BookAvailable);
            System.out.println ("Thank you for returning \"" + bookWanted.getTitle () + "\" by \"" + bookWanted.getAuthor () + "\".");
        }
    }

    public static void RemoveBookFromInventory(ArrayList <Book> books, Scanner scan) {
        System.out.println ("Please enter the book number that needs to be deleted : ");
        int index = scan.nextInt () - 1;
        books.remove (index);
        System.out.println ("New Inventory List :" );
        displayBooks (books);
    }

    public static void AddBookTotheArray(ArrayList <Book> books, Scanner scan) {
        System.out.println ("What is the title?");
        String title = scan.nextLine ();
        System.out.println ("What is the author");
        String author = scan.nextLine ();

        books.add (new Book(title, author) );
    }

    private static void updateDueDate(Book bookWanted) {
        Calendar c = Calendar.getInstance ();
        c.setTime (new Date());
        c.add (Calendar.DATE, 14);

        SimpleDateFormat sdf = new SimpleDateFormat ("MM/dd/yyyy");
        String output = sdf.format (c.getTime());
        bookWanted.setDueDate (output);
    }
}
