package grammar;

import java.util.LinkedList;
import java.util.Queue;

public class Productions {
	// Queue of symbols in a production, divided into terminal and non-terminals
	Queue<Symbol> q;

	public Productions(String production) {
		q = new LinkedList<Symbol>(); // Queue<Symbol> q = new
										// LinkedList<Symbol>(); wtf, stupid.
										// works like lab4.

		if (production.lastIndexOf(".") == production.length() - 1) {
			production = production.substring(0, production.length() - 2); //i don't really understand what this does
		}
		production = production.concat(" ");
		//System.out.println(production);
		String symbol;
		while (production.contains(" ")) { //breaks down production into words sans spaces
			symbol = production.substring(0, production.indexOf(" "));
			//System.out.println(symbol);
			production = production.substring(production.indexOf(" ") + 1, production.length());
			//System.out.println(production);
			if (symbol.charAt(0) == '<') {
				q.add(new NonTerminal(symbol));
			} else {
				q.add(new Terminal(symbol));
			}
			if (production.indexOf(" ") == 0) {
				production = production.substring(production.indexOf(" ") + 1, production.length());
			}
		}
		//System.out.println(q.toString());
	}
}
