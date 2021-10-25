/**[FormativeMethods.java]
  * a program that calculates volume and area of shapes 
  * @Author Daniel Gao
  * @Version 1
  * November 24th 2020
  */

import java.util.Scanner;

public class FormativeMethods{
  public static void main(String[]args){
    
    Scanner input = new Scanner(System.in);
    
    System.out.println("What whould you like to find:" + '\n' +
                       "1. area of a rectangle" + '\n' +
                       "2. area of a circle" + '\n' +
                       "3. area of a triangle" + '\n' +
                       "4. volume of a rectangular prism" + '\n' +
                       "5. volume of sphere" + '\n' + 
                       "6. volume of a cylinder" + '\n' + 
                       "7. volume of a right circular cone" + '\n' + 
                       "8. Quit");
    
    int choose = input.nextInt();
    
    if (choose == 1) {
      
      System.out.println("Please enter the length of the rectangle");
      int length = input.nextInt();
      
      System.out.println("Please enter the width of the rectangle");
      int width = input.nextInt();
      
      int rec;
      rec = area(length, width);
      
      System.out.println("The area of your rectangle is " + rec);
    }
    
    else if (choose == 2) {
      System.out.println("Please enter the radius of the circle");
      double radius = input.nextInt();
      
      double circ;
      circ = circle(radius);
      
      System.out.println("The area of your circle is " + circ);
    }
    
    else if(choose == 3) {
      System.out.println("Please enter the base of the triangle");
      int base = input.nextInt();
      
      System.out.println("Please enter the height of the triangle");
      int height = input.nextInt();
      int tri;
      
      tri = triangle(base, height);
      System.out.println("The area of your triangle is " + tri);
      
    }
    
    else if(choose == 4) {
      System.out.println("Please enter the base of the triangle");
      int lengthS = input.nextInt();
      
      System.out.println("Please enter the height of the triangle");
      int widthS = input.nextInt();
      
      System.out.println("Please enter the height of the triangle");
      int heightS = input.nextInt();
      
      int rect;
      rect = rectangular(lengthS, widthS, heightS);
      
      System.out.println("The volume of your rectangular prism is " + rect);
    }
    
    else if(choose == 5) {
      System.out.println("Please enter the radius of the sphere");
      double radiusS = input.nextInt();
      
      double sph;
      sph = sphere(radiusS);
      
      System.out.println("The volume of your sphere is " + sph);
    }
    
    else if(choose == 6) {
      System.out.println("Please enter the radius of the cylinder");
      double radiusC = input.nextInt();
      
      System.out.println("Please enter the height of the cylinder");
      double heightC = input.nextInt();
      
      double cylin;
      cylin = cylinder(radiusC, heightC);
      
      System.out.println("The volume of your cylinder is " + cylin);
      
    }
    
    else if(choose == 7) {
      System.out.println("Please enter the radius of the cone");
      double radiusCo = input.nextInt();
      
      System.out.println("Please enter the height of the cone");
      double heightCo = input.nextInt();
      
      double co;
      co = cone(radiusCo, heightCo);
      
      System.out.println("The volume of your cone is " + co);
      
    }
    
    else if(choose == 8) {
      System.out.println("Bye!"); 
    }
  }
  
  public static int area(int length, int width) {
    int area;
    area = (length * width);
    return area;
  }
  
  public static double circle(double radius){
    double areaC;
    areaC = (3.14*radius*radius);
    return areaC;
  }
  
  public static int triangle(int base, int height){
    int areaT;
    areaT = ((base*height)/2);
    return areaT;
  }
  
  public static int rectangular(int widthS, int heightS, int lengthS){
    int volR;
    volR = (lengthS*widthS*heightS);
    return volR;
  }
  
  public static double sphere(double radiusS){
    double volS;
    volS = ((4.0000000000/3.0000000000)*3.14*(radiusS*radiusS*radiusS));
    return volS;
  }
  
  public static double cylinder(double radiusC, double heightC) {
    double volC;
    volC = ((3.14*radiusC*radiusC)*heightC);
    return volC;
  }
  
  public static double cone(double radiusCo, double heightCo) {
    double volCo;
    volCo = ((3.14*radiusCo*radiusCo)*(heightCo/3.00000000000000));
    return volCo;
  }
  
}