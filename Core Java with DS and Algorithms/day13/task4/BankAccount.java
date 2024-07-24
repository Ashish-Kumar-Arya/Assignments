package assignments.day13.task4;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance=initialBalance;
    }

    public synchronized void deposit(double amount) {
        if(amount>0) {
            balance += amount;
            System.out.println(Thread.currentThread().getName()+" deposited "+amount+". New balance: "+balance);
        }
    }

    public synchronized void withdraw(double amount) {
        if(amount>0 && amount<=balance) {
            balance-=amount;
            System.out.println(Thread.currentThread().getName()+" withdraw "+amount+". New balance: "+balance);
        }
        else {
            System.out.println(Thread.currentThread().getName()+" tried to withdraw "+amount+" but insufficient balance.");
        }
    }

    public synchronized double getBalance() {
        return balance;
    }
}
