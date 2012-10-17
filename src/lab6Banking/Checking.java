package lab6Banking;

public class Checking extends Account {
	protected double minBalance;
	protected double perUseCharge;

	public Checking(int aNumber) {
		super(aNumber);
		this.minBalance = 0;
		this.perUseCharge = 0;
	}

	public Checking(int aNumber, double aBalance, double aMinBal, double aCharge) {
		super(aNumber, aBalance);
		this.minBalance = aMinBal;
		this.perUseCharge = aCharge;
	}

	public String toString() {
		return (super.toString()) + ", minimum balance of " + minBalance + ", and a per Withdrawal charge of " + perUseCharge;

		// return "Checking account #: " + number + ", balance of " + balance +
		// ", minimum balance of " + minBalance +
		// ", and a per Withdrawal charge of " + perUseCharge;

	}

	public boolean equals(Object obj) {
		Checking s = (Checking) obj;

		return ((super.equals(obj)) && (this.minBalance == s.minBalance) && (this.perUseCharge == s.perUseCharge));

		// return ((this.number == s.number) && (this.balance == s.balance) &&
		// (this.minBalance == s.minBalance) && (this.perUseCharge ==
		// s.perUseCharge));
	}

	public int compareTo(Account obj) {
		int tmp = super.compareTo(obj);
		Checking s = (Checking) obj;
		if (tmp == 0) {
			tmp = (int) (this.minBalance - s.minBalance);

			if (tmp == 0) {
				tmp = (int) (this.perUseCharge - s.perUseCharge);
			}
		}
		return tmp;

	}

	public void withdraw(double amt) {
		if (balance - amt >= minBalance) {
			super.withdraw(amt);
		} else {
			System.out.println("Not enough funds to withdraw");
		}
	}
}