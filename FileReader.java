import java.io.File;
import java.util.Scanner;

public class FileReader {
  
  public static void main(String[] args) throws Exception{
    
    File file = new File("A1-wordsearch.txt");
    Scanner input = new Scanner(file);
    
    while(input.hasNextLine()) {
    System.out.println(input.nextLine());
    }
    
    
    
    
  }
}