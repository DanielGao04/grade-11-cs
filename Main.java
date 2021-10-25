import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);
    
    System.out.println("1. Enter the number of small treats" + '\n' +
                       "2. Enter the number of medium treats" + '\n' +
                       "3. Enter the number of large treats");
    int S = input.nextInt();
    int M = input.nextInt(); 
    int L = input.nextInt(); 
    
    int happiness = (S + 2 * M + 3*L);
    
    if(happiness>=10){
      System.out.println("Happy");
    }
    
    else{
      System.out.println("Sad");
    }
    
    
    
    
    
    
    
    
  }
}