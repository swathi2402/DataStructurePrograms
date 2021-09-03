package com.bridgelabz.balancedparenthese;

import java.util.Scanner;

import com.bridgelabz.linkedlist.MyNode;
import com.bridgelabz.stack.MyStack;

public class CheckParenthesesBalance {
	private static boolean checkParenthesesBalance(String expression) {
		MyStack<Character> myStack = new MyStack<Character>();
		for(int index = 0; index < expression.length(); index++) {
			char character = expression.charAt(index);
			if(character == '(') {
				MyNode<Character> tempNode = new MyNode<Character>(character);
				myStack.push(tempNode);
			} else if(character == ')') {
				if(myStack.isEmpty()) {
					return false;
				}
				myStack.pop();
			}
		}
		return myStack.isEmpty();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the expression: ");
		String inputString = scanner.nextLine();
		boolean isBalanced = checkParenthesesBalance(inputString);
		if(isBalanced) {
			System.out.println("The expression is perfectly balanced");
		}else {
			System.out.println("The expression is not balanced");
		}
		scanner.close();
	}


}
