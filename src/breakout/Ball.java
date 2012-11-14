package breakout;

import java.awt.Color;

public class Ball extends BreakoutComponent implements MovingComponent {
	private int x;
	private int y;
	private int w;
	private int h;

	public Ball(int x, int y, int w, int h) {
		super(x, y, w, h, Color.BLUE);
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	@Override
	public void updatePosition() {
		this.x = x + 1;
		this.y = y + 0;
		}
	
	public String toString(){
		return "x " + x + "y " + y + "W " + w + "H " + h;
	}

}
