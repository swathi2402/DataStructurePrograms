package com.bridgelabz.unorderedlist;

import java.util.Scanner;

import com.bridgelabz.linkedlist.MyLinkedList;
import com.bridgelabz.linkedlist.MyNode;

public class MyUnOrderedList {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the string: ");
		String inputString = scanner.nextLine();
		String[] wordsList = inputString.toLowerCase().split(" ");
		MyLinkedList<String> myLinkedList = new MyLinkedList<>();
		for (int index = 0; index < wordsList.length; index++) {
			MyNode<String> tempNode = new MyNode<>(wordsList[index]);
			if(myLinkedList.search(wordsList[index]) == null) {
				myLinkedList.append(tempNode);
			} else {
				myLinkedList.deleteAtRandom(tempNode);
			}
		}
		myLinkedList.printMyNodes();
		scanner.close();
	}

}
