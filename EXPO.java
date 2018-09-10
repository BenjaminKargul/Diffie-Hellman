/** Helper Class for modular exponentiation **
 * Author: Kargul, Benjamin
 * 9/15/2017
 */

public class EXPO{
  public static int exponentiate(int number, int exponent, int modulus){
    //base case: exponenet = 0
    if(exponent == 0){
      return 1 % modulus;
    }
    //base case: exponent = 1
    if(exponent == 1){
      return number % modulus;
    }
    
    int e = 1;
    int current;
    long c = number;
    
    //decimal to binary
    String binary = Integer.toString(exponent,2);
    
    //go through each bit left to right
    for(int i = 1; i<binary.length()+1; i++){

      
      //binary to decimal
      current = Integer.parseInt(binary.substring(0,i),2);
      

      if(current == 1) current = 2;
      
      if( current / 2 >= e){
        c = (c * c) % modulus;
        e = e * 2;
      }
      if( current - 1 == e ){
        
        c = (c * number) % modulus;
        e++;
      }
     
    }
    
    return (int) c;
  }
}