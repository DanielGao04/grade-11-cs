import java.util.LinkedList;
import java.util.Queue;

public class QueueP {
  
  public static void main(String[] args){
    
    Queue<String> bbqLine = new LinkedList<String>();
    
    bbqLine.add("Daniel");
    bbqLine.add("Tyrone");
    bbqLine.add("Bob");
    bbqLine.add("Jack");
    
    bbqLine.poll();
    
    bbqLine.add("Alan");
    
    System.out.println(bbqLine.peek() + " is first in line");
    System.out.println(bbqLine);
    
  }
}
    
    