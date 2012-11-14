package breakout;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Breakout {
	
	public static ArrayList<BreakoutComponent> bcal;
	private JLabel l;
	private static BreakoutPanel breakout;
	static Ball ba;
	
	public Breakout() {
		JFrame f = new JFrame();
		f.setSize(new Dimension(530, 520));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		
		l = new JLabel();
		l.setText("Breakout");
		
		breakout = new BreakoutPanel();
		
		bcal = new ArrayList<BreakoutComponent>(10);
		
		Brick b = new Brick(20, 20, 40, 10);
		Wall w = new Wall(0,0,530,10);
		Wall w1 = new Wall(0,0,10,430);
		Wall w2 = new Wall(520,0,10,430);
		KillingWall kw = new KillingWall(0,420,530,10);
		Paddle pd = new Paddle(200,400,80,10);
		ba = new Ball(200,100,10,10);
		
		
		bcal.add(b);
		bcal.add(w);
		bcal.add(w1);
		bcal.add(w2);
		bcal.add(kw);
		bcal.add(pd);
		bcal.add(ba);

		
		breakout.repaint();
		
		p.add(l, BorderLayout.SOUTH);
		p.add(breakout, BorderLayout.CENTER);
		
		f.setContentPane(p);
		f.setVisible(true);

	}
	
	public static void main(String[] args) {
		new Breakout();
		Breakout.run();
		
	}

	private static void run() {
		long ct;
		ArrayList<MovingComponent> mcal = new ArrayList<MovingComponent>(10);
		mcal.add(ba);
		while(true){
			
//			for(int i = 0; i < breakout.sizeOf(); i++){
//				breakout.returnComponent(i);
//			}
			
			for (int i = 0; i < mcal.size(); i ++){
				mcal.get(i).updatePosition();
//				bcal.add(5, new Ball(mcal.get(i)));
			}
			System.out.println(mcal.get(0));
			System.out.println(bcal.get(5));
//			breakout.addComponent(ba);
			Brick brick = new Brick(100, 20, 40, 10);
			bcal.add(5, brick);
			breakout.repaint();
			ct = System.currentTimeMillis();
			while(System.currentTimeMillis() < ct + 100){
				
			}
		}
		
	}
}
