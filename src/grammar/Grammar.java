package grammar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Grammar {

	Map<String, Rule> m;

	// Constructor where the file with the grammar is taken in and organized
	public Grammar(String fileName) throws FileNotFoundException {
		m = new HashMap<String, Rule>();
		File file = new File(fileName);
		Scanner s = new Scanner(file);

		while (s.hasNextLine()) { // loop in a loop, outside to go through and make rules
			String str = s.nextLine();
			
			//check to get the key & create a new rule
			if (str.startsWith("<")) {
				String key = str;
				Rule r = new Rule();
				 //System.out.println(str);
				while (!s.nextLine().equals("")) { // inside for the productions for each loop
					s.nextLine();
					// System.out.println(str);
					Productions nProduction = new Productions(str);
					r.addProductions(nProduction);
					//System.out.println(r.alProductions.size());
					// r.addProductions(nProduction.toString());
				}
				m.put(key, r);
			}	
			// System.out.println(m.toString());
		}
		s.close();
	}

	public String generateSentence() {
		//Productions p = new Productions(m.get("<start>").getRandom());
		String result = "";
		Stack<String> s = new Stack<String>();
		Rule curRule;
		Productions curPro;
		Symbol curSymbol = null;
		String curKey = "<start>";
		int i = 0;

		while (i < 3) { //i dont understand why this is out of 3
			curRule = m.get(curKey);
			// System.out.println(curRule);
			curPro = curRule.alProductions.get(0);
			curSymbol = curPro.queuePeek();
			if (curSymbol.isTerminal()) {
				result += " " + curSymbol.toString();
				System.out.println(result);
			} else {
				System.out.println(curSymbol.toString());
				curKey = curSymbol.toString();
			}
			i++;

		}
		return result;
	}

}
