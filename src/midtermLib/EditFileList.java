package midtermLib;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class EditFileList {
	
	public static String checkOut(ArrayList<?> lines, int input) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String today = (dateFormat.format(date));
		LocalDate datePlus = LocalDate.now().plusDays(14);
		String dueDate = datePlus.toString();

		String temp = (String) lines.get(input - 1);
		if (temp.contains("In Stock")) {
			temp = temp.replaceAll("\\bIn Stock\\b", " Checked Out: " + today);
			temp = temp + " Due Back: " + dueDate;
		}
		return temp;
	}
	
	public static ArrayList<String> getListFromFile(File f) throws FileNotFoundException {
		Scanner s;
		ArrayList<String> list = new ArrayList<String>();
		s = new Scanner(f);
		while (s.hasNextLine()) {
			list.add(s.nextLine());
		}
		s.close();
		return list;
	}

	public static void writeToFile(String directoryFolder, String fileName, String input) {
		Path filePath = Paths.get(directoryFolder, fileName);
		File file = filePath.toFile();
		
		String lines = input;

		try {
			PrintWriter outW = new PrintWriter(new FileOutputStream(file, true));
			outW.println(lines);
		} catch (FileNotFoundException e) {
			System.out.println("Error - 404: File not found....HaHa!");
		}

	}
	
}
