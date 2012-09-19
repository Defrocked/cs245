package listsLecture;

public class Circle implements Comparable<Circle> {
	private int radius;
	private int x;
	private int y;
	
	public Circle(int radius, int x, int y) {
		this.radius = radius;
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Object o) {
		Circle c = (Circle)o;
		
		return ((this.radius == c.radius) &&
				(this.x == c.x) &&
				(this.y == c.y));
	}
	
	public String toString() {
		return "Circle: " + radius + " at " + x + "," + y;		
	}

	@Override
	// neg if I go before c
	// pos if I go after c
	// 0 if I am tied with c
	public int compareTo(Circle c) {
		
		
		
		return 0;
	}
	

}
