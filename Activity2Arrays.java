import java.util.Scanner;

public class Activity2Arrays {
  
  
  public static void main(String[] args) { 
    
    Scanner input = new Scanner(System.in);
    String[] words = new String[3];
    
    System.out.println("Enter secret words");
    for(int i = 0; i<3; i++){ 
      words[i] = input.nextLine();  
    }
    
    
    System.out.println("Guess the secret words one by one");
        String guess = input.nextLine();
        
    for(int i = 0; i<3; i++){
      while(!guess.equals(words[i])){
      System.out.println("Please try again");
      guess = input.nextLine();
      
        if(guess.equals(words[i])){
          System.out.println("Good job");
          guess = input.nextLine();
          
        }
      }
      
    }
  }
}











