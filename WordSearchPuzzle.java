import java.io.File;
import java.util.Scanner;
import java.util.*;
public class WordSearchPuzzle {
  public static void main(String[] args) throws Exception{
    
    Scanner input = new Scanner(System.in);
    
    int rows, cols;
    System.out.println("what dimension do you want you word search to be?");
    rows = input.nextInt();
    cols = rows;
    int [][] wordsearch = new int[rows][cols];
    
    Random rand = new Random();


int n = rand.nextInt(10);


n += 1;
    
    for(int i = 0; i< rows; i++){
      for(int j = 0; j< cols; j++){
        wordsearch[i][j] = n;
        System.out.print(wordsearch[i][j]);
        
      }
      System.out.println();
    }
    
    
    
    
  }
}