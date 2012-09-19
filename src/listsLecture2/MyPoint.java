package listsLecture2;

public class MyPoint implements Comparable<MyPoint> {
	private int x;
	private int y;
	
	public MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	public boolean equals(Object o) {
		MyPoint p = (MyPoint) o;
		
		System.out.println("point equ");
		
		return ((this.x == p.x) && (this.y == p.y)); 
	}

	@Override
	public int compareTo(MyPoint p) {
		
		int result;
		
		result = (this.x - p.x);
		if (result == 0) {
			result = (this.y - p.y);
		}
		return result;
	}
}
