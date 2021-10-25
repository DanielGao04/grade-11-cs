public class Msadasdan {
  public static void main(String[] args) {
    multiply(2,5);
    multiply(7,4);
    multiply(1,8);
    
    System.out.println("---");
    
    divide(4,2);
    divide(25,5);
    divide(10,2);
    
    System.out.println("---");
    
    agecheck(12);
    
  }
  
  public static void agecheck(int age) {
    if(age<18){
      System.out.println("You are not old enough");
    }
    
      else{
        System.out.println("You are old enough");
    }
  }
    
    public static void multiply(int a, int b) {
      System.out.println(a * b);
    }
    
    
    public static void divide(int a, int b){
      System.out.println(a / b);
      
    }
  }