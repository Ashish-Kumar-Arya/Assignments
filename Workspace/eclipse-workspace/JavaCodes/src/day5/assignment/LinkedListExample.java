package day5.assignment;

import com.example.java.LinkedListExample.Node;

public class LinkedListExample {
public Node head;
	
	static public class Node {
		public int data;
		public Node next;
		
		public Node(int d) {
			data = d;
			next=null;
		}
	}
	
	public void insert(int data) {
		Node newNode = new Node(data);
		if(head==null) {
			head = newNode;
		}
		else {
			Node temp=head;
			while(temp.next!=null) {
				temp = temp.next; 
			}
			temp.next=newNode;
		}
	}
}
