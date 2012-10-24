package grammar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Grammar {

	Map<String, Rule> m;

	// Constructor where the file with the grammar is taken in and organized
	public Grammar(String fileName) throws FileNotFoundException {
		m = new HashMap<String, Rule>();
		File file = new File(fileName);
		Scanner s = new Scanner(file);
		String str;
		Rule r;
		Productions nProduction;
		int count = 0;
		
		while (s.hasNextLine()) { //loop in a loop, outside to go through and make rules
			str = s.nextLine();
			r = new Rule(str);
			System.out.println(str);
			System.out.println(count);
			str = s.nextLine();
			while (!s.nextLine().equals("")) { //inside for the productions for each loop

				/* 
				 * this is what i was working on when i stopped. goal is to run through, make a rule out of the angled bracketed line
				 * then go to the next line, read in stuff until it hits the "", and put everything it reads in into an array with that rule
				 * then it adds it to the map, then loops back and makes a new rule
				 * 
				 * i do not guarantee that this is working the way we want it but it seems to be okay
				 */
				System.out.println(str);
				nProduction = new Productions(str);
				r.addProductions(nProduction);
			}
			m.put(str, r);
			System.out.println(m.toString());
			count ++;
		}
		s.close();
	}

	public String generateSentence() {
		
		return null; //THIS IS WHERE THE NULL AND THE END OF THE SYSOUTS IS COMING FROM, you can ignore it for now
	}

}
