package threadsLecture;

public class PrimeFinder {
	
	public PrimeFinder() {
		// Does nothing
	}

	// Count num of primes from [2..max] and return it
	public int count(int max) {
		
		PrimeThread[] pts = new PrimeThread[4];
		Thread[] ts = new Thread[4];
		
		for (int i=0; i<4; i++) {
			pts[i] = new PrimeThread(max, i);
			ts[i] = new Thread(pts[i]);
			ts[i].start();
		}
		
		for (int i=0; i<4; i++) {
			try {
				ts[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		int count = 0;
		for (int i=0; i<4; i++) {
			count += pts[i].getCount();
		}
		
		return count;
	}
	
	

}


