package lab6Banking;

public class SuperNow extends Checking {
	protected double interestRate;

	public SuperNow(int aNumber) {
		super(aNumber);
		this.minBalance = 0;
		this.perUseCharge = 0;
		this.interestRate = 0;
	}

	public SuperNow(int aNumber, double aRate) {
		super(aNumber);
		this.minBalance = 0;
		this.perUseCharge = 0;
		this.interestRate = aRate;
	}

	public SuperNow(int aNumber, double aBalance, double aMinBal, double aCharge, double aRate) {
		super(aNumber, aBalance, aMinBal, aCharge);
		this.interestRate = aRate;
	}

	public String toString() {
		return (super.toString()) + ", and an interest rate of " + interestRate;
	}

	public boolean equals(Object obj) {
		SuperNow s = (SuperNow) obj;
		return (super.equals(obj)) && (this.interestRate == s.interestRate);
	}

	public int compareTo(Account obj) {
		int tmp = super.compareTo(obj);
		SuperNow s = (SuperNow) obj;
		if(tmp == 0){
			tmp  = (int) (this.interestRate - s.interestRate);
		}
		
		return tmp;
	}
	
	public void addInterest() {
		balance = (balance * interestRate) + balance;
	}
}