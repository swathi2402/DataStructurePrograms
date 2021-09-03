package com.bridgelabz.orderedlist;

import java.util.Arrays;
import java.util.Scanner;

import com.bridgelabz.linkedlist.MyLinkedList;
import com.bridgelabz.linkedlist.MyNode;

public class OrderedList {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the string: ");
		String inputString = scanner.nextLine();
		String[] wordsList = inputString.split(" ");
		int[] intWordList = Arrays.stream(wordsList).mapToInt(Integer::parseInt).toArray();
		MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
		for (int index = 0; index < intWordList.length; index++) {
			MyNode<Integer> tempNode = new MyNode<>(intWordList[index]);
			if(myLinkedList.search(intWordList[index]) == null) {
				myLinkedList.orderedListAdd(tempNode);
			} else {
				myLinkedList.deleteAtRandom(tempNode);
			}
		}
		myLinkedList.printMyNodes();
		scanner.close();
	}
}
