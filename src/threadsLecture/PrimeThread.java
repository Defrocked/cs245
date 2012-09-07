package threadsLecture;

public class PrimeThread implements Runnable {

	private int max;
	private int count;
	private int threadNum;
	
	public PrimeThread(int max, int theadNum) {
		this.max = max;
		this.threadNum = theadNum;
	}
	
	@Override
	public void run() {
		
		count = 0;
		
		int start = max/4 * threadNum;
		int end = max/4 * (threadNum + 1);
		
		for (int i=start; i<=end; i++) {
			if (isPrime(i)) {
				count++;
			}
		}
		
	}
	
	// Shouldn't be called until run is done
	public int getCount() {
		return count;
	}
	
	// Decides if n is prime or not
		private boolean isPrime(int n) {
					
			boolean result = true;  // assume true and try to prove otherwise
			int i=2;
			while ((i<n) && (result == true)) {
				if ((n%i) == 0) {
					result = false;
				}
				i++;
			}		
			return result;
			
		}

}
