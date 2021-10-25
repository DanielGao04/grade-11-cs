import java.util.Arrays;
import java.util.Random;
public class puzzle {
   public static void main(String[] args) {
      char arr[][] = new char[3][3];
      Random randNum = new Random();
      for (int i = 0; i < 3; i++) {
         for (int j = 0; j < 3; j++) {
            int x = randNum.nextInt(3);
            switch (x) {
               case 0: {
                  arr[i][j] = 'p';
                  break;
               }
               case 1: {
                  arr[i][j] = 'q';
                  break;
               }
               case 2: {
                  arr[i][j] = 'r';
                  break;
               }
               case 3: {
                  arr[i][j] = 's';
                  break;
               }
               case 4: {
                  arr[i][j] = 't';
                  break;
               }
               case 5: {
                  arr[i][j] = 'u';
                  break;
               }
               case 6: {
                  arr[i][j] = 'v';
                  break;
               }
               case 7: {
                  arr[i][j] = 'w';
                  break;
               }
            }
         }
      }
      System.out.println("Random alphabets...");
      System.out.println(Arrays.deepToString(arr));
   }
}