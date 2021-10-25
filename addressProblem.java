import java.util.*;

class website{
  public static void main (String[]args){
    
    
    Scanner input = new Scanner (System.in);
    
    System.out.println("enter 1:");
    int poo1 = input.nextInt();
    
    
    System.out.println("enter 2:");
    int poo2 = input.nextInt();
    
    input.next();
    
    if(poo1 == poo2){
      System.out.println("They are the same");
     
    }else{
        System.out.println("They are the different");
    }
    
  }
}