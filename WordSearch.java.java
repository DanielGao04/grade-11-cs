/** 
 * [WordSearch.java]
 * Program that will take in a text file and finds words in the file 
 * @author Daniel Gao
 * @version 1.0 12/21/2020
 */

import java.io.File;
import java.util.Scanner;

public class WordSearch.java {
 
  public static void main(String[] args) throws Exception{
   
    //importing file and turning turning it into an array
    
    File file = new File("A1-wordsearch.txt"); 
    Scanner input = new Scanner(file);
    
    String line = input.nextLine();
    int space = line.indexOf(" ");
   
    int rows = Integer.parseInt(line.substring(0, space));
    int cols = Integer.parseInt(line.substring(space + 1));
   
    String [][] board = new String[rows][cols];
   
    for(int i=0; i<rows; i++){
      line = input.nextLine();
      for(int j=0; j<cols; j++){
        board[i][j] = line.substring(j*2, j*2+1);
      }
    }
   
    while(input.hasNextLine()){
      String word = input.nextLine();
     
      //Horizontal Left to Right
     
      for(int i = 0; i<rows; i++){
        String combined = "";
        for(int j = 0; j<cols; j++){
          combined = combined + board[i][j].toLowerCase();
        }
        int nextFrom = 0;
        int foundAt;
        do {
          foundAt = combined.indexOf(word.toLowerCase(), nextFrom);
          if(foundAt>=0){
            //set new nextFrom
            nextFrom = foundAt + word.length();
           
            //capitalize
            for(int pos=foundAt; pos<nextFrom; pos++){
              board[i][pos]=board[i][pos].toUpperCase();
            }
          }
        } while(foundAt >=0 && nextFrom < combined.length());
      }
     
      //Horizontal Right to left
     
      for(int i = 0; i<rows; i++){
        String combined = "";
        for(int j = cols - 1; j>=0; j--){
          combined = combined + board[i][j].toLowerCase();
        }
        int nextFrom = 0;
        int foundAt;
        do {
          foundAt = combined.indexOf(word.toLowerCase(), nextFrom);
          if(foundAt>=0){
            //set new nextFrom
            nextFrom = foundAt + word.length();
           
            //capitalize
            for(int pos= cols - nextFrom; pos<= cols - 1 - foundAt; pos++){
              board[i][pos]=board[i][pos].toUpperCase();
            }
          }
        } while(foundAt >=0 && nextFrom < combined.length());
      }
     
      //Vertical Top to Bottom
     
      for(int j = 0; j<cols; j++){
        String combined = "";
        for(int i = 0; i<rows; i++){
          combined = combined + board[i][j].toLowerCase();
        }
       
        int nextFrom = 0;
        int foundAt;
        do {
          foundAt = combined.indexOf(word.toLowerCase(), nextFrom);
          if(foundAt>=0){
            //set new nextFrom
            nextFrom = foundAt + word.length();
           
            //capitalize
            for(int pos=foundAt; pos<nextFrom; pos++){
              board[pos][j] = board[pos][j].toUpperCase();
            }
          }
        } while(foundAt >=0 && nextFrom < combined.length());
      }
     
      //Vetical Bottom to Top
     
      for(int j = 0; j<cols; j++){
        String combined = "";
        for(int i = rows - 1; i >= 0; i--){
          combined = combined + board[i][j].toLowerCase();
        }
       
        int nextFrom = 0;
        int foundAt;
        do {
          foundAt = combined.indexOf(word.toLowerCase(), nextFrom);
          if(foundAt>=0){
            //set new nextFrom
            nextFrom = foundAt + word.length();
           
            //capitalize
            for(int pos = rows - nextFrom ; pos<= rows -1- foundAt; pos++){
              board[pos][j] = board[pos][j].toUpperCase();
            }
          }
        } while(foundAt >=0 && nextFrom < combined.length());
      }
     
      //Diagonal top left to bottom right
     
      for(int k = rows -1; k>= 1-cols; k--){
        String combined = "";
        for(int i = 0; i< rows; i++){
          int j = i - k;
          if(j>=0 && j<cols){
            combined = combined + board[i][j].toLowerCase();
          }
        }
        int nextFrom = 0;
        int foundAt;
        do {
          foundAt = combined.indexOf(word.toLowerCase(), nextFrom);
          if(foundAt>=0){
            //set new nextFrom
            nextFrom = foundAt + word.length();
           
            //capitalize
            for(int x = foundAt; x< nextFrom; x++){
              board[x+k][x] = board[x+k][x].toUpperCase();
            }
          }
        } while(foundAt >=0 && nextFrom < combined.length());
       
      }
     
      //Diagonal top right to bottom left
     
    }
   
 
    //show results
    for(int i=0; i<rows; i++){
      for(int j=0; j<cols; j++){
        System.out.print(board[i][j]);
      }
      System.out.println();
    }
   
   
   
   
  }
}
