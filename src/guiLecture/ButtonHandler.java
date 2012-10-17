package guiLecture;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class ButtonHandler implements ActionListener {
	
	private JTextField tf;
	
	public ButtonHandler(JTextField tf) {
		this.tf = tf;
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		
		String s = tf.getText();
		
		System.out.println("the text is " + s);
	}

}
