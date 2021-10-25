import java.util.Scanner;

class J22018{
  
  public static void main(String[]args){
    int num, counter = 0; 
    String y, t;
    
    Scanner input = new Scanner(System.in);
    num = Integer.parseInt(input.nextLine());
    y = input.nextLine();
    t = input.nextLine();
    
    for(int i = 0; i<y.length(); i++){
      if(y.charAt(i) == t.charAt(i) && y.charAt(i) == 'C'){
        counter++;
        
      }
    }
     System.out.println(counter); 
  }
}