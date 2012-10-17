package guiLecture;

import java.awt.Dimension;

import javax.swing.JFrame;

public class StopWatch {

	public StopWatch() {
		
		JFrame f = new JFrame();
		f.setSize(new Dimension(300, 400));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		
		
		f.setVisible(true);
		
		
		
	}
	
	
	public static void main(String[] args) {
		new StopWatch();
	}

}
