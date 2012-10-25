package grammar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Grammar {

	Map<String, Rule> m;
	int keyCounter;

	/**
	 * GRAMMAR CONSTRUCTOR
	 * okay, we use a hashmap here with the key (nonterminal in <angle brackets>) and the value (the rule) to organize
	 * use File and Scanner to open and readin our info
	 * first while loop is an outer loop to make the rules and set the key
	 * inner while loop is to get the productions and put them in the Rule class's arraylist
	 * finally, take the key and rules and stick them in the hashmap
	 */
	public Grammar(String fileName) throws FileNotFoundException {
		m = new HashMap<String, Rule>();
		File file = new File(fileName);
		Scanner s = new Scanner(file);
		keyCounter = 0;

		while (s.hasNextLine()) { // loop in a loop, outside to go through and make rules
			String str = s.nextLine();
			
			//check to get the key & create a new rule
			if (str.startsWith("<")) {
				String key = str;
				keyCounter++;
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

	/**
	 * GENERATE SENTENCE
	 * writes out the sentence somehow idk 
	 */
	public String generateSentence() {
		
		String result = "";
		Stack<String> s = new Stack<String>();
		Rule curRule;
		Productions curPro;
		Symbol curSymbol = null;
		String curKey = "<start>";
		int i = 0;
		s.push("<start>");

		while (i < keyCounter) { //keyCounter increments every time we make a new key (aka hits a nonterminal)	
			curRule = m.get(curKey);
			curPro = curRule.alProductions.get(0);
			curSymbol = curPro.queuePeek();
			//System.out.println(curSymbol.toString());
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
