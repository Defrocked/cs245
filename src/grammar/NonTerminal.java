package grammar;

public class NonTerminal implements Symbol {

	String symbol;
	Boolean terminal;

	public NonTerminal(String symbol) {
		this.terminal = false;
		this.symbol = symbol;
	}

	public String toString() {

		return symbol;
	}

	@Override
	public boolean isTerminal() {
		return terminal;
	}

}
