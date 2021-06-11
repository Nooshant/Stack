package com.duke.stack;

import java.util.Stack;

public class NextGreater {
	
	public void nextGreaterElement(int[] arr)
	{
		Stack<Integer> s=new Stack();
		s.push(arr[0]);
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]>s.peek())
			{
				System.out.println(""+s.peek()+"-->"+arr[i]);
				s.pop();
				s.push(arr[i]);
			}
			else {
				s.push(arr[i]);
			}
		}
		int max= -1;
		while(!s.isEmpty())
		{
			int ele = s.pop();
			System.out.println("" + ele + "-->" + max);
			if (max < ele) {
				max = ele;
			}
		}
	}
	
	public static void main(String[] args) {
		NextGreater obj = new NextGreater();
		//int arr[] = {11, 13, 21, 3};
		int arr[] = {4, 5, 2, 25};
		obj.nextGreaterElement(arr);
	}

}
