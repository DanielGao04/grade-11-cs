//TO DO: Print below matrix
/*
 * 
 */

class Min {
  public static void main(String[] args) {
    
    int[][] arr1 = new int[7][7];
    
    for(int i = 0; i<= 6; i++){
      for(int j = 0; j<= 6; j++){
        arr1[i][j] = i+1;
    System.out.print(arr1[i][j]);
      }
      System.out.println();
    }
    
    
    int[][] arr2 = new int[7][7];
    for(int w = 6; w>= 0; --w){
      for(int p = 0; p<= 6; p++){
        arr2[w][p] = w+1;

System.out.print(arr2[w][p]);

      }
      System.out.println();
  }

    
    
    
    
    
  }
}