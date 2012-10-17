package lab6Banking;

public class Checking extends Account {
	protected double minBalance;
	protected double perUseCharge;
	
	public Checking(int aNumber) {
	}

	public Checking(int aNumber, double aBalance, double aMinBal, double aCharge) {
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