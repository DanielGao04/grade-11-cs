import java.io.File;
import java.util.Scanner;

public class ReadDatas {
public static void main(String[] args) throws Exception {
  
File file = new File("summerschool.txt"); 
Scanner input = new Scanner(file); 

String firstName;

int avg;

while (input.hasNext()) { 
firstName = input.next();
avg = input.nextInt();
System.out.println(firstName + " " + avg);
}
input.close(); 
}
}