package midtermLib;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class EditFileList {

	public static ArrayList<String> getListFromFile(File fileIn) throws FileNotFoundException {
		Scanner scnr;
		ArrayList<String> list = new ArrayList<String>();
		scnr = new Scanner(fileIn);
		while (scnr.hasNextLine()) {
			list.add(scnr.nextLine());
		}
		scnr.close();
		return list;
	}
	
	public static void getBookList (ArrayList<?> input) {
		for (int x = 0; x < input.size(); x++) {
			System.out.println((x + 1) + ". " + input.get(x) +"\n");
		}
	}

	public static String checkOut(ArrayList<?> lines, int input) {
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date date = new Date();
		String today = (dateFormat.format(date));
		LocalDate datePlus = LocalDate.now().plusDays(14);
		String dueDate = datePlus.toString();

		String temp = (String) lines.get(input - 1);
		if (temp.contains("In Stock")) {
			temp = temp.replaceAll("\\bIn Stock\\b", " Checked Out: " + today);
			temp = temp + " Due Back: " + dueDate;
			System.out.println("Checked out: " + today);
		}
		return temp;
	}
	
	public static String returnBook(ArrayList<?> lines, int input) {
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date date = new Date();
		String today = (dateFormat.format(date));

		String temp = (String) lines.get(input - 1);
		if (temp.contains("Checked Out")) {
			int end = temp.indexOf(":");
			temp = temp.substring(0,end);
			System.out.println("Returned on " + today);
			temp = temp + ": In Stock";
			
					
		}
		return temp;
	}

	public static void searchAuthor(ArrayList<?> input, Scanner scan, String prompt) {
		System.out.println(prompt);
		String bookAuthor = scan.nextLine();
		bookAuthor = bookAuthor.toLowerCase();
		String temp = null;
		ArrayList<String> lines = (ArrayList<String>) input;
		for (int i = 0; i < lines.size(); i++) {
			temp = lines.get(i);
			temp = temp.toLowerCase();
			if (temp.contains(bookAuthor)) {
				System.out.println((i + 1) + ".) " + lines.get(i));
		}
	}
	}

	public static void searchTitle(ArrayList<?> input, Scanner scan, String prompt) {
		System.out.println(prompt);
		String bookTitle = scan.nextLine();
		bookTitle = bookTitle.toLowerCase();
		String temp = null;
		ArrayList<String> lines = (ArrayList<String>) input;
		for (int i = 0; i < lines.size(); i++) {
			temp = lines.get(i);
			temp = temp.toLowerCase();
			if (temp.contains(bookTitle)) {
				System.out.println((i + 1) + ".) " + lines.get(i));
			}
		}
	}

	public static void createFile(String file, ArrayList<String> arrData) throws IOException {
		FileWriter writer = new FileWriter(file + ".txt");
		int size = arrData.size();
		for (int i = 0; i < size; i++) {
			String str = arrData.get(i).toString();
			writer.write(str);
			if (i < size - 1) {// This prevent creating a blank like at the end of the file**
				writer.write("\n");
			}
			writer.close();
		}
	}

	public static void writeToFile(String directoryFolder, String fileName, ArrayList<?> input) {
		Path filePath = Paths.get(directoryFolder, fileName);
		File file = filePath.toFile();
		
		ArrayList<String> temp = (ArrayList<String>) input;
		String newFile = temp.get(0);
		
		for (int i = 1; i < temp.size(); i++) {
			 
			 newFile = newFile + "\n" + temp.get(i);
			
		}
		

		try {
			PrintWriter outW = new PrintWriter(new FileOutputStream(file, false));
			outW.println(newFile);
			outW.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error - 404: File not found....HaHa!");
		}
		

	}
}
