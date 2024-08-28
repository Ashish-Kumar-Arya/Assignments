package com.example.java;

public class StackExample {
	
	String[] str;
	int top;
	
	public StackExample(int size) {
		str = new String[size];
		top=-1;
	}

	public void push(String data) {
		if(top==str.length-1) {
			System.out.println("Stack overflow");
		}
		else {
			top++;
			str[top]=data;
		}
	}
	
	public String pop() {
		if(top==-1) {
			System.out.println("Stack underflow");
			return "-1";
		}
		else {
			String poppedElement=str[top];
			top--;
			return poppedElement;
		}
	}
	
	public String peek() {
		if(top==-1) {
			System.out.println("Stack underflow");
			return "-1";
		}
		else {
			return str[top];
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
				System.out.print(str[i]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackExample stack = new StackExample(5);
		System.out.println(stack.isEmpty());
		stack.push("Ashish");
		stack.push("Ramesh");
		stack.push("Khushi");
		stack.push("Kamal");
		stack.push("Kavita");
		stack.push("Rohit");
		stack.show();
		stack.pop();
		stack.pop();
		stack.show();
	}

}

