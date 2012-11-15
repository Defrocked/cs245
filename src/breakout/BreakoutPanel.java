package breakout;

import java.awt.Color;
import java.awt.Graphics;


import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BreakoutPanel extends JPanel{

	
	

	public BreakoutPanel() {

		setBackground(Color.BLACK);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (BreakoutComponent obj : Breakout.bcal) { 
			obj.draw(g);
		}
		
	}
	
}
