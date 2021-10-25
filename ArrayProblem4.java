import java.util.Scanner;
/** Design a program that asks the user for ten words and stores it in an array. 
  * It should then call a method that reports the number of words that are non-unique. This should be output.
  * Example: [“apple”,”orange”,”apple” ”banana”,”apricot””,pineapple”,” watermelon”,”watermelon”,”watermelon”,"pears"]
  * result:2
  */

class ArrayProblem4 { 
  
  public static void main(String[] args) { 
    
    Scanner input = new Scanner(System.in);
    
    String[] words = new String[10];
    
    
    System.out.println("Enter words");
    for(int i = 0; i<10; i++){ 
      words[i] = input.nextLine();  
    }
    
    
  }
  
  
  
  
  public static int unique(String[] poo){ 
    
    return 0;
    
  }
}