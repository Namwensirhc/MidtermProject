package midtermLib;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryMain {
	public static void main(String[] args) {
    	
    	Scanner scan = new Scanner (System.in);
        final String fileName = "books.txt";
        String directoryFolder = "libraryFolder";
        int selection;
        ArrayList <Book> books = new ArrayList <Book> ();

        EditTextLine.createFile (fileName);
        EditTextLine.readFromFile (fileName, books);
        if (books.isEmpty ()) {
            BookList.defBookList (books);
        }

        System.out.println ("Welcome To The DBC Library \n"); //Dejuan, Bryan, Chris Library
        do {
            promptUser ();
            selection = scan.nextInt ();
            scan.nextLine ();

            //6 is the number we told the user would allow them to quit
            if (selection == 6)
                break;

            UserInputAction (selection, scan, books);
            System.out.println ();
        } while (true);
        EditTextLine.writeToFile (books, fileName);
    }

    public static void promptUser() {
        System.out.println ("Please select from the following options : ");
        System.out.println ("1 - Display the entire list of books.");
        System.out.println ("2 - Search for a book by author.");
        System.out.println ("3 - Search for a book by title keyword.");
        System.out.println ("4 - Select a book to check out.");
        System.out.println ("5 - Return a book.");
        System.out.println ("6 - Quit and Save.");
        System.out.print ("Select here: ");
    }

    public static void UserInputAction(int selection, Scanner scan, ArrayList <Book> books) {
        Book currBook;
        switch (selection) {
            case 1:
                BookList.displayBooks (books);
                break;
            case 2:
                BookList.searchBookByAuthor (books, scan);
                break;
            case 3:
                BookList.searchBookByTitle (books, scan);
                break;
            case 4:
                BookList.displayBooks (books);
                System.out.println ("Please enter the book number you would like to check out : ");
                currBook = BookList.SelectBook (books, scan);
                BookList.CheckOutBook (currBook);
                break;
            case 5:
                System.out.println ("Please enter the book number you would like to return : ");
                currBook = BookList.SelectBook (books, scan);
                BookList.ReturnBook (currBook);
                break;
            case 6:
                BookList.RemoveBookFromInventory (books, scan );
                break;
            case 7:
                BookList.AddBookTotheArray (books, scan);
                break;
            case 8:
                books.clear ();
                BookList.defBookList (books);
                break;
            default:
                System.out.println ("Error");
        }
    }
}
