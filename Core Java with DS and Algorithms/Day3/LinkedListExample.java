package com.example.assignmets.day3;

import com.example.java.LinkedListExample.Node;

public class LinkedListExample {
public Node head;
	
	public class Node {
		public int data;
		public Node next;
		
		public Node(int d) {
			data = d;
			next=null;
		}
	}
	
	public int size() {
		int len=0;
		if(head==null) {
			return len;
		}
		else {
			Node temp = head;
			while(temp!=null) {
				len++;
				temp = temp.next;
			}
			return len;
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
