package day4.assignment;

import java.util.Stack;

public class SequenceSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3,0};
		Stack<Integer> stack = new Stack<>();
		stack.add(5);
		stack.add(4);
		stack.add(0);
		stack.add(3);
		stack.add(0);
		stack.add(2);
		stack.add(1);
		stack.add(6);
		System.out.println(sequenceSearch(arr, stack));
	}
	
	public static boolean sequenceSearch(int[] arr, Stack<Integer> stack) {
		int point=0;
		if(stack.isEmpty()||arr.length==0) {
			return false;
		}
		while(!stack.isEmpty()) {
			if(arr[point]==stack.pop()) {
				point++;
				if(point==arr.length) {
					return true;
				}
			}
			else {
				point=0;
			}
		}
		return false;
	}
}
