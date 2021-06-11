package com.duke.stack;

import java.util.Stack;

public class ReverseStack {

	private void reverse(Stack<Integer> stack) {
		if (!stack.isEmpty()) {
			int x = stack.pop();
			reverse(stack);

			insert_reverse_stack(stack, x);
		}
		// System.out.println(stack);
	}

	private void insert_reverse_stack(Stack<Integer> stack, int x) {

		if (stack.isEmpty()) {
			stack.push(x);
		} else {
			int y = stack.pop();
			insert_reverse_stack(stack, x);

			stack.push(y);
		}
	}

	public static void main(String[] args) {
		Stack<Integer> st = new Stack();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		ReverseStack o = new ReverseStack();
		o.reverse(st);
		System.out.println(st);

		Stack<Integer> st1 = new Stack();
		st1.push(30);
		st1.push(-5);
		st1.push(18);
		st1.push(14);
		st1.push(-3);
		o.sort(st1);
		System.out.println(st1);
	}

	private void sort(Stack<Integer> st) {
		if (!st.isEmpty()) {
			int x = st.pop();
			sort(st);
			sortStack(st, x);
		}
	}

	private void sortStack(Stack<Integer> st, int x) {

		if (st.empty() || st.peek() < x) {
			st.push(x);
		} else {
			int y = st.pop();
			sortStack(st, x);
			st.push(y);
		}
	}

}
