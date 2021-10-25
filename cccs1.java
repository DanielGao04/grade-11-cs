import java.util.HashMap;
import java.io.*;
import java.util.*;
import java.lang.Math;
import java.util.Scanner;

public class cccs1 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
 
    int tries = input.nextInt();
    int [] d = new int[tries];
    
    HashMap<Integer, Integer> hm = new HashMap<>();
    for(int i = 0; i< tries; i++){
      int time = input.nextInt();
      int pos = input.nextInt();
      d[i] = time;
      hm.put(time, pos);
    }
    
    Arrays.sort(d);
    double maxSpeed = 0;
    for(int i = 0; i< tries-1; i++){
      double time1 = hm.get(d[i]); 
      double time2 = hm.get(d[i+1]);
      double speed = (time2 - time1)/(d[i+1]-d[i]) ;
      if(speed<0){
        speed *= -1;
      }
      
      if (maxSpeed<speed){
        maxSpeed = speed;
      }
    }
    
    System.out.println(maxSpeed);
  }
}