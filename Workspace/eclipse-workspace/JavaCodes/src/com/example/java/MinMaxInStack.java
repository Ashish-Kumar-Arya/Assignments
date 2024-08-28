package com.example.java;

public class MinMaxInStack {
	
	int[] stack;
	int top;
	
	public MinMaxInStack(int size) {
		stack = new int[size];
		top=-1;
	}

	public void push(int data) {
		if(top==stack.length-1) {
			System.out.println("Stack overflow");
		}
		else {
			top++;
			stack[top]=data;
		}
	}
	
	public void pop() {
		if(top==-1) {
			System.out.println("Stack underflow");
		}
		else {
			int poppedElement=stack[top];
			top--;
		}
	}
	
	public void peek() {
		if(top==-1) {
			System.out.println("Stack underflow");
		}
		else {
			System.out.println(stack[top]);
		}
	}
	
	public boolean isEmpty() {
		return top==-1;
	}
	
	public void show() {
		if(top==-1) {
			System.out.println("Stack underflow");
		}
		else {
			for(int i=top; i>=0; i--) {
				System.out.print(stack[i]+" ");
			}
			System.out.println();
		}
	}
	
	public void minimum() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
		}
		int min=stack[0];
			for(int i=1;i<stack.length;i++) {
				if(stack[i]<min) {
					min=stack[i];
				}
			}
			System.out.println("Min. value is "+min);
	}
	
	public void maximum() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
		}
		int max=stack[0];
			for(int i=1;i<stack.length;i++) {
				if(stack[i]>max) {
					max=stack[i];
				}
			}
			System.out.println("Max. value is "+max);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinMaxInStack stack = new MinMaxInStack(5);
		System.out.println(stack.isEmpty());
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(5);
		stack.push(4);
		stack.push(6);
		stack.show();
		stack.pop();
		stack.pop();
		stack.show();
		stack.minimum();
		stack.maximum();
}

}


