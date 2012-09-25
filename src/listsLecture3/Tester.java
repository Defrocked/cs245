package listsLecture3;

public class Tester {

	public static void main(String[] args) {
		
//		long t1 = System.currentTimeMillis();
//		ArrayList al = new ArrayList(10000000);
//		
//		for (int i=0; i<10000000; i++) {
//			al.add(new Integer(i));
//		}
//		long t2 = System.currentTimeMillis();
//		System.out.println(t2 - t1);
		
		MyList<String> al = new MyLinkedList<String>();
		
		al.add("foo");
		
		String x = al.get(0);
		System.out.println(x); 
		
		int s = al.size();
		System.out.println(s);
		System.out.println(al);
		
	}

}
