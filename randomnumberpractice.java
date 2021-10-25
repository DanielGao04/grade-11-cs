import java.util.Random;
import java.util.Scanner;
public class randomnumberpractice {
  
  public static void main(String[]args){
    
    
    Scanner scan = new Scanner(System.in);
    int RandomNum;
    Random myRandom = new Random();
    String confirm = "";
    long start;
    long end;
    double elapseTime;
    int num1;
    String answer;
    
    do{
      
      System.out.println("Welcome! This is a game of luck, if the number you choose gets landed on in less than 10 secs you win, if it gets landed on over 10 sec you lose."); 
      
      System.out.println("Now you may choose a random number between 1 to 1000:");
      num1 = scan.nextInt();
      
      System.out.println("Are you ready?");
      answer = scan.next();
      
      start = System.currentTimeMillis();
      if((answer.equals("yes")) || (answer.equals("Yes"))){
        System.out.println(" ");
        
        do{
          RandomNum = myRandom.nextInt(1000)+1;
          System.out.println(RandomNum);
          
        } while(RandomNum!= num1);
        
        end = System.currentTimeMillis();
        elapseTime = (end-start)/1000.0;
        
        if (elapseTime <= 10){
          System.out.println("You won! the time it took to get the value " + num1 + " is in " + elapseTime + " seconds");
        }
        else if(elapseTime > 10){
          System.out.println("You lost! the time it took to get the value " + num1 + " is in " + elapseTime + " seconds");
          
        }else{
          System.out.println(" ");
          
        }
        
        System.out.println("Do you want to try again? yes or no?");
        confirm = scan.next();
      }
    }while(confirm.equals("yes"));
    
    System.out.println("Thank you for trying out this game! See you next time!");
    
    
    
    
    
  }
}



