package midtermLib;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileToList {
	
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

	@Override
	public String toString() {
		return "FileToList [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	

}
