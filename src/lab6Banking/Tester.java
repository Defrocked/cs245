package lab6Banking;

import java.util.ArrayList;
import java.util.List;

public class Tester {

	public static void main(String[] args) {
		List<Account> aal = new ArrayList<Account>();
		aal.add(new Checking(1, 1000, 100, 10));
		aal.add(new Checking(2, 3000, 1000, 100));
		aal.add(new SuperNow(3, 1500, 100, 50, .05));
		aal.add(new SuperNow(4, 2500, 200, 20, .25));
		aal.add(new Savings(5, 500, .01));
		
		
		for(int i = 0; i < aal.size(); i++){
			System.out.println(aal.get(i).toString());
		}

	}

}
