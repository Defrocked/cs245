package lab8Sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;

public class Node {

	public static void main(String[] args) {
		Integer start = null;
		Integer end = null;
		
		
		try {
			ServerSocket ss = new ServerSocket(1000);
			Socket s = ss.accept();
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			start =  (Integer) ois.readObject();
			end =  (Integer) ois.readObject();
			
			ss.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		int count = 0;
		ArrayList<String> al = new ArrayList<String>();

		for (int i=start.intValue(); i<=end.intValue(); i++) {
			if (isPrime(i)) {
				count++;
				al.add(i +"");
			}
		}
		
		//System.out.println("count = " + count);
//		for (int i = 0; i < al.size(); i++) {
//			System.out.println(al.get(i));
//		}
		
		try {
			Socket toMaster = new Socket("localhost", 9999);
			ObjectOutputStream oos = new ObjectOutputStream(toMaster.getOutputStream());
			
			oos.writeObject(new Integer(count));
			for(int i = 0; i < al.size(); i++){
				oos.writeObject(al.remove(i));
			}
			
			
			
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
