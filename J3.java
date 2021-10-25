import java.util.Scanner;
class J3{
  public static void main(String args[]) 
  {
    Scanner input = new Scanner(System.in);
    
    System.out.println("Enter how many coordinates");
    String looping = input.nextLine();
    
    int l = Integer.parseInt(looping);
    
    int maxX = -99999, maxY = -99999 , minX = 99999, minY = 99999;
    
    for(int i = 0; i<l; i++){
      
      String coordinate = input.nextLine();
      String[] parts = coordinate.split(",");
      
      String X = parts[0].trim();
      String Y = parts[1].trim();
      
      int x = Integer.parseInt(X);
      int y = Integer.parseInt(Y);
      
      if(x < minX){
        minX = x;
      }
      
      if(y < minY){
        minY = y;
      }
      
      if(x > maxX){
        maxX = x;
      }
      
      if(y > maxY){
        maxY = y;
      }
      
      
      
    }
    
    System.out.println((minX-1) + ", " + (minY-1)); 
    System.out.println((maxX+1) + ", " + (maxY+1));
    
    
  }
}