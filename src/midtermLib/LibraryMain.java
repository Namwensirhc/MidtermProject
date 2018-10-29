package midtermLib;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class LibraryMain {
	public static void main(String[] args) {
    	
    	Scanner scan = new Scanner (System.in);
        final String fileName = "books.txt";
        final String directoryFolder = "midtermLib.libraryFolder";
        int selection;
        ArrayList <String> booksList = new ArrayList <String> ();
        
    	File f = new File("C:/Users/bryan/eclipse-workspace/MidtermTestPackage/Books/books.txt");
		try {
			booksList = EditFileList.getListFromFile(f);
		} catch (FileNotFoundException e1) {
			System.out.println("Error-404: One guess if the file was found or not....");
		}
  

        System.out.println ("Welcome To The DBC Library \n"); //Dejuan, Bryan, Chris Library
        do {
            promptUser ();
            selection = scan.nextInt ();
            scan.nextLine ();

            
            if (selection == 6)//6 is the number we told the user would allow them to quit
                break;

            switch (selection) {
            case 1:
            	EditFileList.getBookList(booksList);
                break;
            case 2:
                EditFileList.searchAuthor(booksList, scan, "Please enter the author you are looking for: ");
                break;
            case 3:
            	 EditFileList.searchTitle(booksList, scan, "Please enter the title you are looking for: ");
                break;
            case 4:
                EditFileList.getBookList(booksList);
                System.out.println ("Please enter the book number you would like to check out : ");
                int userChoice = scan.nextInt();
                String bookOut = EditFileList.checkOut(booksList, userChoice);
                booksList.set(userChoice-1, bookOut);
                EditFileList.writeToFile ("midtermLib.libraryFolder", "books.txt", booksList);
                break;
            case 5:
            	EditFileList.getBookList(booksList);
                System.out.println ("Please enter the book number you would like to return : ");
                int userChoice2 = scan.nextInt();
                String bookIn = EditFileList.returnBook(booksList, userChoice2);
                booksList.set(userChoice2-1, bookIn);
                EditFileList.writeToFile ("midtermLib.libraryFolder", "books.txt", booksList);
                break;
            case 6:
                System.out.println("Thank you for using the library.");
                break;
            default:
                System.out.println ("Error");
        }
            System.out.println ();
            
            
        } while (true);
        System.out.println("Ok, thank you for using the library. Have a nice day!");
    }

	public static void promptUser() {
	    System.out.println ("Please select from the following options : ");
	    System.out.println ("1 - Display the entire list of books.");
	    System.out.println ("2 - Search for a book by author.");
	    System.out.println ("3 - Search for a book by title keyword.");
	    System.out.println ("4 - Select a book to check out.");
	    System.out.println ("5 - Return a book.");
	    System.out.println ("6 - Quit and Save.");
	    System.out.print ("Select here: \n");
	}

    }

