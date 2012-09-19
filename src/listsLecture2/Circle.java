package listsLecture2;

public class Circle implements Comparable<Circle> {
	private int radius;
	private MyPoint p;
	
	public Circle(int radius, MyPoint p) {
		this.radius = radius;
		this.p = p;
	}
	
	public boolean equals(Object o) {
		Circle c = (Circle)o;
		
		System.out.println("circle equ");
				
		return ((this.radius == c.radius) &&
				(this.p.equals(c.p)));
	}
	
	public String toString() {
		return "Circle: " + radius + " at " + p.toString();		
	}

	@Override
	// neg if I go before c
	// pos if I go after c
	// 0 if I am tied with c
	public int compareTo(Circle c) {
		
		int result;
		
//		if (this.radius < c.radius) {
//			result = -1;
//		} else if (this.radius > c.radius) {
//			result = +1;
//		} else { // equal
//			result = 0;  // use tie breaker instead
//		}
		
		result = -1 * (this.radius - c.radius);
		
		// tie breaker
		if (result == 0) {
			result = this.p.compareTo(c.p);
		}
		
		
		return result;
	}
	

}
