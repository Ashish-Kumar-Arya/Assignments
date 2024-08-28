package com.example.assignmets.day3;

import java.util.Stack;

public class StackSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<>();
		stack.push(34);
		stack.push(5);
		stack.push(25);
		stack.push(11);
		sort(stack);
		System.out.println(stack);
	}
	
	public static void sort(Stack<Integer> stack) {
		Stack<Integer> s2 = new Stack<>();
		while(!stack.isEmpty()) {
			int temp=stack.pop();
			while(!s2.isEmpty()&&s2.peek()>temp) {
				stack.push(s2.pop());
			}
			s2.push(temp);
		}
		while(!s2.isEmpty()) {
			stack.push(s2.pop());
		}
	}
}
