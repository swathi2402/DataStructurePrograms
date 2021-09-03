package com.bridgelabz.anagramcheck;

import java.util.ArrayList;
import java.util.Arrays;

import com.bridgelabz.linkedlist.INode;
import com.bridgelabz.linkedlist.MyNode;
import com.bridgelabz.stack.MyStack;

public class AangramCheckStack {

	private static ArrayList<Integer> printPrimeNumber() {
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

		ArrayList<Integer> primeNumbers = new ArrayList<Integer>();
		while (!myStack.isEmpty()) {
			INode<Integer> poppedNumber = myStack.pop();
			primeNumbers.add(poppedNumber.getKey());
		}
		return primeNumbers;
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

	static void findAnagram(ArrayList<Integer> primeList) {
		int sizeOfList = primeList.size();
		System.out.println("Prime number and anagram of prime number pair");
		for (int i = 0; i < sizeOfList; i++) {
			for (int j = i + 1; j < sizeOfList; j++) {
				if (isAnagram(primeList.get(i), primeList.get(j))) {
					System.out.println(primeList.get(i) + " " + primeList.get(j));
				}
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> primeNumbers = printPrimeNumber();
		findAnagram(primeNumbers);
	}

}
