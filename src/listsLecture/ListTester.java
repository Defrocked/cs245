package listsLecture;

import java.util.ArrayList;
import java.util.Collections;

public class ListTester {

	public static void main(String[] args) {
		
//		int[] a = new int[5];
//		
//		a[3] = 5;
//		int x = a[3];
//		System.out.println(a);
//		
//		
//		ArrayList<Integer> al = new ArrayList<Integer>();
//		
//		al.add(new Integer(5));
//		al.add(8);
//		
//		al.add(0, 18);
//		
//		al.set(0, 2);
//		
//		//al.add("foo");
//		
//		Integer i = new Integer(2);
//		int temp = i.intValue() + 5;
//		
//		System.out.println(al.size());
//		
		
		ArrayList<Circle> al = new ArrayList<Circle>();
		Circle c1 = new Circle(5, 0, 0);
		Circle c2 = new Circle(5, 0, 0);
		Circle c3 = new Circle(2, 1, 2);		
		
		System.out.println(c1.toString());
		System.out.println(c2);
		
		al.add(c1);
		al.add(c2);
		al.add(c3);
		
		System.out.println(al);

		if (c1.equals(c2)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		
		System.out.println(al.contains(new Circle(5, 0, 0)));
		
		Collections.sort(al);
		System.out.println(al);
		
		
	}

}
