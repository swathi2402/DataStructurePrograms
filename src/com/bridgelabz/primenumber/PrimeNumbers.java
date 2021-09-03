package com.bridgelabz.primenumber;

import java.util.ArrayList;

public class PrimeNumbers {

	private static ArrayList<ArrayList<Integer>> primeNumbers() {
		ArrayList<ArrayList<Integer>> primeNumbers = new ArrayList<ArrayList<Integer>>();

		int dimension = 0;
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for (int number = 2; number <= 1000; number++) {

			boolean dimensionChange = true;
			for (int index = 2; index <= number / 2; index++) {
				if (number % index == 0)
					dimensionChange = false;
			}

			if (dimension < 99) {
				if (dimensionChange)
					arrayList.add(number);
				dimension++;
			} else {
				dimension = 0;
				primeNumbers.add(arrayList);
				arrayList = new ArrayList<Integer>();
				if (dimensionChange)
					arrayList.add(number);
				dimension++;
			}

		}
		primeNumbers.add(arrayList);
		return primeNumbers;
	}

	public static void main(String[] args) {
		System.out.println("Prime numbers between 1 to 1000:");
		ArrayList<ArrayList<Integer>> primeNumbers = primeNumbers();
		
		for (int index = 0; index < primeNumbers.size(); index++) {
			System.out.println(primeNumbers.get(index) + " ");
		}
	}

}
