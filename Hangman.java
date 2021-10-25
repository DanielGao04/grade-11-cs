/** [Hangman.java]
  * plays a game of hangman where the user inputs letters or a phrase to guess a secret phrase/word
  * @author Daniel Gao
  * @version 1.0
  * December 1, 2020
  */

import java.util.Scanner;  //imports the scanner class

public class Hangman {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    
    System.out.println("<<------------------------------------------------->>" + '\n' + '\n' +
                       
                       "                Welcome to Hangman!" + '\n' +
                       "  Please enter the word or phrase you want to guess" + '\n' + '\n' +
                       
                       "<<------------------------------------------------->>"); //message displayed as a title screen at first
    
    
    String userSecret = "", fullMessage = "", blockedMessage = "", SecretMessage; //main variables
    SecretMessage = input.nextLine();
    
    int count = 0; //setting the variable to start at 0 errors
    
    
    System.out.println("try to guess the phrase by typing in only one letter or the whole phrase if you know it! (6 tries)"); //asking the user what to input and the guesses
    
    
    for(int i = 0; i < SecretMessage.length(); i++){ //tells if the user's guess is correct or incorrect
      userSecret = input.nextLine(); 
      
      blockedMessage = blockedMessage(SecretMessage, fullMessage);
      
      
      if (dash(SecretMessage, userSecret, blockedMessage).equals(blockedMessage) == false && userSecret.length() != 2 && userSecret.length() != SecretMessage.length()){ //when the user gives the correct letter
        
        count = count + 0;
        System.out.println(image(count));
        System.out.println(dash(SecretMessage, userSecret, blockedMessage));
        System.out.println("Correct, the letter: " + userSecret + " was found!"); 
        System.out.println("Now you can guess again a letter or the entire phrase of the secret");
        
        fullMessage = dash(SecretMessage, userSecret, blockedMessage);
        
        if (fullMessage.equals(SecretMessage) == true){
          System.out.println("Congratulations! You won! The word/phrase was: " + SecretMessage);
          break; 
        }    
        
      }else if (dash(SecretMessage, userSecret, blockedMessage).equals(blockedMessage)&& userSecret.length() != 2 && userSecret.length() != SecretMessage.length()){ //when the user gives an inccorrect letter
        count = count + 1;
        System.out.println(image(count));
        System.out.println(dash(SecretMessage, userSecret, blockedMessage));
        System.out.println("Incorrect, the letter: " + userSecret + " was not found!"); 
        System.out.println("You can guess again a letter or the entire phrase of the secret");
        
        if (count == 6){ //once 6 errors the game ends
          System.out.println("Game Over, You Lose! The word/phrase was: " + SecretMessage); 
          
        }
      }
      
      if (userSecret.equals(SecretMessage) == false && userSecret.length() > 1 ){ //if the user inputs a wrong phrase
        count = 6; 
        System.out.println(image(count));
        System.out.println("Game Over, You Lose! The word/phrase was: " + SecretMessage);
        break;
        
        
      }else if (userSecret.equals(SecretMessage) && userSecret.length() > 1 ){ //if the user inputs the whole phrase correctly
        count = 0;
        System.out.println(image(count));
        System.out.println(SecretMessage);
        System.out.println("Congratulations! You won! The word/phrase was: " + SecretMessage );
        break;
      }
    }
    input.close();
  
  }
  
  /**
   * blockedMessage
   * replaces the letters of the secret word or phrase into dashes
   * @param String SecretMessage is the inputted phrase by user to be converted into dashes
   * @param String fullMessage is inputted as the beginging for the secret word to be converted into dashes
   * @return String blockedMessage returns the dash version of the secret word or phrase
   */
  
  public static String blockedMessage(String SecretMessage, String fullMessage){//creates the method named blockedMessage
    
    
    String abc; //main variables
    String blockedMessage;
    
    abc = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    blockedMessage = fullMessage; 
    
    
    for (int i = 0; i<SecretMessage.length();i++) { // finds the length of the word or phrase
      
      if (abc.indexOf(SecretMessage.charAt(i)) == -1 && fullMessage == "") {
        blockedMessage = SecretMessage.charAt(i) + blockedMessage;
      }
      else if (fullMessage == "") {
        blockedMessage =  "-" + blockedMessage;
      }
    }
    return blockedMessage;
  }
  
  /**
   * dash
   * changes the dashes into letters when the user inputs a correct letter of the secret word or phrase
   * @param String SecretMessage is the input of the user of the phrase or word
   * @param String userSecret the is letter inputted by the user
   * @param String blockedMessage is converting the dash of the inputted phrase 
   * @return String blockedMessage returns the dashed message with letters replacing them at the correct spot
   */
  
  public static String dash(String SecretMessage, String userSecret, String blockedMessage){
    
    for(int i = 0; i < SecretMessage.length(); i++){
      
      if(SecretMessage.substring(i, i + 1).equals(userSecret)){
        blockedMessage = blockedMessage.substring(0, i) + userSecret + blockedMessage.substring(i + 1);
      }
    }
    return blockedMessage;
  }
  
  /**
   * image
   * prints out the image of the hangman when a user inputs a letter
   * @param int count is number of incorrect input guesses
   * @return String image returns of the picture of the hangman, counting the player's lives
   */
  
  public static String image(int count){
    
    
    String image; //main variable
    image = "";
    
    if(count == 0){ //if no errors
      image = image + ("  %%%%%%%%%" + '\n' +
                       "  \n  %" + '\n' +
                       "  \n  %" + '\n' +
                       "  \n  %" + '\n' +
                       "  \n  %" + '\n' +
                       "\n  %%%%%");
      
    }else if (count == 1){//if one error
      image = image + ("  %%%%%%%%%" + '\n' +
                       "  \n  %       (-_-)" + '\n' +
                       "  \n  %" + '\n' +
                       "  \n  %" + '\n' +
                       "  \n  %" + '\n' +
                       "\n  %%%%%");
      
    }else if (count == 2){//if two errors
      image = image + ("  %%%%%%%%%" + '\n' +
                       "  \n  %     (-_-)" + '\n' +
                       "  \n  %       |" + '\n' +
                       "  \n  %" + '\n' +
                       "  \n  %" + '\n' +
                       "\n  %%%%%");
      
    }else if (count == 3){//if three errors
      image = image + ("  %%%%%%%%%" + '\n' +
                       "  \n  %     (-_-)" + '\n' +
                       "  \n  %       |" + '\n' +
                       "  \n  %       |" + '\n' +
                       "  \n  %" + '\n' +
                       "\n  %%%%%");
      
    }else if (count == 4){//if 4 errors
      image = image +("  %%%%%%%%%" + '\n' +
                      "  \n  %      (-_-)" + '\n' +
                      "  \n  %        |" + '\n' +
                      "  \n  %        |" + '\n' +
                      "  \n  %      _| |_" + '\n' +
                      "\n  %%%%%");
      
    }else if (count == 5){//if 5 errors
      image = image + ("  %%%%%%%%%" + '\n' +
                       "  \n  %      (-_-)" + '\n' +
                       "  \n  %     <--|-->" + '\n' +
                       "  \n  %        |" + '\n' +
                       "  \n  %      _| |_" + '\n' +
                       "\n  %%%%%");
      
    }else if (count == 6){//if 6 errors
      image = image + ("  %%%%%%%%%" + '\n' +
                       "  \n  %      (X_X)" + '\n' +
                       "  \n  %     <--|-->" + '\n' +
                       "  \n  %        |" + '\n' +
                       "  \n  %     (_| |_)" + '\n' +
                       "\n  %%%%%");
      
    }
    return image; //returns the image to the main program
  }
}


