import java.util.Scanner;

public class Method3{
  public static void main(String[]args){
    Scanner input = new Scanner(System.in);
    
    String bruh;
    
    System.out.println("Please enter a string");
    bruh = input.nextLine();
    int poo = countSpace(bruh);
  
  
  System.out.println("there are " + poo + " spaces in your sentence or whatever");
  }
  public static int countSpace(String bruh) {
    int spaces = 0;
    int length = bruh.length();
    for (int i = 0; i < length; i++){
      if (bruh.charAt(i) == (' ')){
        spaces ++;
      }
      
      
    }
    return spaces;
  }
}
