import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    
    int[][] arr1 = new int[5][5];
    int[][] arr2 = new int[5][5];
    
    for(int i = 0; i<= 4; i++){
      for(int j = 0; j<= 4; j++){
        arr1[i][j] = i+1;
      System.out.print(arr1[i][j]);
      }
      System.out.println();
    }

System.out.println("-----------");

    for(int i = 0; i<= 4; i++){
      for(int j = 0; j<= 4; j++){
        arr2[i][j] = arr1[j][i];

        System.out.print(arr2[i][j]);
      }
      System.out.println();
    }
    
  }
}













