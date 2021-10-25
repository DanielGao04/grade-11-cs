import java.util.Scanner;
public class CountCharacter{    
    public static void main(String[] args) {    
      
      Scanner scan = new Scanner(System.in);
      
      System.out.println("Enter a word or sentence");
      String word = scan.nextLine();
        String string = word;   
        
        System.out.println("Enter a character");
        char character = scan.next().charAt(0);
        
          
        int count = 0;    
             
        for(int i = 0; i < string.length(); i++) {    
            if(string.charAt(i) == character)    
                count++;    
        }    
                
        System.out.println("Total number of " + character +  "'s in " + word + " is: " + count);    
    }    
}     