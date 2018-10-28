package midtermLib;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryMain {
    public static void main(String[] args) {
    	
    	Scanner scan = new Scanner (System.in);
        final String fileName = "bookList.txt";
        int selection;
        
        ArrayList <Book> bookList = new ArrayList <Book> ();

        EditTextLine.createFile (fileName);
        EditTextLine.readFromFile (fileName, bookList);
        if (bookList.isEmpty ()) {
            BookList.defBookList (bookList);
        }

        System.out.println ("Welcome to SBMI Library \n"); //Chris lol
        do {
            promptUser ();
            selection = scan.nextInt ();
            scan.nextLine ();

            //0 is the number we told the user would allow them to quit
            if (selection == 0)
                break;

            UserInputAction (selection, scan, bookList;
            System.out.println ();
        } while (true);
        EditTextLine.writeToFile (bookList, fileName );
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

    public static void UserInputAction(int selection, Scanner scan, ArrayList <Book> bookList) {
        Book currBook;
        switch (selection) {
            case 1:
                BookList.displayBooks (bookList);
                break;
            case 2:
                BookList.searchBookByAuthor (bookList, scan);
                break;
            case 3:
                BookList.searchBookByTitle (bookList, scan);
                break;
            case 4:
                BookList.displayBooks (bookList);
                System.out.println ("Please enter the book number you would like to check out : ");
                currBook = BookList.SelectBook (bookList, scan);
                BookList.CheckOutBook (currBook);
                break;
            case 5:
                System.out.println ("Please enter the book number you would like to return : ");
                currBook = BookList.SelectBook (bookList, scan);
                BookList.ReturnBook (currBook);
                break;
            case 6:
                BookList.RemoveBookFromInventory (bookList, scan );
                break;
            case 7:
                BookList.AddBookTotheArray (bookList, scan);
                break;
            case 8:
                bookList.clear ();
                BookList.defBookList (bookList);
                break;
            default:
                System.out.println ("Error");
        }
    }
}
