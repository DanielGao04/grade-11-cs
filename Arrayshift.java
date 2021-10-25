import java.util.Scanner;

class Arrayshift{
  public static void main(String[]args){
    
    Scanner input = new Scanner(System.in);
    
    
    System.out.println("How many times do you want to run?");
    int end = input.nextInt();
    
    for(int j = 0; j<end; j++){ 
    System.out.println("How many elements are in the array");
    int elements = input.nextInt();
    int[] numbers = new int[elements];
    int[] numbers1 = new int[ elements];
    
    System.out.println("How much shifted");
    int shift = input.nextInt();
    
    System.out.println("Enter Numbers");
    for(int i = 0; i<elements; i++){
      numbers [i] = input.nextInt();
    }
    
    
    for(int i=0; i<elements; i++){
      int k = (i+shift) % elements;
      numbers1[i] = numbers[k];
      
    }
    
    for(int i=0; i<elements; i++){
      
      System.out.print(numbers1[i] + " ");
      
    }
    }
  }
}


