package day6.Assignment;

public class CircularQueueSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularArrayQueue cq = new CircularArrayQueue(5);
		cq.enqueue(5);
		cq.enqueue(15);
		cq.enqueue(17);
		cq.enqueue(25);
		binarySearch(cq, 5);
	}
	
/*
 * Approach:
 * if front-1
 * print("Queue is empty")
 * if front<rear
 * start=front, end=rear
 * end if
 * else
 * if key<=rear
 * start=0,end=rear
 * end if
 * else
 * start=front, end=cq.a.length
 * end else
 * end else
 * while start<=end
 * mid=start+(end-start)/2
 * if(cq.a[mid]==key
 * print("Key found")
 * break
 * end if
 * else if(cq.a[mid]>key)
 * end=mid-1
 * end else if
 * else
 * start=mid+1
 * end else
 * end while
 * if start>end
 * print "Key not found"
 * end if
 */

	public static void binarySearch(CircularArrayQueue cq, int key) {
		int start=-1, end=-1;
		if(cq.front==-1) {
			System.out.println("Queue is empty");
			return;
		}
		if(cq.front<=cq.rear) {
			start=cq.front;
			end=cq.rear;
			}
		else {
			if(key<=cq.rear) {
				start=0;
				end=cq.rear;
			}
			else {
				start=cq.front;
				end=cq.a.length;
			}
			
		}
			while(start<=end) {
				int mid=start+(end-start)/2;
				if(cq.a[mid]==key) {
				System.out.println("Key found");
				break;
				}
				else if(cq.a[mid]>key) {
					end=mid-1;
				}
				else {
					start=mid+1;
				}
			}
			if(start>end) {
				System.out.println("Key not found");
			}
		}
}
