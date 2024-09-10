/*
 * Name : Rahul Ganeshwar Patil
 * Date : 09/09/2024
 * 
 * Problem 1 : Valid Parentheses Combination Generator - Write a Java program that generates all valid combinations of the string pairs of
   parentheses. Each combination should be unique and well-formed. 
 * 
 * Problem 2 : Digit Sum Loop(String) - Write a Java program that continuously takes a number as input and replaces it with the sum of
	its digits until the number is reduced to a single digit. 
	
 * Problem 3 : Consecutive Number Summer - Write a Java program that finds whether a given number can be expressed as the sum of two or
	more consecutive natural numbers. If possible, the program should print all possible combinations of consecutive natural numbers that sum up to the given number. 
 * 
 * Problem 4: Caesar Cipher with Shift Variability - It encrypts our string with increase/decrease in ASCII value through shift function
 * 
 * Problem 5: Encoding Challenge with ASCII Conversion - Write a Java program that takes an unsorted array of digits and a series of integers. It encodes
	the highest digits, based on the provided series, into their corresponding ASCII characters.
 ***/

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;


public class OperationsTab {
	static String MainString;
	public static Scanner input = new Scanner(System.in);
	static public Constants constant = new Constants();
	
	public static void main(String args[]) {
		System.out.println(constant.MENU_OPTIONS);
		String input_option = input.next();
		boolean isQuit = false; 
		do {
			switch(input_option) {
            case "1":
                System.out.println(constant.EXECUTING_CASE + "1");
                System.out.println(constant.ENTER_STRING);
                input.nextLine();
                String inputString = input.nextLine();
                if(inputString == null || inputString.isEmpty()) {
                	
                }
                char[] input1 = new char[inputString.length()];
                boolean[] used = new boolean[input1.length];
                for (int i = 0; i < inputString.length(); i++) {
                    input1[i] = inputString.charAt(i);
                }
                char[] result = new char[input1.length];
                for (int length = 1; length <= input1.length; length++) {
                	generateStrings(input1, result, 0, used, length);
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
                break;
            case "3":
                System.out.println(constant.EXECUTING_CASE + "3");
                while (true) {
                	try {
                		System.out.println(constant.ENTER_NUMBER);
                		int number = input.nextInt();
                		if(number < 0) {
                			System.out.println(constant.POSITIVE_NUMBER_ONLY);
                		}
                		else {
                			consecutiveSum(number);
                			break;
                		}
                		
                	}
                	catch(InputMismatchException e) {
                		System.out.println(constant.INVALID_INPUT);
                		break;
                	}
                }
                break;
            case "4":
                System.out.println(constant.EXECUTING_CASE + "4");
                break;
            case "5":
                System.out.println(constant.EXECUTING_CASE + "5");
                asciiConversion();
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
	//This Function is used to generate all sub-strings 
	//Parameters include character array which stores every element of given String
	//Resultant array which stores all possible substrings
	//Index is used for keeping track of resultant array
	//Used array is used to remove duplicates
	//Length is used to traverse through to the character input array
	public static void generateStrings(char[] input1, char[] result, int index, boolean[] used, int length) {
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
                System.out.println("hello");
                generateStrings(input1, result, index + 1, used, length);
                used[i] = false;
            } 
        }
    }	
	//Sum of digits function is used to print the sum of all the digits until we left with one digit number
	//This is recursive function which uses number as parameter
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


	//Consecutive sum prints all the possible consecutive numbers which sum up to target
	public static void consecutiveSum(int target) {
		boolean found = false;
		for(int index = 2; index <= target / 2; index++) {
			int result = target - ((index * (index - 1)) / 2);
			
			if(result % index == 0) {
				int n = result / index;
				if(n > 0) {
					found = true;
					printResult(n, index);
				}
			}
		}	
		if(!found) {
			System.out.println(constant.NOT_FOUND);
		}
	}
	//Print result function is used to print consecutive numbers with addition sign
	//It uses number n and length for printing 
	public static void printResult(int n, int length) {
		String result = "";
		for(int j = 0; j < length ; j++) {
			result += n + j;
			if(j < length - 1) {
				result += "+";
			}
		}
		System.out.println(result);		
	}
	
	//ASCII conversion function takes highest elements according to the length of series and then convert them into ascii values of that elements.
	public static void asciiConversion() {
		try{
			System.out.println(constant.ENTER_SIZE + "array : ");
			int size1 = input.nextInt();
			if(size1 <= 0) {
				System.out.println(constant.BOUND_ERROR);
				return;
			}
			System.out.println(constant.ENTER_SIZE + "series : ");
			int size2 = input.nextInt();
			if(size2 <= 0) {
				System.out.println(constant.BOUND_ERROR);
				return;
			}
			else if(size2 > size1) {
				System.out.println(constant.BOUND_ERROR);
				return;
			}
			else{
				int[] array = new int[size1];
				System.out.println(constant.ENTER_ELEMENTS + "array :");
				for(int i = 0; i < size1; i++) {
					array[i] = input.nextInt();
				}
				int[] series = new int[size2];
				System.out.println(constant.ENTER_ELEMENTS + "series : ");
				for(int i = 0; i < size2; i++) {
					series[i] = input.nextInt();
				}
				Arrays.sort(array);
				reverse(array);
				String result = "";
				for(int i = 0; i < size2; i++) {
					result += array[series[i] - 1] + 48;
				}
				System.out.println(result);
			}
		}
		catch(InputMismatchException e) {
			System.out.println(constant.INVALID_INPUT);
		}
		
	}
	
	//This function is used to reverse the array
	public static void reverse(int[] array)
    {
        int n = array.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = array[i];
            array[i] = array[n - i - 1];
            array[n - i - 1] = temp;
        }
    }
	
	//
	
	public static void shiftVariability() {
		
	}
	public static void shift(){
        System.out.println(constant.MOVE_CHARACTER);
        int FrequencyOfMoving;
        while (true) {
            try {
                System.out.println(constant.MOVE_CHARACTER);
                FrequencyOfMoving = input.nextInt();
                if (FrequencyOfMoving < 0) {
                    System.out.println(constant.POSITIVE_NUMBER_ONLY);
                }else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println(constant.INVALID_INPUT);
                input.next();
            }
        }
        String firstString = "";
        String secondString = "";
        int stringlength = MainString.length();
        for (int i = MainString.length() - 1; i >=0 ; i--) {
            if (i >= stringlength-(FrequencyOfMoving%stringlength)) {
                firstString += MainString.charAt(i);
            }else{
                secondString += MainString.charAt(i);
            }
        }
        firstString = reverse1(firstString);
        secondString = reverse1(secondString);
        System.out.println(firstString+secondString);
    }
	public static String reverse1(String MainString){
        String newString = "";
        for (int i = MainString.length()-1; i >=0 ; i--) {
            char currentLastChar = MainString.charAt(i);
            newString += currentLastChar;
        }
        
        return newString;
    }
}