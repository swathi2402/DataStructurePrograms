package com.bridgelabz.anagramcheck;

import java.util.ArrayList;
import java.util.Arrays;

import com.bridgelabz.linkedlist.INode;
import com.bridgelabz.linkedlist.MyNode;
import com.bridgelabz.queue.MyQueue;

public class AnagramCheckQueue {

	private static MyQueue<Integer> getPrimeNumber() {
		MyQueue<Integer> myQueue = new MyQueue<Integer>();
		for (int number = 2; number <= 1000; number++) {
			boolean flag = true;
			for (int index = 2; index <= number / 2; index++) {
				if (number % index == 0) {
					flag = false;
				}
			}
			if (flag) {
				MyNode<Integer> tempNode = new MyNode<Integer>(number);
				myQueue.enqueue(tempNode);
			}

		}

		return myQueue;
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

	static void findAnagram(MyQueue<Integer> primeQueue) {
		int sizeOfList = primeQueue.size();
		ArrayList<Integer> primeNumbers = new ArrayList<Integer>();
		while (!primeQueue.isEmpty()) {
			INode<Integer> poppedNumber = primeQueue.dequeue();
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
		MyQueue<Integer> primeNumbers = getPrimeNumber();
		findAnagram(primeNumbers);
	}
}
