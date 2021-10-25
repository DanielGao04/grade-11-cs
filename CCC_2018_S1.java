import java.util.*;
class Main {
  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);
    
    int amount = input.nextInt();
    int point[] = new int[amount];
    
    for (int i = 0; i<amount; i++){
      point[i] = input.nextInt();
    }
    
    Arrays.sort(point);
    
    
    double leftSize = 0; 
    double rightSize = 0;
    double smallestSize = Integer.MAX_VALUE;
    
    for(int i = 1; i<amount-1; i++){
      int leftDiff = point[i] - point[i-1];
      leftSize = leftDiff/2.0;
      int rightDiff = point[i+1] - point[i];
      rightSize = rightDiff/2.0;
      if(leftSize + rightSize < smallestSize){
        smallestSize = leftSize + rightSize;
      }
    }
  
    System.out.println(smallestSize);
    
  }
}