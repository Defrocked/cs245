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

		int count = 0;
		
		while (s.hasNextLine()) { //loop in a loop, outside to go through and make rules
			String str = s.nextLine();
			Rule r = new Rule();
//			System.out.println(str);
//			System.out.println(count);
			str = s.nextLine();
			while (!s.nextLine().equals("")) { //inside for the productions for each loop

				
//				System.out.println(str);
				Productions nProduction = new Productions(str);
				r.addProductions(nProduction);
				//r.addProductions(nProduction.toString());
			}
			m.put(str, r);
//			System.out.println(m.toString());
			count ++;
		}
		s.close();
	}

	public String generateSentence() {
        String result = "";
        Stack<String> s = new Stack<String>();
        Rule curRule;
        Productions curPro;
        Symbol curSymbol = null;
        String curKey = "<start>";
        int i = 0;

        while (i < 3) {
            curRule = m.get(curKey);
            //System.out.println(curRule);
            curPro = curRule.alProductions.get(0);
            curSymbol =  curPro.queuePeek();
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
