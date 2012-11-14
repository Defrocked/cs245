package breakout;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class BreakoutComponent {
	protected Rectangle r;
	protected Color c;
	
	
	public BreakoutComponent(int x, int y, int w, int h, Color c) {
		r = new Rectangle(x, y, w, h);
		this.c = c;
		
	}
	
	public void draw(Graphics g) {
		g.setColor(c);
		g.fillRect(r.x, r.y, r.width, r.height);
	} 
		
	
		
}
