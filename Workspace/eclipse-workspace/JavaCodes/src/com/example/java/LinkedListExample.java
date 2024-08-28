package com.example.java;

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
	
	public void printList() {
		Node temp = head;
		while(temp.next!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println(temp.data);
	}
	
	public void insertAtStart(int data) {
		Node tempNode = new Node(data);
		tempNode.next = head;
		head=tempNode;
	}
	
	public void insertAtEnd(int data) {
		Node newNode = new Node(data);
		if(head==null) {
			head=newNode;
			return;
		}
		Node temp=head;
		while(temp.next!=null) {
			temp = temp.next;
		}
		temp.next=newNode;
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
	
	public void insertAtPosition(LinkedListExample ls, int data, int pos) {
		if(ls.size()<pos) {
			System.out.println("The size of linked list is less than the position.");
		}
		Node temp=ls.head;
		for(int i=1; i<pos-1; i++) {
			temp=temp.next;
		}
		Node newNode=new Node(data);
		newNode.next=temp.next;
		temp.next=newNode;
	}
	
	public void deleteNodeByKey(int key) {
		Node temp=head, prev=null;
		while(temp!=null) {
			if(temp.data==key) {
				if(head==temp) {
					head=temp.next;
					temp=temp.next;
				}
				else {
					prev.next=temp.next;
					temp=temp.next;
					
				}
			}
			else {
				prev=temp;
				temp=temp.next;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListExample list = new LinkedListExample();
		list.insertAtEnd(0);
		list.insertAtEnd(1);
		list.insertAtEnd(1);
		list.insertAtEnd(1);
		list.insertAtEnd(0);
		list.printList();
		System.out.println(list.size());
	}

}
