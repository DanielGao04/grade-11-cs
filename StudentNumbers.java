/**
 * Solution to Array Problem #1
 * ** No comments included **
 */

import java.util.Scanner;

public class Activity1Arrays {
  
  
  public static void main(String[] args) { 
    
    Scanner input = new Scanner(System.in);
    
    double total = 0;
  
    
    int[] numbers = new int[10];
    
    for(int i = 0; i<10; i++){
      System.out.println("Enter number " + (i+1) );
      numbers[i] = input.nextInt();
      
      total = total + numbers[i];
    }
    
  int lowest = numbers[0];
  
  
  for (int i = 0; i<numbers.length; i++){
    if(lowest > numbers[i]){
      lowest = numbers[i];
    }
      
  }
   
    
  System.out.println("The average is: " + total/10);
  System.out.println("The lowest number is: " + lowest);
  System.out.println("The numbers in reverse: " + " " + numbers[9] + " " + numbers[8] + " " + numbers[7] + " " + numbers[6] + " " + numbers[5] + " " + numbers[4] + " " + numbers[3] + " " + numbers[2] + " " + numbers[1] + " " + numbers[0]);
  }
  
}
  
  
  
  
  
  
  
  
  
  
  
  



