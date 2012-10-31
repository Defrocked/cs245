package lab8Sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Node {

	public static void main(String[] args) {
		Integer start = 0;
		Integer end = 0;
		Integer stripe = 0;
		Integer sNum = 0;
		ArrayList<Integer> al = new ArrayList<Integer>();

		try {
			ServerSocket ss = new ServerSocket(Integer.parseInt(JOptionPane.showInputDialog("port number: ")));
			Socket s = ss.accept();
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			//BLOCKING
//			start =  (Integer) ois.readObject();
//			end =  (Integer) ois.readObject();
			//STRIPED
			start = (Integer) ois.readObject();
			end = (Integer) ois.readObject();
			stripe = (Integer) ois.readObject();
			sNum = (Integer) ois.readObject();
			for(int k = start.intValue() +  sNum; k < end.intValue(); k += stripe){
				al.add((Integer) k);
			}
			ss.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int count = 0;
		//BLOCKING
//		for (int i=start.intValue(); i<=end.intValue(); i++) {
//			if (isPrime(i)) {
//				count++;
//			}
//		}
		//STRIPING
		for(int i = 0; i < al.size(); i++){
			if(isPrime(al.get(i))){
				count++;
			}
		}
		
		System.out.println("count = " + count);
		
		try {
			Socket toMaster = new Socket("localhost", 9999);
			ObjectOutputStream oos = new ObjectOutputStream(toMaster.getOutputStream());
			
			oos.writeObject(new Integer(count));
			
			toMaster.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	private static boolean isPrime(int n) {
		
		boolean result = true;  // assume true and try to prove otherwise
		int i=2;
		while ((i<n) && (result == true)) {
			if ((n%i) == 0) {
				result = false;
			}
			i++;
		}		
		return result;
		
	}

}
