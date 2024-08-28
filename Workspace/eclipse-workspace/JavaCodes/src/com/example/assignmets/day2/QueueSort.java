package com.example.assignmets.day2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<>();
		queue.add(11);
		queue.add(1);	
		queue.add(21);
		sort(queue);
		System.out.println(queue);
	}
	
	public static void sort(Queue<Integer> q) {
		Stack<Integer> stack = new Stack<>();
		while(!q.isEmpty())
		{
			int temp = q.poll();
			while(!stack.isEmpty()&&stack.peek()<temp) {
				q.offer(stack.pop());
			}
			stack.push(temp);
		}
		while(!stack.isEmpty()) {
			q.offer(stack.pop());
		}
	}
}
