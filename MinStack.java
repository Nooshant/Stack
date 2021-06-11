package com.duke.stack;

import java.util.Stack;

public class MinStack
{
	private Stack<Integer> stack = null;
	private int minElement = Integer.MAX_VALUE;

	MinStack() {
		stack = new Stack<Integer>();
	}

	// push the element
	public void push(int data) {
		if (stack.isEmpty()) {
			stack.push(data);
			minElement = data;
		}
		if (minElement < data) {
			stack.push(data);
		} else {
			minElement = 2 * data - minElement;
			stack.push(minElement);
		}
	}
	
	// pop the element
	public void pop()
	{
		if(stack.isEmpty())
		{
			System.out.println("Stack is empty");
			return;
		}
		int popped = stack.pop();
		if(popped < minElement)
		{
			minElement = 2*minElement - popped;
		}
		System.out.println("Removed: "+popped);
	}
	
	
	// get the minElement
	public int getMin() {
		System.out.println("Minimum element: "+minElement);
		return minElement;
	}
	
	public static void main(String[] args) {
		MinStack s = new MinStack();
		s.push(3);
        s.push(5);
        s.getMin();//3
        s.push(2);
        s.push(1);
        s.getMin();//1
        s.pop();
        s.getMin();//2
        s.pop();
	}
}
