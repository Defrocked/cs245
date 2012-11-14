package breakout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

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
