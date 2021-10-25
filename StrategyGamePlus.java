/**[StrategyGame.java]
  * A game that starts with x value of rocks and players are able to take away a max of 2-4 rocks away each game. 
  * @Author Daniel Gao
  * @Version 1
  * November 4th 2020
  */

import java.util.Scanner;//imports the scanner class
import java.util.Random;//imports the random class
class StrategyGamePlus{
  
  public static void main(String[] args){
    int rocks, max, round = 0, amountOfRounds, end =0; //setting integer variables
   
    String name="", name1, name2, start;
    
    Scanner scan = new Scanner(System.in);
    Random myRandom = new Random();
    
    max = myRandom.nextInt(3)+2;
    
    System.out.println("    -----STRATEGY GAME-----     ");//creates menu for player to type start or stop
    System.out.println(" ----- TYPE START TO PLAY ----- ");
    System.out.println(" ----- TYPE STOP TO LEAVE ----- ");
    start = scan.nextLine();
    
    if (start.equals("Stop") || start.equals("STOP") || start.equals("stop")){
    System.out.println("see you next time");
    System.exit(1); //exits the entire program 
    }
    
    else if (start.equals("Start") || start.equals("START") || start.equals("start")){
      System.out.println("Welcome to the strategy game! Please enter your names below");
    }
    
    else 
      System.out.println("Ok whatever just give this game a try, its pretty fun");
    
    do{
      System.out.println("Enter name for player 1");//asking user for name
      name1 = scan.nextLine();
      
      System.out.println("Enter name for player 2");
      name2 = scan.nextLine();
      do{
        System.out.println("How many rounds do you want to play? (2-5)");//asking for how many rounds they would like to play
        amountOfRounds = scan.nextInt();
        
        while ((amountOfRounds > 5) || (amountOfRounds< 2)){// while input is over 5 or less than 2 it would ask again for a correct value
          System.out.println("You have entered an invalid number please try again:");
          amountOfRounds = scan.nextInt();
        }
        
        for(int i = 0; i < amountOfRounds; i++){//for loop for how many times the game will repeat or rounds
          rocks = myRandom.nextInt(50)+1;
          round++;
          System.out.println("This the beginning of round" + " " + round);
          
          while (rocks >0){//keeps on asking for input until rocks is 0
            if (name.equals(name1))//rotates turns for who goes
              name = name2;
            else 
              name = name1;
            
            int input = -1;
            int max1 = Math.min(max, rocks);//makes sure that user would not be ab413le to take out what exeeds the amount ofrocks
            while(input>max1 ||  input <= 0){
              System.out.println(name + "'s turn. The number of remaining rocks is " + rocks + " you can take a max of " + max1 + " rocks, how many do you want to take out?");
              input = scan.nextInt(); 
            }
            rocks = rocks - input; // subtracts the amount of rocks
            
          }
          
          System.out.println(name + " won at round " + round);//prints out who wins and at which round
          
        }
        System.out.println("What would you like to do?");
        System.out.println("1. Play another game with the same players");
        System.out.println("2. Exit the game");
        System.out.println("3. Play another game with different players");
        end = scan.nextInt();
        scan.nextLine();
        
      } while (end == 1); //restarts the game with the same players
    } while (end == 3); //restarts the whole game new withe new players
  }
}