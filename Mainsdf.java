import java.util.Arrays;
//TO DO: Print below matrix
/*
 * 
 */

class Main {
  public static void main(String[] args) {
    
    int[][] arr1 = new int[7][8];
    int[][] arr2 = new int[7][8];
    int[][] arr = new int[7][8];
    
    for(int i = 0; i<= 6; i++){
      for(int j = 0; j<= 7; j++){
        arr1[i][j] = i+1;
        System.out.print(arr1[i][j]);
      }
      System.out.println();
    }
    
    System.out.println("---------------");
     for(int i = 0; i<= 6; i++){
      for(int j = 0; j<= 7; j++){
        arr2[i][j] =7-i;
        System.out.print(arr2[i][j]);
      }
      System.out.println();
    }
   System.out.println("---------------");
    
    for(int i = 0; i<= 6; i++){
      for(int j = 0; j<= 7; j++){
        arr[i][j] = arr1[i][j]+arr2[i][j];
       
        System.out.print(arr[i][j]);
      }
      System.out.println();
    }

    System.out.println("---------------");
    
    for(int i = 0; i<= 6; i++){
      for(int j = 0; j<= 7; j++){
        arr[i][j] = 2*(arr1[i][j])+arr2[i][j];
       
        System.out.print(arr[i][j]);
      }
      System.out.println();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  }
}













