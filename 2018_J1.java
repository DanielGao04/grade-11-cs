import java.util.Scanner;

class J12018{
  
  public static void main(String[]args){
    
    int num1, num2, num3, num4;
    
    Scanner input = new Scanner(System.in);
  
    num1 = input.nextInt();
    num2 = input.nextInt();
    num3 = input.nextInt();
    num4 = input.nextInt();
    
    if((num1==8 || num1 == 9) && (num4 == 8 || num4 == 9) && (num3 == num2)){
      System.out.println("ignore");
      
    }else{

     System.out.println("anwser");
    }
    
  }
  
}