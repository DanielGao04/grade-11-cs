import java.util.Scanner;

public class J2 {
  public static void main(String[]args){
    Scanner input = new Scanner(System.in);
    
   System.out.println("Please enter the intital values");
   int P = input.nextInt();
   int N = input.nextInt();
   int R = input.nextInt();
   
   int total = N;
   int day = 0;
  
     
   while(total<=P){
     
     total = total*(R) + total;
     day++;
     
   }
       
   System.out.println(day);
    
    
  }
}