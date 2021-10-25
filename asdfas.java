//TO DO: Print below matrix
/*
 * 
 */

class Main {
  public static void main(String[] args) {
    
    int[][] arr = new int[3][3];
    
    for(int i = 0; i<=2; i++){
      for(int j = 0; j<=2; j++){
        
        arr[i][j] = i;
        
        if(i == j){
          arr[i][j] = 1;
          System.out.print(arr[i][j]);
        }
        else if(i != j){
          arr[i][j] = 0;
          System.out.print(arr[i][j]);
        }
        
      }
      
      System.out.println();
    }
    
    
  }
}