package socketsLecture;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {

		try {
			System.out.println("Server running...");

			ServerSocket ss = new ServerSocket(7002);
			while (true) {
				Socket s = ss.accept(); // Block until connecting received

				ObjectInputStream ois = new ObjectInputStream(
						s.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream(
						s.getOutputStream());

				Integer o1 = (Integer) ois.readObject(); // Blocking operation

				Integer o2 = (Integer) ois.readObject(); // Blocking operation

				System.out.println(o1 + " " + o2);

				oos.writeObject(o1 + o2);
				s.close();
				//ss.close();
			}
//			ss.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
