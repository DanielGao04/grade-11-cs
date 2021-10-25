/** [Hangbro.java]
  * plays a full game of hangman; guessing game
  * @author Alan Zhang
  * @version 1.0
  */


//import scanner
import java.util.Scanner; 

class Hangb {

  public static void main(String[] args) {
  Scanner input = new Scanner(System.in);
  
  //main variables
  System.out.println("Welcome to Hangbro!");
  System.out.println("Input a phrase!");
  System.out.println();
  String secretMessage = input.nextLine();
  System.out.println();
  System.out.println("Now guess the phrase by inputting ONE letter or inputting the whole phrase! (You get only 5 lives)");
  String inputSecret = "";
  int error = 0;
  String totalMessage = "";
  String hiddenMessage = ""; 
  
  //determine if the user guesses the correct letter or phrase
 // do{
    for(int i = 0; i < secretMessage.length(); i++){
    inputSecret = input.nextLine(); 
    
    hiddenMessage = hiddenMessage(secretMessage, totalMessage);
      
     //if the user gives the right letter
    if (dashHang(secretMessage, inputSecret, hiddenMessage).equals(hiddenMessage) == false && inputSecret.length() != 2 && inputSecret.length() != secretMessage.length()){
       
      error = error + 0;
       System.out.println(pictureHang(error));
       System.out.println(dashHang(secretMessage, inputSecret, hiddenMessage));
       System.out.println("Correct");
        
       totalMessage = dashHang(secretMessage, inputSecret, hiddenMessage);
       
       if (totalMessage.equals(secretMessage) == true){
         System.out.println("You win!");
        break; 
      }    
       //if the user gives the wrong letter
    }else if (dashHang(secretMessage, inputSecret, hiddenMessage).equals(hiddenMessage)&& inputSecret.length() != 2 && inputSecret.length() != secretMessage.length()){
      error = error + 1;
      System.out.println(pictureHang(error));
      System.out.println(dashHang(secretMessage, inputSecret, hiddenMessage));
      System.out.println("Incorrect");
      //if the user gives the wrong letter five times
      if (error > 4){
        System.out.println("Game Over"); 
     
      }
   }
     //if the user guesses the wrong phrase; 2 or more letters
      if (inputSecret.equals(secretMessage) == false && inputSecret.length() > 1 ){
        error = 5;
        System.out.println(pictureHang(error));
        System.out.println("Game Over");
        break;
      
        //if the user guesses the correct phrase as a whole
      }else if (inputSecret.equals(secretMessage) && inputSecret.length() > 1 ){
        error = 0;
        System.out.println(pictureHang(error));
        System.out.println(secretMessage);
        System.out.println("You win!");
        break;
      }
    }
    //close scanner 
    input.close();
    
  
  }

  /**
   * hiddenMessage
   * This method prints the dashes replacing the inputted phrase for setup
   * @param String secretMessage is the inputted phrase by user for conversion
   * @param String totalMessage is inputted as the start of the dash conversion
   * @return String hiddenMessage returns the dash conversion of the inputted phrase
   */
   
  public static String hiddenMessage(String secretMessage, String totalMessage){
    
    //hiddenMessage variables
    String alphabet;
    String hiddenMessage;
    
    alphabet = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
    hiddenMessage = totalMessage; 
    
    //determines the length of the phrase
    for (int i = 0; i<secretMessage.length();i++) {
      //finds the spaces of a phrase and adds the dashes
      if (alphabet.indexOf(secretMessage.charAt(i)) == -1 && totalMessage == "") {
        hiddenMessage = hiddenMessage + secretMessage.charAt(i);
      } else {
        if (totalMessage == "") {
       hiddenMessage = hiddenMessage + "-";
        }
      }
    }
    
    return hiddenMessage;
  }
  
  /**
   * dashHang
   * This method replaces single dashes as letters when the user guesses a letter 
   * @param String secretMessage is the inputted phrase by user for conversion
   * @param String inputSecret is the inputted letter by the player for conversion
   * @param String hiddenMessage is the dash conversion of the inputted phrase
   * @return String hiddenMessage returns the dash conversion with letters replacing their calculated spot
   */
  public static String dashHang(String secretMessage, String inputSecret, String hiddenMessage){
   //finds the length of the phrase
    for(int i = 0; i < secretMessage.length(); i++){
    //replaces the dashes with the inputted letters
      if(secretMessage.substring(i, i + 1).equals(inputSecret)){
             hiddenMessage = hiddenMessage.substring(0, i) + inputSecret + hiddenMessage.substring(i + 1);
      }
    }
    
    return hiddenMessage;
  }
  
  /**
   * pictureHang
   * This method prints the picture of a hangman when a user inputs a letter
   * @param int error is the number of how many incorrect letters the player inputs
   * @return String pictureHang returns of the picture of the hangman, counting the player's lives
   */
  public static String pictureHang(int error){
    
    //pictureHang variables
    String pictureHang;
    pictureHang = "";
    
    //if the user has zero errors
    if(error == 0){
      pictureHang = pictureHang + ("  %%%%%");
      pictureHang = pictureHang + ("  \n  %");
      pictureHang = pictureHang + ("  \n  %");
      pictureHang = pictureHang + ("  \n  %");
      pictureHang = pictureHang + ("  \n  %");
      pictureHang = pictureHang + ("\n%%%");
      
      //if the user has one error
    }else if (error == 1){
      pictureHang = pictureHang + ("  %%%%%");
      pictureHang = pictureHang + ("  \n  %       O");
      pictureHang = pictureHang + ("  \n  %");
      pictureHang = pictureHang + ("  \n  %");
      pictureHang = pictureHang + ("  \n  %");
      pictureHang = pictureHang + ("\n%%%");
      
      //if the user has two errors
    }else if (error == 2){
      pictureHang = pictureHang + ("  %%%%%");
      pictureHang = pictureHang + ("  \n  %       O");
      pictureHang = pictureHang + ("  \n  %        I");
      pictureHang = pictureHang + ("  \n  %");
      pictureHang = pictureHang + ("  \n  %");
      pictureHang = pictureHang + ("\n%%%");
      
      //if the user has three errors
  }else if (error == 3){
      pictureHang = pictureHang + ("  %%%%%");
      pictureHang = pictureHang + ("  \n  %       O");
      pictureHang = pictureHang + ("  \n  %        I");
      pictureHang = pictureHang + ("  \n  %        Y");
      pictureHang = pictureHang + ("  \n  %");
      pictureHang = pictureHang + ("\n%%%");
      
      //if the user has four errors
  }else if (error == 4){
      pictureHang = pictureHang + ("  %%%%%");
      pictureHang = pictureHang + ("  \n  %       O");
      pictureHang = pictureHang + ("  \n  %        I");
      pictureHang = pictureHang + ("  \n  %        Y");
      pictureHang = pictureHang + ("  \n  %         l");
      pictureHang = pictureHang + ("\n%%%");
      
      //if the user has five errors
  }else if (error == 5){
      pictureHang = pictureHang + ("  %%%%%");
      pictureHang = pictureHang + ("  \n  %       O");
      pictureHang = pictureHang + ("  \n  %        I");
      pictureHang = pictureHang + ("  \n  %        Y");
      pictureHang = pictureHang + ("  \n  %         l");
      pictureHang = pictureHang + ("\n%%%    l  l");
      //pictureHang = pictureHang + ("\n Game Over");
  }
  return pictureHang;
  
  }
}
  


