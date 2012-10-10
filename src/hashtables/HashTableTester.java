package hashtables;

public class HashTableTester {

	public static void main(String[] args) {
		
		//HashTable<Foo> ht = new ChainedHashTable<Foo>(10);
		HashTable<Foo> ht = new ProbingHashTable<Foo>(10);
	
		ht.put(new Foo(1));
		ht.put(new Foo(2));
		ht.put(new Foo(3));
		ht.put(new Foo(5));
		ht.put(new Foo(8));
		System.out.println(ht.toString());
		
		System.out.println(ht.contains(new Foo(5)));
		System.out.println(ht.contains(new Foo(6)));
		System.out.println(ht.contains(new Foo(15)));
		
		ht.put(new Foo(15));
		System.out.println(ht.toString());
		
		ht.put(new Foo(25));
		System.out.println(ht.toString());
		
		ht.put(new Foo(35));
		System.out.println(ht.toString());
		
		ht.remove(new Foo(25));
		System.out.println(ht.toString());
		
		System.out.println(ht.contains(new Foo(35)));
		System.out.println(ht.contains(new Foo(45)));
		
		ht.put(new Foo(12));
		System.out.println(ht.toString());
		
		ht.put(new Foo(22));
		System.out.println(ht.toString());
		
		ht.put(new Foo(53));
		System.out.println(ht.toString());
		
		System.out.println(ht.put(new Foo(48)));		
		
		System.out.println(ht.contains(new Foo(25)));
		System.out.println(ht.contains(new Foo(48)));
		
		ht.remove(new Foo(15));
		System.out.println(ht.toString());
		
		ht.remove(new Foo(3));
		System.out.println(ht.toString());
		
		System.out.println(ht.contains(new Foo(15)));
		System.out.println(ht.contains(new Foo(35)));
	}

}
