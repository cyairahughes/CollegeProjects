/*  PalindromeCheck
	Determines if a 4-digit number is a palindrome
	Cyaira Hughes
	Febuary 4, 2020
	255-901
*/

import java.util.Scanner;
public class PalindromeCheck {
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Tells user to enter either a 0 to enter a 4-digit number or 1 to have a random generated number
		
		System.out.println("Enter 0 if you would like to enter a 4-digit number.  Enter 1 if you would like to have the computer generate it.");
		int number = input.nextInt();
		
		// If the number entered was 0 the program will tell the user to enter a 4-digit number
		
		if (number == 0){
			System.out.println("Enter the 4-digit number:");
			int fourDigitNumber = input.nextInt();
				
				// If the 4-digit number entered is not a 4-digit number the output would be "incorrect input"
				
				if (fourDigitNumber <= 999 || fourDigitNumber > 9999){
					System.out.println("Incorrect input");
					
				}
				
				/* Assigns a to the first digit of the 4-digit number, b to the second digit, c to the 
				   third and d to the fourth */
				
			int a = ((fourDigitNumber / 1000) % 10);
			int b = ((fourDigitNumber / 100) % 10);
			int c = ((fourDigitNumber / 10) % 10);
			int d = ((fourDigitNumber / 1) % 10);
		    
				// If the first digit of the 4-digit number is 0 the output would be "incorrect input"
				
				if (a == 0){
					System.out.println("Incorrect input");
				}
				
				/* If a is not equal to zero, a is equal to d and b is equal to c the output would be 
				   that the 4-digit number is a palindrome */
				
				if (a != 0 && a == d && b == c ) {
					
					System.out.println(fourDigitNumber + " is a palindrome");
				
				}
	
				/* If a is not equal to zero, a is not equal to d, b is not equal to c and the 4-digit 
				number is not a 4-digit number the output would be that the 4-digit number is not a palindrome */
				
				if (a != 0 && a != d && b != c && fourDigitNumber > 999 && fourDigitNumber <= 9999 ) {
					
					System.out.println(fourDigitNumber + " is not a palindrome");
				}
				
				/* If a is not equal to 0, a is not equal to d or b is not equal to c then 
				   the output would be that the 4-digit number is not a palindrome */ 
				
				if (a != 0 && a != d || b != c){
					System.out.println(fourDigitNumber + " is not a palindrome");
				}
}	
        // If the number entered was 1 the program will generate a random number

		else if (number == 1){	
			int randomFourDigitNumber = (int)(Math.random() * 9000) + 1000;
			
			/* Assigns a to the first digit of the random number , b to the second digit, c to the 
			   third and d to the fourth */
			
			int a = ((randomFourDigitNumber / 1000) % 10);
			int b = ((randomFourDigitNumber / 100) % 10);
			int c = ((randomFourDigitNumber / 10) % 10);
			int d = ((randomFourDigitNumber / 1) % 10);
			
	          // If a is equal to d and b is equal to c then the random number is a palindrome
			
				if (a == d && b == c) {
					
					System.out.println(randomFourDigitNumber + " is a palindrome");
				
				}
				
				/* If the a is not equal to d and b is equal to c then the output would be the random 
				   number followed by the random number is not a palindrome */
				
				else {
					System.out.println(randomFourDigitNumber);
					System.out.println(randomFourDigitNumber + " is not a palindrome");
				}
		}	
		
		// If the number entered was not either a 0 or 1 the output would be "incorrect input" 
		
		else {
			System.out.println("Incorrect input");
		
		}
	
  } 
} 
