package grammar;

public class Terminal implements Symbol {

	String symbol;
	Boolean terminal;
	
	public Terminal(String symbol) {
		this.terminal = true;
		this.symbol = symbol;
	}
	
	public String toString(){
	
		return symbol;
	}
	
}
