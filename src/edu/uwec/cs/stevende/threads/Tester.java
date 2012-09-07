package edu.uwec.cs.stevende.threads;

public class Tester {

	public static void main(String[] args) {
		
		PrimeFinder pf = new PrimeFinder();
		int result;
		result = pf.count(100);
		
		System.out.println("num " + result);
		//System.out.println(pf.isPrime(23));
	}

}
