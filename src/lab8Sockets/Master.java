package lab8Sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Master {

	public static void main(String[] args) {
		// String[] nodeNames = {"localhost", "localhost", "localhost",
		// "localhost", "localhost"};
		// int[] nodePorts = {1000, 2000, 3000, 4000, 5000};

		try {
			System.out.println("Server running...");
			ServerSocket ss = new ServerSocket(9999);
			Socket sm = new Socket("localhost", 1000);
			ObjectOutputStream oos = new ObjectOutputStream(sm.getOutputStream());

			oos.writeObject(new Integer(1000));
			oos.writeObject(new Integer(10000));
			sm.close();
			// while(true){
			Socket s = ss.accept();
			
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			ArrayList<String> o1 = new ArrayList<String>();
			Integer count =  (Integer) ois.readObject();
			for (int i = 0; i < count.intValue(); i++){
				o1.add((String) ois.readObject());
			}
			

			for (int i = 0; i < o1.size(); i++) {
				System.out.println(o1.get(i));
			}
		//	}
			s.close();
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

}
