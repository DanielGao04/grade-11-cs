import java.util.Scanner;
class wordfirst{
  public static void main (String[]Args){
    String first;
    Scanner input = new Scanner(System.in);
    System.out.println("Please enter your sentence");
    String sentence = input.nextLine();
    first = getFirstWord(sentence);
    System.out.println("The first word of the sentence is " + first);
  }
  public static String getFirstWord(String sentence){
    int i = sentence.indexOf(" ");
    String word = sentence.substring(0, i);
    return word;
  }
}