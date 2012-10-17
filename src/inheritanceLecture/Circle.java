package inheritanceLecture;

public class Circle extends Shape {
	private int radius;
		
	public Circle(int radius, int x, int y) {
		super(x, y);
		System.out.println("Circle const");
		this.radius = radius;
	}
	
	public Circle(int x, int y) {
		this(x, y, 1);
	}
	
	public Circle(int radius) {
		this(0, 0, radius);
	}
	
	public double area() {
		
		return Math.PI * radius * radius;
	}

//	public void translate(int deltaX, int deltaY) {
//		super.translate(deltaX, deltaY);
//	}
	
	public boolean equals(Object o) {	
		Circle c = (Circle)o;
		
		return ((this.radius == c.radius) &&
				super.equals(c));
	}
	
	
	public String toString() {
		return "Circle: " + radius + " at " + super.toString();
	}

	
}
