package guiLecture;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI implements ActionListener {
	
	private JTextField tf;
	
	public GUI() {
		JFrame f = new JFrame();
		f.setSize(new Dimension(300, 400));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		
		//f.getInsets()
				
		JPanel p = new JPanel();
		p.setBackground(Color.RED);
		
		p.setLayout(new BorderLayout());
		
		//final JTextField tf = new JTextField();
		tf = new JTextField();
		tf.setText("Result");
		
		
		
		
		JButton b1 = new JButton();
		b1.setText("Click Me!");
		
		//ButtonHandler al = new ButtonHandler(tf);
		b1.setActionCommand("BUTTON1");
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String s = tf.getText();
				
				System.out.println("hey " + s);
			}
			
			
		});
		
		
		
		
		JButton b2 = new JButton();
		b2.setText("No Click Me!");
		b2.setActionCommand("BUTTON2");
		b2.addActionListener(this);
		
		DrawingPanel drawing = new DrawingPanel();

		drawing.repaint();	
		
		
		
		
		p.add(b1, BorderLayout.NORTH);
		p.add(tf, BorderLayout.SOUTH);
		p.add(b2, BorderLayout.WEST);
		p.add(drawing, BorderLayout.CENTER);
		
			
		f.setContentPane(p);
		f.setVisible(true);
		
		
	}

	public static void main(String[] args) {
		
		new GUI();	

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = tf.getText();
		
		if (e.getActionCommand().equals("BUTTON1")) {
			System.out.println("the text is " + s);
		} else {
			System.out.println("hi");
			
		}
		
		
		
		
	}

}
