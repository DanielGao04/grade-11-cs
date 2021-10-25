import java.util.Scanner;

public class Method6 {
  
  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);
    System.out.print(
                     "1. A password must have at least ten characters." +
                     "2. A password consists of only letters and digits." +
                     "3. A password must contain at least two digits" + 
                     "Input a password: ");
    String s = input.nextLine();
  } 
}
  