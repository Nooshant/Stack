package com.duke.stack;

import java.util.Stack;

public class MaxRectangleAreaInHistrogram {

	public static void main(String[] args) {
		   int[] a = { 3, 2, 5, 6, 1, 4, 4 };
		// int a[] = { 6, 2, 5, 4, 5, 1, 6 };
		maxRectangleArea(a);
	}

	private static void maxRectangleArea(int[] a) {
		Stack<Integer> stack = new Stack<>();
		if (a == null || a.length == 0) {
			return;
		}

		int maxArea = 0;
		int i = 0;
		int area = 0;

		while (i < a.length) {
			if (stack.isEmpty() || a[stack.peek()] <= a[i]) {
				stack.push(i);
				i++;
			} else {
				int top = stack.pop();
				if (!stack.isEmpty()) {
					area = a[top] * (i - stack.peek() - 1);
				} else {
					area = a[top] * (i-top);
					System.out.println(area);
				}
				maxArea = Math.max(maxArea, area);
			}
		}
		
		while (!stack.isEmpty()) {
			int top = stack.pop();
			if (!stack.isEmpty()) {
				area = a[top] * (i - stack.peek() - 1);
			} else {
				area = a[top] * (i-top);
				System.out.println(area);
			}
			maxArea = Math.max(maxArea, area);
		}

		System.out.println("Max Histrogram Area:"+maxArea);
	}

}
