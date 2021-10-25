import java.util.Scanner;
public class Method5b{
  public static void main (String[]Args){
    String first;
    Scanner input = new Scanner(System.in);
    System.out.println("Please enter your sentence");
    String sentence = input.nextLine();
    first = removeFirstWord(sentence);
    System.out.println("Here is your new sentence: " + first);
  }
  public static String removeFirstWord(String sentence){
    int i = sentence.indexOf(" ");
    String word = sentence.substring(0, i);
    String rest = sentence.substring (i);
    return rest;
  }
}