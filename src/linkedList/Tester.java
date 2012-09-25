package linkedList;

public class Tester {

	public static void main(String[] args) {
		
		ListIf<String> l = new LList<String>();
		
		l.add("hello");
		l.add("world");
		
		l.remove(1);
		
		System.out.println(l); //wtf is this memory address i'm getting
		System.out.println(l.toString());
		
		
		

	}

}
