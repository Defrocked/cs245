package grammar;

import java.util.ArrayList;

public class Rule {
	// List of productions that follow the rule
	ArrayList<Productions> alProductions;
	String rule;
	String productions;
	
	public Rule(String rule) {
		this.rule = rule;
		alProductions = new ArrayList<Productions>();
		
	}
	
	public String toString(){
		
		return rule;
	}
	
	public void addProductions(Productions p) {
		alProductions.add(p);
	}
}
