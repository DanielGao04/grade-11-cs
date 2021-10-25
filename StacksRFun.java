import java.util.Stack;
  
  public class Stacks{
    
    public static void main(String[] args) {
      
      Stack<String> games = new Stack<String>();
      
      games.add("Call of duty");
      games.add("Agario");
      games.add("Bros");
      
      System.out.println(games.pop());
  
      System.out.println(games);
      
    }
  }

