package day16;

public class Account {
	private double balanceAmount;
	
	public Account(double balanceAmount) {
		this.balanceAmount=balanceAmount;
	}

	public double getBalanceAmount() {
		return balanceAmount;
	}
	
	public void deposit(double amt) {
		balanceAmount=balanceAmount+amt;
	}
	
	public void withdraw(double amt) {
		for(int i=0; i<100000; i++) {
			
		}
		balanceAmount=balanceAmount-amt;
	}
}
