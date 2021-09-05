package com.bridgelabz.anagramcheck;

import java.util.ArrayList;
import java.util.Arrays;

import com.bridgelabz.linkedlist.INode;
import com.bridgelabz.linkedlist.MyNode;
import com.bridgelabz.stack.MyStack;

public class AnagramCheckStack {

	private static MyStack<Integer> getPrimeNumber() {
		MyStack<Integer> myStack = new MyStack<Integer>();
		for (int number = 2; number <= 1000; number++) {
			boolean flag = true;
			for (int index = 2; index <= number / 2; index++) {
				if (number % index == 0) {
					flag = false;
				}
			}
			if (flag) {
				MyNode<Integer> tempNode = new MyNode<Integer>(number);
				myStack.push(tempNode);
			}
		}
		return myStack;

	}

	static boolean isAnagram(int firstInteger, int secondInteger) {
		String firstString = String.valueOf(firstInteger);
		String secondString = String.valueOf(secondInteger);
		if (firstString.length() != secondString.length())
			return false;
		char[] firstCharArray = firstString.toCharArray();
		char[] secondCharArray = secondString.toCharArray();

		Arrays.sort(firstCharArray);
		Arrays.sort(secondCharArray);

		return Arrays.equals(firstCharArray, secondCharArray);

	}

	static void findAnagram(MyStack<Integer> primeStack) {
		int sizeOfList = primeStack.size();
		ArrayList<Integer> primeNumbers = new ArrayList<Integer>();
		while (!primeStack.isEmpty()) {
			INode<Integer> poppedNumber = primeStack.pop();
			primeNumbers.add(poppedNumber.getKey());
		}
		System.out.println("Prime number and anagram of prime number pair");
		for (int i = 0; i < sizeOfList; i++) {
			for (int j = i + 1; j < sizeOfList; j++) {
				if (isAnagram(primeNumbers.get(i), primeNumbers.get(j))) {
					System.out.println(primeNumbers.get(i) + " " + primeNumbers.get(j));
				}
			}
		}
	}

	public static void main(String[] args) {
		MyStack<Integer> primeStack = getPrimeNumber();
		findAnagram(primeStack);
	}

}
