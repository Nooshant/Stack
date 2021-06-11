package com.duke.stack;

import java.util.Stack;

/**
 * @author thakurde
 * https://leetcode.com/problems/remove-k-digits/
 *
 */
public class RemoveKdigits {
	
	public static void removeKdigits(String num, int k)
	{
		int len = num.length();
		if (k >= len)
		{
			System.out.println("Digit: "+0);
			return;
		}
		
		if (k == 0)
		{
			System.out.println("Digit: "+0);
			return;
		}

		Stack<Character> st = new Stack<>();
		int i = 0;
		st.push(num.charAt(i));
		i++;

		while (i < len) {
			char val = num.charAt(i);
			if (!st.isEmpty() && st.peek() < val) {
				st.push(val);
			} else {
				if (k > 0) {
					st.pop();
					k--;
					st.push(val);
				} else {
					st.push(val);
				}
			}
			i++;
		}
		
		StringBuilder builder = new StringBuilder();
		
		while(!st.isEmpty())
		{
			builder.append(st.pop());
		}
		System.out.println("Final removed K digit number: "+builder.reverse());	
	}

	public static void main(String[] args) {
		
		String num = "121198"; //"765028321"; //"1432219";
		int k = 5;
		RemoveKdigits.removeKdigits(num, k);//1219
	}

}
