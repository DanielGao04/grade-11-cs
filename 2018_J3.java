import java.util.Scanner;

class J32018 {
  
  public static void main(String[] args){
    
    int d[] = new int[4];
    int c[] = new int[5];
   
    Scanner input = new Scanner(System.in);
    for (int i=0; i<4; i++){
      d[i] = input.nextInt();
    }
    
    c[0] = 0;
      for (int i = 1; i<5; i++) {
      c[i] = c[i-1] + d[i-1];
    }
    
    for (int i=0; i<5; i++){
      for (int j = 0; j<5; j++){
        int r = c[j] - c[i];
        if(r<0) r = r*-1;
        System.out.print(r);
        System.out.print(" ");
      }
      System.out.println();
    }
  }
}