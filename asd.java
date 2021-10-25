import java.util.HashMap;
import java.util.ArrayList;
import java.util.*;
import java.lang.Math;

public class asd {
  public static void main(String[] args) {
    // Create a HashMap object called capitalCities
    HashMap<Double, Double> hm = new HashMap<Double, Double>();

    // Add keys and values (Country, City)
//    hm.put(0.0, 100.0);
//    hm.put(20.0, 50.0);
//    hm.put(10.0, 120.0);
    
    hm.put(20.0, -5.0);
    hm.put(0.0, -17.0);
    hm.put(10.0, 31.0);
    hm.put(5.0, -3.0);
    hm.put(30.0, 11.0);
    
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

