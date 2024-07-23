package day5.assignment;

import day5.assignment.LinkedListExample.Node;

public class MergeLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListExample ls1 = new LinkedListExample();
		ls1.insert(1);
		ls1.insert(1);
		ls1.insert(5);
		ls1.insert(8);
		ls1.insert(10);
		LinkedListExample ls2 = new LinkedListExample();
		ls2.insert(1);
		ls2.insert(5);
		ls2.insert(12);
		ls2.insert(18);
		Node mergedListHead=merge(ls1.head,ls2.head);
		while(mergedListHead!=null) {
			System.out.print(mergedListHead.data+" ");
			mergedListHead=mergedListHead.next;
		}
	}
 
	public static Node merge(Node h1, Node h2) {
		Node head=null, curr=head;;
		if(h1==null||h2==null) {
			if(h1==null&&h2==null) {
				return null;
			}
			else {
				if(h1==null) {
					return h2;
				}
				else {
					return h1;
				}
			}
		}
		
		while(h1!=null&&h2!=null) {
			if(head==null) {
				if(h1.data<=h2.data) {
					head=h1;
					h1=h1.next;
				}
				else {
					head=h2;
					h2=h2.next;
				}
				curr=head;
			}
			else {
				if(h1.data<=h2.data) {
					curr.next=h1;
					h1=h1.next;
				}
				else {
					curr.next=h2;
					h2=h2.next;
				}
				curr=curr.next;
			}
		}
		if(h1==null) {
			curr.next=h2;
		}
		else {
			curr.next=h1;
		}
		return head;
	}
}
