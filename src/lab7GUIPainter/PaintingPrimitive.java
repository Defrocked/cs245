package lab7GUIPainter;

import java.awt.Color;
import java.awt.Graphics;

public abstract class PaintingPrimitive {

	protected Color colours;

	public PaintingPrimitive(Color colours){
		this.colours = colours;
	}

	public final void draw(Graphics g) {
	    g.setColor(this.colours);
	    drawGeometry(g);
	}

	protected abstract void drawGeometry(Graphics g);

}
