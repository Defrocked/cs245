package inheritanceLecture;

public abstract class Shape extends Object {
	
	protected int x;
	protected int y;
//	
//	public Shape() {
//		System.out.println("Shape const");
//		this.x = 0;
//		this.y = 0;
//	}
	
	public Shape(int x, int y) {
		System.out.println("Shape param const");
		this.x = x;
		this.y = y;
	}
	
	public abstract double area();
		
	public void translate(int deltaX, int deltaY) {
		this.x += deltaX;
		this.y += deltaY;
	}
	
	public boolean equals(Object o) {	
		Shape s = (Shape)o;
		
		return ((this.x == s.x) &&
				(this.y == s.y));
	}
	
	public String toString() {
		return "foo";
	
	}
}
