package linkedList;

public class Tester {

	public static void main(String[] args) {
//		//part 1, linked list
//		ListIf<String> l = new LList<String>();
//
//		l.add("hello");
//		l.add("world");
//		l.add("champs");
//		l.add("jboss");
//		l.add(3, "coding");
//		
////		l.remove(1);
////		l.set(0, "hi");
////		System.out.println(l.size());
////		System.out.println(l.contains("jboss"));
////		System.out.println(l.indexOf("champs"));
////		System.out.println(l.remove("champs"));
//	
//		for(int i = 0; i < l.size(); i++){
//			System.out.println(l.get(i).toString());
//		}
		
		//part 2, double linked list
		ListIf<String> dll = new DLList<String>();
		
		dll.add("hello");
		dll.add("world");
		dll.add("champs");
		dll.add("jboss");
		dll.add(3, "coding");
		
//		dll.remove(1);
		dll.set(0, "hi");
		System.out.println(dll.size());
		System.out.println(dll.contains("jboss"));
		System.out.println(dll.indexOf("champs"));
//		System.out.println(dll.remove("champs"));
	
		for(int i = 0; i < dll.size(); i++){
			System.out.println(dll.get(i).toString());
		}

	}

}
