package assignments.day13.task4;

public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount account=new BankAccount(1000);

        Runnable depositTask=()->{
            for(int i=0; i<5; i++) {
                account.deposit(500);
            }
        };

        Runnable withdrawTask=()->{
            for(int i=0; i<5; i++) {
                account.withdraw(50);
            }
        };

        Thread thread1=new Thread(depositTask, "Thread-1");
        Thread thread2=new Thread(withdrawTask, "Thread-2");
        Thread thread3=new Thread(depositTask, "Thread-3");
        Thread thread4=new Thread(withdrawTask, "Thread-4");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        System.out.println("Final balance: "+account.getBalance());
    }
}
