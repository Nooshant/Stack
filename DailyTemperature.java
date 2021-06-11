package com.duke.stack;

import java.util.Stack;

/**
 * @author thakurde https://leetcode.com/problems/daily-temperatures/
 */

public class DailyTemperature {

	public static int[] dailyTemperatures(int[] s) {
		int len = s.length;
		int[] output = new int[len];
		Stack<Integer> st = new Stack<>();

		int i = 0;
		while (i < len) {
			if (st.isEmpty()) {
				st.push(i);
				i++;
			} else {
				while (!st.isEmpty() && s[i] > s[st.peek()]) {
					int popIndex = st.pop();
					int day = i - popIndex;
					output[popIndex] = day;
				}
				st.push(i);
				i++;
			}
		}

		if (!st.isEmpty()) {
			int popIndex = st.pop();
			output[popIndex] = 0;
		}

		return output;
	}

	public static void main(String[] args) {
		int[] T = { 73, 74, 75, 71, 69, 72, 76, 73 };
		int[] prediction = DailyTemperature.dailyTemperatures(T);

		System.out.println("Prediction of next higher temperature: ");
		for (int i : prediction) {
			System.out.print(i + " ");
		}
	}

}
