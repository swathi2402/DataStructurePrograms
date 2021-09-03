package com.bridgelabz.palindronecheck;

import java.util.Scanner;

import com.bridgelabz.linkedlist.MyNode;
import com.bridgelabz.queue.MyDeque;

public class PalindromeChecker {

	private static boolean palindromeChecker(char[] charArray) {
		MyDeque<Character> myDeque = new MyDeque<>();
		for (char character : charArray) {
			MyNode<Character> tempNode = new MyNode<Character>(character);
			myDeque.addRear(tempNode);
		}
		while (myDeque.size() > 1) {
			if (myDeque.size() == 2) {
				if (myDeque.removeFront().getKey() == myDeque.removeRear().getKey())
					return true;
				else
					return false;
			}
			if (myDeque.removeFront().getKey() != myDeque.removeRear().getKey()) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the string: ");
		String inputString = scanner.nextLine();
		char[] charArray = inputString.toCharArray();
		boolean isPalindrome = palindromeChecker(charArray);
		if (isPalindrome) {
			System.out.println("The word is palindrome");
		} else {
			System.out.println("The word is not palindrome");
		}
		scanner.close();
	}

}
