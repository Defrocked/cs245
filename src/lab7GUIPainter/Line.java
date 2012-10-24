package lab7GUIPainter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Line extends PaintingPrimitive{

	protected Color colours;
	protected Point topLeft;
	protected Point bottomRight;

	public Line(Point topLeft, Point bottomRight, Color colours) {
		super(colours);
		this.topLeft = topLeft;
		this.bottomRight = bottomRight;

	}

	public void drawGeometry(Graphics g) {
		//int radius = (int) ((Math.abs(topLeft.distance(bottomRight))) / 2);

		g.drawLine(topLeft.x, topLeft.y, bottomRight.x, bottomRight.y);
	}
}
