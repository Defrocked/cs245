package breakout;

import java.util.ArrayList;

public interface MovingComponent {
	
	public abstract void updatePosition();

	
	public void collisionCheck(ArrayList<BreakoutComponent> al);
}
