package com.example.assignmets.day3;

import java.util.LinkedList;

import com.example.assignmets.day3.LinkedListExample.Node;

public class RemoveDuplicates {
	
	public static void main(String[] args) {
		LinkedListExample ll = new LinkedListExample();
		ll.insert(1);
		ll.insert(1);
		ll.insert(2);
		ll.insert(2);
		ll.insert(3);
		ll.insert(4);
		ll.insert(4);
		removeDuplicates(ll);
		Node temp = ll.head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}
	
/* Algorithm:
IF head==null or head.next==null
return
END IF
Node temp=head
WHILE temp!=null
IF temp.data==temp.next.data
temp.next=temp.next.next
END IF
ELSE
temp=temp.next
END ELSE
END WHILE
*/
	public static void removeDuplicates(LinkedListExample ll) {
		Node temp = ll.head;
		if(ll.head==null||ll.head.next==null) {
			return;
		}
		while(temp.next!=null) {
			if(temp.data==temp.next.data) {
				temp.next=temp.next.next;
			}
			else {
				temp=temp.next;
			}
		}
	}
}
