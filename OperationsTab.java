/*
 * Name : Rahul Ganeshwar Patil
 * Date : 09/09/2024
 * 
 * Problem 1: Valid Parentheses Combination Generator
 * Description :
 * [ Write a Java program that generates all valid combinations of the string pairs of
   parentheses. Each combination should be unique and well-formed. ]
 * Example 1:
	Input: n = ab
	Output: [“a”,”b”,”ab”,”ba”]
   Example 2:
	Input: n = abc
	Output: [“a”,”b”,”c”,”ab”,”ac”,”ba”,”bc”,”ca”,”cb”....]
 * 
 * 
 * Problem 2: Digit Sum Loop(String)
 * Description :
 * [ Write a Java program that continuously takes a number as input and replaces it with the sum of
	its digits until the number is reduced to a single digit. ]
 * Example 1:
	Input: 9875
	Output: 2 (Explanation: 9+8+7+5=29, 2+9=11, 1+1=2)
 *
 * 
 * Problem 3: Consecutive Number Summer
 * Description :
 * [ Write a Java program that finds whether a given number can be expressed as the sum of two or
	more consecutive natural numbers. If possible, the program should print all possible
	combinations of consecutive natural numbers that sum up to the given number. ]
 * Example:
	Input: 15
	Output:
	1 + 2 + 3 + 4 + 5
	4 + 5 + 6
	7 + 8
 * 
 * 
 * Problem 4: Caesar Cipher with Shift Variability
 * Description :
 * [ Write a program that implements the Caesar Cipher encryption technique
	but with a twist. The program should take an input string and a shift pattern array. For
	each character in the string, apply the corresponding shift value from the pattern array. If
	the pattern array length is shorter than the input string, repeat the pattern. ]
 * Example:
	Input: "HELLO WORLD", Shift Pattern: [1, 2, 3]
	Output: "IFMMP XPSME" (Shifts: 'H' +1, 'E' +2, 'L' +3, 'L' +1, 'O' +2, etc.)
 * 
 * 
 * Problem 5: Encoding Challenge with ASCII Conversion
 * Description:
	[ Write a Java program that takes an unsorted array of digits and a series of integers. It encodes
	the highest digits, based on the provided series, into their corresponding ASCII characters. ]
	Example:
	 Input: Array: 2315, Series: 123
	 Output: "535150"
	 Explanation: The three highest numbers 5, 3, 2 are converted to ASCII characters.
 * **/

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OperationsTab {
	static String MainString;
	public static Scanner input = new Scanner(System.in);
	//static public Dependencies dependency = new Dependencies();
	
	public static void main(String[] args) {
		System.out.println("1. Valid Parenthesis Combination Generator\r\n"
				+ "2. Digit Sum Loop\r\n"
				+ "3. Consecutive Number Summer\r\n"
				+ "4. Caesar Cipher with Shift Variability\r\n"
				+ "5. Encoding Challenge with ASCII Conversion\r\n"
				+ "6. Exit From the Program");
		String input_option = input.next();
		boolean isQuit = false; 
		do {
			switch(input_option) {
            case "1":
                System.out.println("Executing Case 1 :");
                allSubstrings();
                break;
            case "2":
                System.out.println("Executing Case 2 :");
                int number = input.nextInt();
                
                break;
            case "3":
                System.out.println("Executing Case 3 :");
                break;
            case "4":
                System.out.println("Executing Case 4 :");
                break;
            case "5":
                System.out.println("Executing Case 5 :");
                break;
            case "6":
                System.out.println("Exiting from program :");
                isQuit = true;
                break;
            default:
                System.out.println("Invalid input");
                isQuit = false;
                break;
				}
			if(!isQuit) {
				System.out.println("1. Valid Parenthesis Combination Generator\r\n"
						+ "2. Digit Sum Loop\r\n"
						+ "3. Consecutive Number Summer\r\n"
						+ "4. Caesar Cipher with Shift Variability\r\n"
						+ "5. Encoding Challenge with ASCII Conversion\r\n"
						+ "6. Exit From the Program");
				input_option = input.next();
			}
		}while(!isQuit);
	}
	public static void allSubstrings() {
		while (true) {
            try {
                System.out.println("Enter String Whose Substring is to be found : ");
                String string = input.next();
                for(int i = 0; i < string.length();i++) {
                	if(Character.isDigit(string.charAt(i))) {
                		System.out.println("Enter only Characters!!");
                		break;
                	}
                }
                
             }
            catch(InputMismatchException e) {
            	System.out.println("Invalid Input");  
            	break;
            }
	}
	}
	public static void sumOfDigits(int n) {
		int number = n;
		int sum = 0;
		while(number != 0) {
			int rem = number % 10;
			sum = sum + rem;
			number /= 10;
		}
		if(number < 9) {
			
		}
		
	}

}
