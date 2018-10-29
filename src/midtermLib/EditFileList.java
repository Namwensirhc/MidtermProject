package midtermLib;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;

public class EditTextLine {

public static void changeTextLine(String fileName, String newLine, int lineNumber) {
        String content = new String();
        String editedContent = new String();
        String books = readFromFile(fileName);
        editedContent = editLineInContent(content, newLine, lineNumber);
        writeToFile(fileName, editedContent);

    }

private static String readFromFile(String fileName) {
	// TODO Auto-generated method stub
	return null;
}

private static int numberOfLinesInFile(String content) {
    int numberOfLines = 0;
    int index = 0;
    int lastIndex = 0;

    lastIndex = content.length() - 1;

    while (true) {

        if (content.charAt(index) == '\n') {
            numberOfLines++;

        }

        if (index == lastIndex) {
            numberOfLines = numberOfLines + 1;
            break;
        }
        index++;

    }

    return numberOfLines;
}

private static String[] turnFileIntoArrayOfStrings(String content, int lines) {
    String[] array = new String[lines];
    int index = 0;
    int tempInt = 0;
    int startIndext = 0;
    int lastIndex = content.length() - 1;

    while (true) {

        if (content.charAt(index) == '\n') {
            tempInt++;

            String temp2 = new String();
            for (int i = 0; i < index - startIndext; i++) {
                temp2 += content.charAt(startIndext + i);
            }
            startIndext = index;
            array[tempInt - 1] = temp2;

        }

        if (index == lastIndex) {

            tempInt++;

            String temp2 = new String();
            for (int i = 0; i < index - startIndext + 1; i++) {
                temp2 += content.charAt(startIndext + i);
            }
            array[tempInt - 1] = temp2;

            break;
        }
        index++;

    }

    return array;
}

private static String editLineInContent(String content, String newLine, int line) {

    int lineNumber = 0;
    lineNumber = numberOfLinesInFile(content);

    String[] lines = new String[lineNumber];
    lines = turnFileIntoArrayOfStrings(content, lineNumber);

    if (line != 1) {
        lines[line - 1] = "\n" + newLine;
    } else {
        lines[line - 1] = newLine;
    }
    content = new String();

    for (int i = 0; i < lineNumber; i++) {
        content += lines[i];
    }

    return content;
}

private static void writeToFile(String file, String books) {

    try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"))) {
        writer.write(books);
    } catch (UnsupportedEncodingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}

private static String readFromFile(String fileName, String books) {
    String books1 = null;
    File file = new File(fileName);
    FileReader reader = null;
    try {
        reader = new FileReader(file);
        char[] chars = new char[(int) file.length()];
        reader.read(chars);
        books1 = new String(chars);
        reader.close();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                
                e.printStackTrace();
            }
        }
    }
    return books1;
}

static void createFile(String fileName) {
	
	
}

static void readFromFile(String fileName, ArrayList<Book> bookList) {
	
	
}

static void writeToFile(ArrayList<Book> bookList, String fileName) {
	
	
}





}
