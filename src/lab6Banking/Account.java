package lab6Banking;

public abstract class Account implements Comparable<Account> {
	protected int number;
	protected double balance;

	public Account(int aNumber) {
		this.number = aNumber;
	}

	public Account(int aNumber, double aBalance) {
		this.number = aNumber;
		this.balance = aBalance;
	}

	public String toString() {
		return "Account #: " + number + ", with a balance of " + balance;
	}

	public boolean equals(Object obj) {
		Account s = (Account) obj;

		return ((this.number == s.number) && (this.balance == s.balance));
	}

	public int compareTo(Account obj) {
		int tmp;
		Account s = obj;
		
		tmp  = (int) (this.balance - s.balance);
		
		if (tmp == 0) {
			tmp = (this.number - s.number);	
		}
		return tmp;
	}

	public void deposit(double amt) {
		balance += amt;
	}

	public void withdraw(double amt) {
		balance -= amt;
	}
}