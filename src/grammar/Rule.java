package grammar;

import java.util.ArrayList;
import java.util.Random;

/**
 * RULE
 * new'ing Rule will instantiate the arraylist and random number generator
 * toString that runs through the arraylist.get(index) and combines them into one string
 * addProductions takes Productions and throws them in the arraylist
 * getRandom should get a random Production and return it as a string
 */
public class Rule {
	ArrayList<Productions> alProductions;
	String productions;
	Random gen;

	public Rule() {
		//instantiate the list and random number generator
		alProductions = new ArrayList<Productions>();
		gen = new Random();

	}

	public String toString() {
		String temp = "";
		for (int i = 0; i < alProductions.size(); i++) {
			temp = temp + alProductions.get(i);
		}

		return temp;

	}

	public void addProductions(Productions p) {
		//add productions to the list
		alProductions.add(p);
	}

	public String getRandom() {
		//get a random production between 0 and the # of productions
		return alProductions.get(gen.nextInt(Math.abs(alProductions.size()))).toString();
	}
}
