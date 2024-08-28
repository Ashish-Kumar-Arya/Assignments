package com.example.java;

public class QueueExample {

	String[] items;
	int front=-1, back=-1;
	
	public QueueExample(int len) {
		items = new String[len];
	}
	
	public void enque(String data) {
		if(isFull()) {
			System.out.println("Queue is full.");
		}
		else if(front==-1) {
			front=back=0;
			items[front]=data;
		}
		else {
			back++;
			items[back]=data;
		}
	}
	
	public void deque() {
		if(front==-1) {
			System.out.println("Queue is empty");
		}
		else if(front==back) {
			front=back=-1;
		}
		else {
			
			front++;
		}
	}
	
	public boolean isEmpty() {
		return front==-1;
	}
	
	public void display() {
		if(isEmpty()) {
			System.out.println("Queue is empty.");
		}
		else {
			for(int i=front; i<=back; i++) {
				System.out.print(items[i]+" ");
			}
			System.out.println();
		}
	}
	
	public boolean isFull() {
		return back==items.length-1;
	}
	
	public static void main(String[] args) {
		QueueExample queue = new QueueExample(5);
		System.out.println(queue.isEmpty());
		System.out.println(queue.isFull());
		queue.enque("Ashish");
		queue.enque("Rahul");
		queue.enque("Komal");
		queue.display();
		queue.deque();
		queue.display();
	}

}
