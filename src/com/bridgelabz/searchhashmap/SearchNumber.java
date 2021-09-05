package com.bridgelabz.searchhashmap;

import java.util.Arrays;
import java.util.Scanner;

import com.bridgelabz.hashtables.MyLinkedHshMap;

public class SearchNumber {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the numbers: ");
		String inputString = scanner.nextLine();
		String[] wordsList = inputString.toLowerCase().split(" ");
		int[] intWordList = Arrays.stream(wordsList).mapToInt(Integer::parseInt).toArray();
		MyLinkedHshMap<Integer, Integer> myLinkedHshMap = new MyLinkedHshMap<>();
		for (int index = 0; index < intWordList.length; index++) {
			Integer value = myLinkedHshMap.get(intWordList[index]);
			if (value == null) {
				value = 1;
				myLinkedHshMap.add(intWordList[index], value);
			} else {
				myLinkedHshMap.remove(intWordList[index]);
			}
		}
		System.out.println(myLinkedHshMap);
		scanner.close();

	}
}
