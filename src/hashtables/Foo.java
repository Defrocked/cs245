package hashtables;

public class Foo {
	private int number;

	public Foo(int number) {
		this.number = number;

	}

	public boolean equals(Object o) {
		Foo n = (Foo) o;
		return this.number == n.number;
	}

	public String toString() {
		String temp = "" + number;
		return temp;
	}

	public int compareTo(int o) {
		// am i supposed to override comparable's compareTo by implementing
		// Comparable<T>?
		int x = -1;
		if (number == o) {
			x = 0;
		} else if (number > o) {
			x = 1;
		}
		return x;
	}

	public int hashCode() {
		return number;
	}

}
