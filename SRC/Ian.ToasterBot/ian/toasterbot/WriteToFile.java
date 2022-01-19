package ian.toasterbot;

import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class WriteToFile {

  public static void write(String text) {

    try {
      FileWriter myWriter = new FileWriter("C:\\Users\\Ian of Drake\\Documents\\GitHub\\Discord-Bot\\SRC\\Ian.ToasterBot\\ian\\toasterbot\\Suggestions.txt", true);
      myWriter.write(text);
      myWriter.close();
      System.out.println("Successfully wrote to the file.");

    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
