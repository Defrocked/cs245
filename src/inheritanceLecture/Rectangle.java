package inheritanceLecture;

public class Rectangle extends Shape {
	private int width;
	private int height;

	public Rectangle(int width, int height, int x, int y) {
		super(x, y);
		System.out.println("Rect const");
		this.width = width;
		this.height = height;
	}
	
	public double area() {
		
		return width * height;
	}
	
	
	
	public String toString() {
		return "Rect: " + width + " x " + height + " at " + x + "," + y;	
		
	}
	
}
