package inheritanceLecture;

public class Square extends Rectangle {
	
	public Square(int x, int y, int size) {
		super(size, size, x, y);
	}
	
	public String toString() {
		return "Square";
	}

}
