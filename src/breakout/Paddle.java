package breakout;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
@SuppressWarnings("unused")
public class Paddle extends BreakoutComponent implements MovingComponent, MouseMotionListener{
	private int x;
	private int y;
	private int w;
	private int h;
	public int mouseX;
	
	public Paddle(int x, int y, int w, int h) {
		super(x, y, w, h, Color.GREEN);
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	@Override
	public void updatePosition() {
		super.r.x = mouseX;
		
	}

	@Override
	public void collisionCheck(ArrayList<BreakoutComponent> al) {
		Rectangle cr = new Rectangle();
		al.remove(super.r);
		for (int i = 0; i < al.size(); i++) {
			cr = al.get(i).r;
			
			if (super.r.intersects(cr)) {
							
				if (super.r.intersects(cr)){
					verticalCollision();
					System.out.println("retset");
				}
			}
		}
	}
	
	private void verticalCollision() {
		//something goes here about not letting the paddle past the sides
	}


	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//this works if it is in Breakout, but not in Paddle
		mouseX = e.getX() - 40;
		super.r.x = mouseX;
		
	}

}
