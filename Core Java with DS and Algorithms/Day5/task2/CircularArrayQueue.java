package day6.Assignment;

public class CircularArrayQueue {

	int a[];
	int n;
	int front=-1, rear=-1;
	public CircularArrayQueue(int n) {
		this.n=n;
		a=new int[n];
	}
	
	public void enqueue(int data) {
		if((rear+1)%n==front) {
			System.out.println("Queue is full");
		}
		if(front==-1)       {
			front=0;
		}
		rear=(rear+1)%n;
		a[rear]=data;
	}
	
	public int dequeue() {
		if(front==-1) {
			System.out.println("Queue is empty");
		}
		int result=a[front];
		if(front==rear) {
			front=rear=-1;
		}
		else {
			front=(front+1)%n;
		}
		return result;
	}
	
	public void display() {
		if(front<=rear) {
			for(int i=front; i<=rear; i++) {
				System.out.print(a[i]+" ");
			}
			System.out.println();
		}
		else {
			for(int i=front; i<n; i++) {
				System.out.print(a[i]+" ");
			}
			for(int i=0; i<=rear; i++) {
				System.out.print(a[i]+" ");
			}
			System.out.println();
		}
	}
}
