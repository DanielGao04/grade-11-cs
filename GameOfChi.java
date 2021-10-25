import java.util.Scanner;

/**
 * Game of Chi .. see main for gameplay
 * 
 * @author .....
 */
public class GameOfChi {

private static int numStonesLeft = 0;

public static void main(String[] args) {
    numStonesLeft = (int) (Math.random() * 16) + 15;// btw 15 & 30 stones
    System.out.println("This is the Game of Chi.");
    System.out.println("There is a pile of " + numStonesLeft
            + " stones between us.");
    System.out.println("We alternate taking either 1,2 or 3 stones.");
    System.out.println("The person who takes the last stone loses");

    // Write a loop to alternate computerTurn() and playerTurn()
    // checking after each turn see if there is a winner to print
    // and to break the loop ... then output the winner

    computerTurn(); // invoke the computerTurn() method
    playerTurn(); // invoke the playerTurn() method
while (numStonesLeft> 0);


}

/**
 * The computerTurn method chooses a random number from 1 to 3 if
 * numStonesLeft is greater than or equal to 3, otherwise chooses a random
 * number from 1 to numStonesLeft.
 * 
 * Then decrements numStonesLeft appropriately and prints the turn.
 */
public static void computerTurn() {
    int stonesChosen = 1 + (int) (Math.random() * Math
            .min(3, numStonesLeft));
    numStonesLeft -= stonesChosen;
    System.out.println("\nI took " + stonesChosen + " stones.");
    System.out.println("There are " + numStonesLeft + " stones left.");
}

/**
 * The playerTurn method prompts the user for a valid number of stones to
 * choose and reads an int value from the user and will repeat this action
 * while the user input is invalid. (i.e. user must choose 1, 2 or 3 AND
 * their choice must be less than or equal to numStonesLeft.)
 * 
 * Also decrements numStonesLeft appropriately and prints the turn.
 */
public static void playerTurn() {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Number of stones you take this turn:");
    int stonesChosen = 0;
    stonesChosen = keyboard.nextInt();

    while (stonesChosen > 3 || stonesChosen < 1) {
        ;
        System.out.println("That is an invalid number of stones.");
        stonesChosen = keyboard.nextInt();
    }

    if (stonesChosen <= 3 || stonesChosen >= 1)
        ;
    {
        System.out.println("\nYou took " + stonesChosen + " stones.");
        System.out.println("There are " + (numStonesLeft - stonesChosen)
                + " stones left.");
    }
    stonesChosen = keyboard.nextInt();

}
}