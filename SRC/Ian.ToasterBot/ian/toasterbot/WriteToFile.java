package ian.toasterbot;

import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class WriteToFile {

  public static void write(String text) {

    try {
      FileWriter myWriter = new FileWriter("Suggestions.txt");
      myWriter.write("text");
      myWriter.write("arhiagvlylaerygvlevu ");
      myWriter.close();
      System.out.println("Successfully wrote to the file.");

    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public static void main(String[]args){

    write("HEllo Worls");
  }
}
