package midtermLib;


import java.util.Scanner;

public class LibApp {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//Ask user for search/ Bring up list
		// Display book list
		// If/Else for book status:
//		If book available assign due date
//		else is out,
//		Have some books checked out with due dates for coming back

		System.out.println("Hello user welcome to the Grand Circus public Library, How can we help you today?");
		System.out.println("Search - (Type Search)");
		System.out.println("Book List - (Type List)");
		System.out.println("Avaliable and Checked Out Books - (Type Books)");
		String userInput = sc.next();

		// USE VALIDATOR BELOW ON STATEMENTS BELOW
		if (userInput == "Search") {
			SEARCH();
		} else if (userInput == "List") {
			LIST();
		} else if (userInput == "Books") {
			BOOKS();
		}

	}

	public static void BOOKS() {
		System.out.println(
				"Here is the list of our currently available books and the due dates of those that are currently out");
		// readlist()
		// TODO Auto-generated method stub

	}

	public static void LIST() {
		System.out.println("Here are all the books in our database:");
		// readList

	}

	public static void SEARCH() {
		// TODO Auto-generated method stub
		System.out.println(" Search books by Author, Title or Keywords:");
		String userSearch = sc.next();
		// if(userSearch
	}

	public static void RECCOMEND() {

	}

	public static void BOOKRETURN() {

	}

}
