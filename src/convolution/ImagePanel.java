package convolution;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//A JFrame with a JPanel on it
//It paints the given image on the panel

public class ImagePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	UWECImage im;

	public ImagePanel(UWECImage im) {
		this.im = im;

		this.setSize(im.getWidth(), im.getHeight());

		// Setup the frame that I belong in
		JFrame frame = new JFrame("Image Convolution");
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});
		frame.getContentPane().add(this);
		frame.setSize(im.getWidth() + 100, im.getHeight() + 100);
		frame.setVisible(true);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		im.draw(g);
	}
}
