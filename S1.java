import java.util.HashMap;
import java.util.ArrayList;
import java.util.*;
import java.lang.Math;
import java.util.Scanner;
public class S1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Create a HashMap object called capitalCities
        HashMap<Double, Double> hm = new HashMap<Double, Double>();
        
        int num1 = input.nextInt();

      for(int i = 0; i<num1; i++){
        int time = input.nextInt();
        int pos = input.nextInt();
        hm.put(time, pos);
      }

        ArrayList<Double> times = new ArrayList<Double>(hm.keySet());
        Collections.sort(times);

        System.out.println(times);

        double maxSpeed = 0;

        Double prevTime = times.get(0);
        Double prevDist = hm.get(prevTime);

        for(int i = 1; i < hm.size(); i++){
            Double currTime = times.get(i);
            Double currDist = hm.get(currTime);
            Double deltaTime = Math.abs(prevTime - currTime);
            Double deltaDist = Math.abs(prevDist - currDist);
            Double currSpeed = deltaDist/deltaTime;
            if (currSpeed > maxSpeed){
                maxSpeed = currSpeed;
            }

            prevTime = currTime;
            prevDist = currDist;
        }

        System.out.println(maxSpeed);
    }
}