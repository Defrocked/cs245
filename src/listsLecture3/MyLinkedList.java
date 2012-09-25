package listsLecture3;

public class MyLinkedList<T> implements MyList<T> {
	
	// Internal class that is only used within MyLinkedList
	private class Node {
		
		private T value;
		private Node next;
		
		public Node(T value) {
			this.value = value;
			next = null;
		}

	}
	
	private Node head;
	
	public MyLinkedList() {
		head = null;
	}

	@Override
	public int size() {
		
		return 0;
	}

	@Override
	public void add(T v) {
		//add(v, count);
		
	}

	@Override
	public void add(T v, int index) {
		
		Node nn = new Node(v);	
		
		Node n = head;
		for (int i=0; i<index-1; i++) {
			n = n.next; 
		}
		
		nn.next = n.next;
		n.next = nn;
	
	}

	@Override
	public T get(int index) {
		
		Node n = head;
		for (int i=0; i<index; i++) {
			n = n.next; 
		}
		
		return n.value;
	}

	public String toString() {
		return "my linked list";
	}
	
}
