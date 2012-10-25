package grammar;

import java.util.LinkedList;
import java.util.Queue;

public class Productions {
	// Queue of symbols in a production, divided into terminal and non-terminals
	private String[] str;
	private Queue<Symbol> q;

	public Productions(String production) {
		q = new LinkedList<Symbol>(); 
		
		//uses a regular expression to split the string on the space character
		str = production.split(" ");
		for(int i = 0; i < str.length; i++){
			//assigns str[i] to terminal or nonterminal 
			if(str[i].startsWith("<")){
				q.add(new NonTerminal(str[i]));
			}else{
				q.add(new Terminal(str[i]));
			}
		}
	}
	
	
	/* methods to get queue info out */
	public Queue<Symbol> retrieveQueue(){
		return q;
	}
	
	public Symbol queuePeek(){
		return q.peek();
	}
	
	public Symbol queueRemove(){
		return q.poll();
	}
}
