
/**
*[bruteForce.java]
* A program that will find two numbers that meet the conditions by generating random numbers
* @author Daniel Gao
* @version 1.0 10/21/2020
*/

import java.util.Random;
public class activity3wl2 {
  
  public static void main(String[]args){
    
   
    Random myRandom = new Random();
    int num1;
    int num2;
    
    
    do{
    num1 = myRandom.nextInt(100)+1;
    num2 = myRandom.nextInt(100)+1;
   
    }
    while(!(num1 + num2 == 20) || !(num1 * num2 == 96));
    System.out.println("The first integer is " + num1);
      System.out.println("The second integer is " + num2);
      

  }
}
