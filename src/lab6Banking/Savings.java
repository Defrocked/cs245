package lab6Banking;

public class Savings extends Account {
	protected double interestRate;

	public Savings(int aNumber) {
		super(aNumber);
		this.balance = 0;
		this.interestRate = 0;
	}

	public Savings(int aNumber, double aRate) {
		super(aNumber);
		this.interestRate = aRate;
	}

	public Savings(int aNumber,double aBalance, double aRate) {
		super(aNumber, aBalance);
		this.interestRate = aRate;
	}

	public String toString() {
		return (super.toString()) + ", and an interest rate of " + interestRate;
	}

	public boolean equals(Object obj) {
		Savings s = (Savings) obj;
		return (super.equals(obj) && (this.interestRate == s.interestRate));
	}

	public int compareTo(Account obj) {
		int tmp = super.compareTo(obj);
		Savings s = (Savings) obj;
		if(tmp == 0){
			tmp  = (int) (this.interestRate - s.interestRate);
		}
		
		return tmp;
	}
	
	public void addInterest() {
		balance = (balance * interestRate) + balance;
	}
}