package com.example.assignmets.day2;

import java.util.LinkedList;

import com.example.assignmets.day2.LinkedListExample.Node;

public class SearchMiddle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListExample ls = new LinkedListExample();
		ls.insert(1);
		ls.insert(2);
		ls.insert(3);
		ls.insert(4);
		ls.insert(6);
		ls.insert(7);
		middleElement(ls);
	}
	
	public static void middleElement(LinkedListExample list) {
		if(list.head==null) {
			System.out.println("List is empty.");
		}
		Node temp = list.head;
		int i=0;
		while(i<(list.size()-1)/2) {
			temp=temp.next;
			i++;
		}
		if(list.size()%2==0) {
			System.out.println(temp.data+","+temp.next.data);
		}
		else {
			System.out.println(temp.data);
		}
	}
	
}
