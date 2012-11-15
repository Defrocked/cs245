package breakout;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("unused")
public class Breakout {
	
	public static ArrayList<BreakoutComponent> bcal;
	private JLabel l;
	private static BreakoutPanel breakout;
	static Ball ba;
	static Paddle pd;
	
	public Breakout() throws FileNotFoundException {
		JFrame f = new JFrame();
		f.setSize(new Dimension(530, 520));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		
		l = new JLabel();
		l.setText("Breakout");
		
		breakout = new BreakoutPanel();
		
		bcal = new ArrayList<BreakoutComponent>();
		
		Brick b = new Brick(20, 30, 40, 10);
		Brick b1 = new Brick(470, 30, 40, 10);
		Brick b2 = new Brick(150, 30, 40, 10);
		Brick b3 = new Brick(340, 30, 40, 10);
		Brick b4 = new Brick(85, 60, 40, 10);
		Brick b5 = new Brick(405, 60, 40, 10);
		
		Brick b6 = new Brick(20, 330, 40, 10);
		Brick b7 = new Brick(470, 330, 40, 10);
		Brick b8 = new Brick(150, 330, 40, 10);
		Brick b9 = new Brick(340, 330, 40, 10);
		Brick b10 = new Brick(85, 300, 40, 10);
		Brick b11 = new Brick(405, 300, 40, 10);
		Brick b12 = new Brick(245, 180, 40, 10);
		
		KillingWall w = new KillingWall(0,0,530,10);
		KillingWall w1 = new KillingWall(0,0,10,430);
		KillingWall w2 = new KillingWall(520,0,10,430);
		KillingWall kw = new KillingWall(0,420,530,10);
		pd = new Paddle(200,400,80,10);
		ba = new Ball(200,100,10,10);
		
	//	loadInMap();
		
		bcal.add(b);
		bcal.add(b1);
		bcal.add(b2);
		bcal.add(b3);
		bcal.add(b4);
		bcal.add(b5);
		bcal.add(b6);
		bcal.add(b7);
		bcal.add(b8);
		bcal.add(b9);
		bcal.add(b10);
		bcal.add(b11);
		bcal.add(b12);
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
	
	private void loadInMap() throws FileNotFoundException {
		File file = new File("/home/Perjury/workspace/sdfghj/BreakoutMap.txt");
		Scanner in = new Scanner(file);
		int iterator = 0;
		while(in.hasNext()){
		String name = "o" + iterator;
		
		String init = in.next() + " " + name + " = new " + in.match() +"(" + in.nextInt() + ", " + in.nextInt() + ", "; 
		//init.
		Brick b = new Brick(20, 130, 400, 10);
		Wall w = new Wall(0,0,530,10);
		Wall w1 = new Wall(0,0,10,430);
		Wall w2 = new Wall(520,0,10,430);
		KillingWall kw = new KillingWall(0,420,530,10);
		pd = new Paddle(200,400,80,10);
		ba = new Ball(200,100,10,10);
		
		
			if(iterator % 5 == 0){
				
			//	bcal.add(name);
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		new Breakout();
		Breakout.run();
		
	}

	private static void run() {
		long ct;
		ArrayList<MovingComponent> mcal = new ArrayList<MovingComponent>(10);
		mcal.add(ba);
		mcal.add(pd);
		while(true){
			
//			for(int i = 0; i < breakout.sizeOf(); i++){
//				breakout.returnComponent(i);
//			}
			
			for (int i = 0; i < mcal.size(); i ++){
				mcal.get(i).updatePosition();
				bcal.add(5, (BreakoutComponent) mcal.get(i));
			}
			
//			breakout.addMouseMotionListener( new MouseMotionListener() {
//
//				@Override
//				public void mouseDragged(MouseEvent e) {
//					// TODO Auto-generated method stub
//					
//				}
//
//				@Override
//				public void mouseMoved(MouseEvent e) {
//					pd.mouseX = e.getX() - 40;
//				}
//				
//			});
//			System.out.println(mcal.get(0));
			System.out.println(bcal.get(5));
////			breakout.addComponent(ba);
//			Brick brick = new Brick(100, 20, 40, 10);
//			bcal.add(5, brick);
			
			for (int i = 0; i < mcal.size(); i ++){
				mcal.get(i).collisionCheck(bcal);
			}
			
			breakout.repaint();
			ct = System.currentTimeMillis();
			while(System.currentTimeMillis() < ct + 20){
				
			}
		}
		
	}
}
