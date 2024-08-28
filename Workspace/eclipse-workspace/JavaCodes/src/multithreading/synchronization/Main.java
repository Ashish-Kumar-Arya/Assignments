package multithreading.synchronization;

class TableCreation {
	synchronized public void createTable(int n) {
		for(int i=1;i<=5;i++) {
			System.out.println(n+" * "+i+" = "+n*i);
			try {
				Thread.sleep(2000);
			}
			catch(Exception e) {
				System.out.println("Thread Interrupted");
			}
		}
	}
}

class Thread1 extends Thread {
	TableCreation obj;
	public Thread1(TableCreation o) {
		this.obj=o;
	}
	
	public void run() {
		obj.createTable(10);
	}
}

class Thread2 extends Thread {
	TableCreation obj;
	public Thread2(TableCreation o) {
		this.obj=o;
	}
	
	public void run() {
		obj.createTable(20);
	}
}

public class Main {
	public static void main(String[] args) {
		TableCreation object=new TableCreation();
		Thread1 t1=new Thread1(object);
		Thread2 t2=new Thread2(object);
		t1.start();
		t2.start();
	}
}
