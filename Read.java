import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;

class Read{
  
  public static void main(String[] args) throws Exception{
    
    Scanner input = new Scanner(System.in);
    File myfile = new File("word.txt");
    
    PrintWriter output = new PrintWriter(myfile);
 
    System.out.println("Enter Anything");
    String anything = input.nextLine();
    
    output.println(anything);
    
    output.close();
    
    
    

    
    
   
    
    
  }
}