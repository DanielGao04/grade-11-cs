import java.util.Scanner;
public class Practive{
 
 public static void main(String[] args){
  int remain = 21;
  Scanner scan = new Scanner(System.in);
  while (remain >1){
   System.out.println("Take 1 or 2 sticks");
   int input = scan.nextInt(); 
   remain = remain -input;
   System.out.println("Next player's turn. The number of reamining sticks is "+remain);
   
  }
  System.out.println ("You won!");
 }
}
 
 