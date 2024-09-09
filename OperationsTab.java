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

import java.util.InputMismatchException;
import java.util.Scanner;

public class OperationsTab {
	static String MainString;
	public static Scanner input = new Scanner(System.in);
	static public Constants constant = new Constants();
	
	public static void main(String[] args) {
		System.out.println(constant.MENU_OPTIONS);
		String input_option = input.next();
		boolean isQuit = false; 
		do {
			switch(input_option) {
            case "1":
                System.out.println(constant.EXECUTING_CASE + "1");
                String inputString = input.next();
                char[] input1 = new char[inputString.length()];
                boolean[] used = new boolean[input1.length];
                for (int i = 0; i < inputString.length(); i++) {
                    input1[i] = inputString.charAt(i);
                }
                char[] result = new char[input1.length];
                for (int length = 1; length <= input1.length; length++) {
                    generateCombinations(input1, result, 0, used, length);
                }
                break;
            case "2":
                System.out.println(constant.EXECUTING_CASE + "2");
                while(true) {
                	try{
                		System.out.println(constant.ENTER_NUMBER);
                		int number = input.nextInt();
                		if(number < 0) {
                			System.out.println(constant.POSITIVE_NUMBER_ONLY);
                		}
                		else {
                			sumOfDigits(number);
                			break;
                		}
                		break;
                	}
                	catch(InputMismatchException e) {
                		System.out.println(constant.INVALID_INPUT);
                		input.next();
                	}
                }
            case "3":
                System.out.println(constant.EXECUTING_CASE + "3");
                break;
            case "4":
                System.out.println(constant.EXECUTING_CASE + "4");
                break;
            case "5":
                System.out.println(constant.EXECUTING_CASE + "5");
                break;
            case "6":
                System.out.println(constant.EXITING_PROGRAM);
                isQuit = true;
                break;
            default:
                System.out.println(constant.INVALID_INPUT);
                isQuit = false;
                break;
				}
			if(!isQuit) {
				System.out.println(constant.MENU_OPTIONS);
				input_option = input.next();
			}
		}while(!isQuit);
	}
	public static void generateCombinations(char[] input1, char[] result, int index, boolean[] used, int length) {
        if (index == length) {
            for (int i = 0; i < length; i++) {
                System.out.print(result[i]);
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < input1.length; i++) {
        	if (!used[i]) {
                used[i] = true;
                result[index] = input1[i]; 
                generateCombinations(input1, result, index + 1, used, length);
                used[i] = false;
            } 
        }
    }
	public static void sumOfDigits(int n) {
		int number = n;
		int sum = 0;
		while(number != 0) {
			sum = sum + (number%10);
			number /= 10;
		}
		if(sum > 9) {
			sumOfDigits(sum);
		}
		else {
			System.out.println(sum);
		}
	}

}
