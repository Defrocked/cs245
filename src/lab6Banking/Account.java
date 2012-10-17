package lab6Banking;

public abstract class Account implements Comparable<Account> { 
	protected int number;
	protected double balance;

	public Account(int aNumber) {
	}

	public Account(int aNumber, double aBalance) {
	}

	public String toString() {
		return "";
	}

	public boolean equals(Object obj) {
		return true;
	}
	
	public int compareTo(Account obj) {
		return 0;
	}

	public void deposit(double amt) {
	}

	public void withdraw(double amt) {
	}
}