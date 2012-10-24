package lab7GUIPainter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Painter implements ActionListener {

	private boolean circleSelected = false;
	private boolean lineSelected = false;
	private boolean redSelected = false;
	private boolean greenSelected = false;
	private boolean blueSelected = false;
	private Point mousePoint1 = null;
	private Point mousePoint2 = null;
	private Color colours = null;

	public Painter() {

		// MAIN JFRAME
		JFrame f = new JFrame();
		f.setSize(new Dimension(500, 500));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ENCOMPASSING PANEL
		JPanel p = new JPanel();
		p.setBackground(Color.WHITE);
		p.setLayout(new BorderLayout());

		// LEFT
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(3, 1));

		// RED
		JButton redPaint = new JButton();
		redPaint.setBackground(Color.RED);
		leftPanel.add(redPaint);

		// GREEN
		JButton greenPaint = new JButton();
		greenPaint.setBackground(Color.GREEN);
		leftPanel.add(greenPaint);

		// BLUE
		JButton bluePaint = new JButton();
		bluePaint.setBackground(Color.BLUE);
		leftPanel.add(bluePaint);

		p.add(leftPanel, BorderLayout.WEST);

		// NORTH
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(1, 2));

		// LINE
		JButton lineButton = new JButton();
		lineButton.setText("Line");
		topPanel.add(lineButton);

		// CIRCLE
		JButton circleButton = new JButton();
		circleButton.setText("Circle");
		topPanel.add(circleButton);

		p.add(topPanel, BorderLayout.NORTH);

		final PaintingPanel pp = new PaintingPanel();
		p.add(pp, BorderLayout.CENTER);

		// ACTION BUTTONS
		circleButton.setActionCommand("CIRCLE");
		circleButton.addActionListener(this);
		lineButton.setActionCommand("LINE");
		lineButton.addActionListener(this);
		redPaint.setActionCommand("RED");
		redPaint.addActionListener(this);
		greenPaint.setActionCommand("GREEN");
		greenPaint.addActionListener(this);
		bluePaint.setActionCommand("BLUE");
		bluePaint.addActionListener(this);

		// ACTION MOUSE

		pp.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (mousePoint1 != null) {
					mousePoint2 = e.getPoint();

					if (redSelected) {
						colours = Color.RED;
					} else if (greenSelected) {
						colours = Color.GREEN;
					} else if (blueSelected) {
						colours = Color.BLUE;
					}
					if (circleSelected) {
						pp.addPrimitive(new Circle(mousePoint1, mousePoint2, colours));
					} else if (lineSelected) {
						pp.addPrimitive(new Line(mousePoint1, mousePoint2, colours));
					}
					mousePoint1 = null;
					mousePoint2 = null;

				} else {

					mousePoint1 = e.getPoint();
				}
				
				pp.repaint();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});

		f.setContentPane(p);
		f.setVisible(true);
	}

	public static void main(String[] args) {

		new Painter();

	}

	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getActionCommand().equals("CIRCLE")) {
			circleSelected = true;
			lineSelected = false;
		} else if (arg0.getActionCommand().equals("LINE")) {
			lineSelected = true;
			circleSelected = false;
		} else if (arg0.getActionCommand().equals("RED")) {
			redSelected = true;
			greenSelected = false;
			blueSelected = false;
		} else if (arg0.getActionCommand().equals("GREEN")) {
			redSelected = false;
			greenSelected = true;
			blueSelected = false;
		} else if (arg0.getActionCommand().equals("BLUE")) {
			redSelected = false;
			greenSelected = false;
			blueSelected = true;
		}

	}

}
