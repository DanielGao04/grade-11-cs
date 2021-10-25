import java.util.Scanner;
class trueorfalse{
  public static void main(String[]args){
    Scanner input = new Scanner(System.in);
    int num;
    System.out.println("Please enter a number");
    num = input.nextInt();
    int value;
    value = trueorfalse(num);
    System.out.println(value);
    System.out.println("If the number printed above is a one then your interger is prime. If the number printed above is 0 then it is a non prime");
  }
  public static int trueorfalse(int num) {
    int prime = -1;
    for (int i = 2; 1 <= num/2; ++i){
      if(num%i == 0){
        prime = 0;
    }
    else{
      prime = 1;
    }

  }
    return prime;
  
  }
}