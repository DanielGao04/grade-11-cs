/** [Hangbro.java]
  * plays a full game of hangman; guessing game
  * @author Alan Zhang
  * @version 1.0
  */



import java.util.Scanner; 

class Hangbro {

  public static void main(String[] args) {
  Scanner input = new Scanner(System.in);
  
  
  System.out.println("<<------------------------------------------------->>" + '\n' + '\n' +
                       
                       "                Welcome to Hangman!" + '\n' +
                       "  Please enter the word or phrase you want to guess" + '\n' + '\n' +
                       
                       "<<------------------------------------------------->>");
  
  String secretWord;
  secretWord = input.nextLine();
  System.out.println("try to guess the phrase by typing in only one letter or the whole phrase if you know it! (5 tries)");
  
  String secret = "", fullMessage = "", blockedMessage = ""; 
  int count = 0;
 
    
    for(int i = 0; i < secretWord.length(); i++){
    secret = input.nextLine(); 
    
    blockedMessage = blockedMessage(secretWord, fullMessage);
      
    
    if (dashHang(secretWord, secret, blockedMessage).equals(blockedMessage) == false && secret.length() != 2 && secret.length() != secretWord.length()){
       
      count = count + 0;
       System.out.println(image(count));
       System.out.println(dashHang(secretWord, secret, blockedMessage));
       System.out.println("That is correct, good job");
        
       fullMessage = dashHang(secretWord, secret, blockedMessage);
       
       if (fullMessage.equals(secretWord) == true){
         System.out.println("Congratulations! You won!");
        break; 
      }    
       
    }else if (dashHang(secretWord, secret, blockedMessage).equals(blockedMessage)&& secret.length() != 2 && secret.length() != secretWord.length()){
      count = count + 1;
      System.out.println(image(count));
      System.out.println(dashHang(secretWord, secret, blockedMessage));
      System.out.println("Incorrect, try again");
      
      if (count == 5){
        System.out.println("Game Over, You Lose!"); 
     
      }
   }
     
      if (secret.equals(secretWord) == false && secret.length() > 1 ){
        count = 5;
        System.out.println(image(count));
        System.out.println("Game Over");
        break;
      
        
      }else if (secret.equals(secretWord) && secret.length() > 1 ){
        count = 0;
        System.out.println(image(count));
        System.out.println(secretWord);
        System.out.println("Congratulations! You won!");
        break;
      }
    }
    
    input.close();
    
  
  }

  
   
  public static String blockedMessage(String secretWord, String fullMessage){
    
    
    String abc;
    String blockedMessage;
    
    abc = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    blockedMessage = fullMessage; 
    
    //determines the length of the phrase
    for (int i = 0; i<secretWord.length();i++) {
      //finds the spaces of a phrase and adds the dashes
      if (abc.indexOf(secretWord.charAt(i)) == -1 && fullMessage == "") {
        blockedMessage = blockedMessage + secretWord.charAt(i);
      }
      else {
        if (fullMessage == "") {
       blockedMessage = blockedMessage + "-";
        }
      }
    }
    
    return blockedMessage;
  }
  
 
  public static String dashHang(String secretWord, String secret, String blockedMessage){
   //finds the length of the phrase
    for(int i = 0; i < secretWord.length(); i++){
    //replaces the dashes with the inputted letters
      if(secretWord.substring(i, i + 1).equals(secret)){
             blockedMessage = blockedMessage.substring(0, i) + secret + blockedMessage.substring(i + 1);
      }
    }
    
    return blockedMessage;
  }
  
 
  public static String image(int count){
    
   
    String image;
    image = "";
    
  
    if(count == 0){
      image = image + ("  %%%%%%%%%" + '\n' +
                       "  \n  %" + '\n' +
                       "  \n  %" + '\n' +
                       "  \n  %" + '\n' +
                       "  \n  %" + '\n' +
                       "\n  %%%%%");
      
    }else if (count == 1){
      image = image + ("  %%%%%%%%%" + '\n' +
                       "  \n  %       (-_-)" + '\n' +
                       "  \n  %" + '\n' +
                       "  \n  %" + '\n' +
                       "  \n  %" + '\n' +
                       "\n  %%%%%");
      
    }else if (count == 2){
      image = image + ("  %%%%%%%%%" + '\n' +
                       "  \n  %     (-_-)" + '\n' +
                       "  \n  %       |" + '\n' +
                       "  \n  %" + '\n' +
                       "  \n  %" + '\n' +
                       "\n  %%%%%");
      
    }else if (count == 3){
      image = image + ("  %%%%%%%%%" + '\n' +
                       "  \n  %     (-_-)" + '\n' +
                       "  \n  %       |" + '\n' +
                       "  \n  %       |" + '\n' +
                       "  \n  %" + '\n' +
                       "\n  %%%%%");
      
    }else if (count == 4){
      image = image +("  %%%%%%%%%" + '\n' +
                      "  \n  %      (-_-)" + '\n' +
                      "  \n  %        |" + '\n' +
                      "  \n  %        |" + '\n' +
                      "  \n  %      _| |_" + '\n' +
                      "\n  %%%%%");
      
    }else if (count == 5){
      image = image + ("  %%%%%%%%%" + '\n' +
                       "  \n  %      (-_-)" + '\n' +
                       "  \n  %     <--|-->" + '\n' +
                       "  \n  %        |" + '\n' +
                       "  \n  %      _| |_" + '\n' +
                       "\n  %%%%%");
    }
    return image;
    
  }
}


