package com.duke.stack;

import java.util.Stack;

public class StockSpan {

	private void calculateSpan(int[] price) {

		int n = price.length;
		Stack<Integer> st = new Stack<>();
		st.push(0);

		int[] span = new int[n];
		span[0] = 1;

		for (int i = 1; i < n; i++) {
			while (!st.isEmpty() && price[st.peek()] <= price[i]) {
				st.pop();
			}
			if (!st.isEmpty()) {
				span[i] = i - st.peek();
			}
			st.push(i);
		}
		
		System.out.println("Stock Span:");
		for(int i=0;i<n;i++)
		{
			System.out.print(span[i]+" ");
		}

	}

	public static void main(String[] args) {
		StockSpan s = new StockSpan();
		s.calculateSpan(new int[] { 100, 80, 60, 70, 60, 75, 85 });
	}

}
