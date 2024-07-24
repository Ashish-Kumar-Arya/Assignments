package assignments.day13.task1;

public class PrintNumbers implements Runnable {
    public void run() {
        for(int i=1; i<=10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread t1=new Thread(new PrintNumbers());
        Thread t2=new Thread(new PrintNumbers());
        t1.start();
        t2.start();
    }
}
