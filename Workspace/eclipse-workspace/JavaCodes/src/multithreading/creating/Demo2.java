package multithreading.creating;

public class Demo2 implements Runnable {
	public void run() {
		for(int i=1; i<=5; i++) {
			System.out.println(Thread.currentThread().getName()+"----------"+i+" ");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("Thread Interrupted");
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Demo2 t1=new Demo2();
		Thread t11=new Thread(t1,"Thread 1");
		Demo2 t2=new Demo2();
		Thread t21=new Thread(t2,"Thread 2");
		System.out.println(t11.activeCount());
		System.out.println(t11.currentThread());
		System.out.println(t11.getName());
		t11.start();
		System.out.println(t11.getName()+""+t11.isAlive());
		t11.join();
		System.out.println(t11.getName()+""+t11.isAlive());
		System.out.println(t21.getName()+""+t21.isAlive());
		t21.start();
		System.out.println(t21.getName()+""+t21.isAlive());
	}
}
