import java.util.Scanner;
/** [Forloopprac.java]
  * program that counts from 0 to 100 and down
  * @author Daniel Gao
  * @version 1
  */

public class Forloopprac {
  public static void main(String[]args) {
  Scanner scan = new Scanner(System.in);

String word;
int amount;

System.out.println("what word would you like to print out?");
word = scan.nextLine();

System.out.println("how many times would you like to have " + word + " printed out?");
amount = scan.nextInt();
    for(int i = 0; i<amount; i++) {
      System.out.println(i + ". " + word);    
    }
    
  
    
    
    
    
  }
  
}
