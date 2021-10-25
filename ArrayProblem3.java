/** 
 * ARRAYProblem 3
 * Design a program that asks for 10 integers and
 * stores them in an integer array. It then 
 * creates a new array containing all the numbers 
 * of the original array which are prime numbers. 
 * Output the new array to the screen.
 */

class ArrayProblem3 { 

  public static void main(String[] args) { 
  
    int numberOfPrimes;
    
    //Get the input and store into an array
    int[] inputArray = {1,4,7,8 ,23, 29, 10, 67, 71, 73, 79, 8, 89, 97};
    
    numberOfPrimes = countPrimes(inputArray);  //determine number of primes
    
    int[] primeArray = new int[numberOfPrimes];  //create new array 
    int count=0;
    
    for(int i=0;i<inputArray.length;i++) {   // transfer all the prime numbers
      if (isPrime(inputArray[i])) {          // into the prime array
        primeArray[count]=inputArray[i];
        count++;
      }    
    }
    
    displayArray(primeArray);   //display the prime array to the screen
    
  }
  
  public static int countPrimes(int[] intArray) { 
  
    int count = 0;
    
    for(int i=0;i<intArray.length;i++) { 
      if (isPrime(intArray[i])) { 
        count++;
      }
    }
    return count;
  }
  
  public static void displayArray(int[] data) { 
    System.out.println("");
   for (int i = 2; i< data.length; i++) {  
     System.out.print(data[i]+" ");
   }
  }
  
  
  /**
   * isPrime
   * This method determines if an integer is prime
   * Note - This method should only be used with small numbers
   * @param number the number to test for primality
   * @return true if number is prime, otherwise false 
   */
  public static boolean isPrime(int number) { 
     
    for (int i = 2; i< number; i++) {     //question for students - How can this be more efficient?
      if(number % i == 0)  {
        return false;
      }
    }
  
    return true;
  }
  
}