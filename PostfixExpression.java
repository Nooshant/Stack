package com.duke.stack;

import java.util.Stack;

public class PostfixExpression {

	public static void main(String[] args) {

		// String str = "3+2*2";
		String str = "2+3*4-5+7/2";
		String postfixExpr = postfix(str);
		System.out.println("Postfix Expression: " + postfixExpr);
		solvePostExpression(postfixExpr);

	}

	private static void solvePostExpression(String expressStr) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < expressStr.length(); i++) {
			char ch = expressStr.charAt(i);
			if (Character.isDigit(ch)) {
				stack.push(Character.getNumericValue(ch));
			} else {
				int b = stack.pop();
				int a = stack.pop();
				stack.push(calculate(a, b, ch));
			}
		}

		System.out.println("Output: " + stack.pop());
	}

	private static String postfix(String exp) {

		StringBuilder expression = new StringBuilder();
		Stack<Character> st = new Stack<>();

		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
			if (Character.isDigit(ch)) {
				expression.append(ch);
			} else {
				if (!st.isEmpty()) {
					char peek = st.peek();
					if (getPrecedence(ch) > getPrecedence(peek)) {
						st.push(ch);
					} else if (getPrecedence(ch) <= getPrecedence(peek)) {
						while (!st.isEmpty()) {
							char popped = st.pop();
							expression.append(popped);
						}
						st.push(ch);
					}

				} else {
					st.push(ch);
				}
			}
		}
		while (!st.isEmpty()) {
			char popped = st.pop();
			expression.append(popped);
		}

		return expression.toString();
	}

	private static int getPrecedence(char operator) {
		if (operator == '+' || operator == '-') {
			return 1;
		} else if (operator == '*' || operator == '/') {
			return 2;
		}
		return 0;
	}

	private static int calculate(int a, int b, char operator) {
		int res = 0;
		if (operator == '*') {
			res = a * b;
		} else if (operator == '-') {
			res = a - b;
		} else if (operator == '/') {
			res = a / b;
		} else if (operator == '+') {
			res = a + b;
		}
		return res;
	}

}
