package breakout;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
@SuppressWarnings("unused")
public class Ball extends BreakoutComponent implements MovingComponent {
	
	private int x;
	private int y;
	private int w;
	private int h;
	private int xvect;
	private int yvect;
	

	public Ball(int x, int y, int w, int h) {
		super(x, y, w, h, Color.BLUE);
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		xvect = 5;
		yvect = 5;
	}

	@Override
	public void updatePosition() {
		
		super.r.x += xvect;
		super.r.y += yvect;
		
		}
	
	public String toString(){
		return "x:" + r.x + ", y:" + r.y + ", W:" + r.width + ", H:" + r.height;
	}

	
	public void collisionCheck(ArrayList<BreakoutComponent> al) {
		Rectangle cr = new Rectangle();
		al.remove(super.r);
		for (int i = 0; i < al.size(); i++) {
			cr = al.get(i).r;
			
			if (super.r.intersects(cr)) {
				if (super.r.intersectsLine(cr.x, cr.y, cr.x + cr.width, cr.y) || super.r.intersectsLine(cr.x, cr.y + cr.height, cr.x + cr.width, cr.y + cr.height)) {
					System.out.println("tester");
					horizontalCollision();				
				} else if (super.r.intersectsLine(cr.x, cr.y, cr.x, cr.y + cr.height) || super.r.intersectsLine(cr.x + cr.width, cr.y, cr.x + cr.width, cr.y + cr.height)) {
					verticalCollision();
					System.out.println("retset");
				}
			}
		}
		
	}

	private void verticalCollision() {
		xvect = xvect * -1;
	}

	private void horizontalCollision() {
		yvect = yvect * -1;
		System.out.println(yvect);
	}

}
