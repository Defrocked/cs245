package lab8Sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Master {

	public static void main(String[] args) {
		Integer min = 10000;
		Integer max = 100000;
		int socketNum = 5;
		int temp = 0;
		long startTime = 0;

		try {
			System.out.println("Server running...");
			ServerSocket ss = new ServerSocket(9999);
			for (int i = 0; i < socketNum; i++) {
				Socket sm = new Socket("localhost", Integer.parseInt(JOptionPane.showInputDialog("port number: ")));
				ObjectOutputStream oos = new ObjectOutputStream(sm.getOutputStream());
				startTime = System.currentTimeMillis();
				//STRIPING
				oos.writeObject(min);
				oos.writeObject(max);
				oos.writeObject(socketNum);
				oos.writeObject(new Integer(i));
				
				//BLOCKING
//				temp = (max - min) / socketNum;
//				if(i == 0){
//					oos.writeObject(min);
//					oos.writeObject(min + temp);
//				} else {
//					oos.writeObject(min + temp * i + 1);
//					oos.writeObject(min + temp * (i+1));
//				}
				
				sm.close();
			}
			Integer count = 0;
			for (int j = 0; j < socketNum; j++) {
				Socket s = ss.accept();

				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());

				count = count + (Integer) ois.readObject();
				System.out.println(System.currentTimeMillis() - startTime);
				System.out.println(count);

				s.close();
			}

			ss.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* blocking method speed 9000
	 * 4,4,4,4,32 <--- last one longer because the others finish before im done typing in
	 * whereas the last one still had to do its calculations
	 * blocking method speed 99000
	 * 3,3,4,4,984 <--- literally the same thing, just more pronouced w/ more numbers
	 */

}
