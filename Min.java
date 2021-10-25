import java.util.Arrays;
//TO DO: Print below matrix
/*
 * 
 */

class Main {
  public static void main(String[] args) {
    
    int[][] arr1 = new int[7][7];
    
    for(int i = 0; i<= 6; i++){
      for(int j = 0; j<= 6; j++){
        arr1[i][j] = i+1;
        
        
        int[][] arr2 = new int[7][7];
        for(int w = 6; w>= 0; --w){
          for(int p = 0; p<= 6; p++){
            arr2[w][p] = w+1;
            
            result = addition(arr1, arr2);
            
            System.out.print(result);
            
          }
          System.out.println();
        }
      }
    }
    
    
    public static int[][] addition(int[][] arrF, int[][] arrS){
      
      for(int x = 0; x<=6; x++){
        for(int y = 0; y<=6; y++){
          int [][] result[x][y] = arrF[x][y] + arrS[x][y];
        }
        return result;
      }
    }
    
    
  }
}











