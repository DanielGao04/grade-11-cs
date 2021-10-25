import java.util.*;

class PriorityQ {
  
  
  public static void main(String args[])
  {
    
    Scanner input = new Scanner(System.in);
    PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
    
    int size = input.nextInt();
    
    for(int i = 0; i< size; i++){
      int num = input.nextInt();
      pQueue.add(num);
      maxPQ.add(num);
    }
    
    System.out.println("The minimum value of the prioty queue is: " + pQueue.peek());
    System.out.println("The maximum value of the prioty queue is: " + maxPQ.peek());
    
    
  }
}