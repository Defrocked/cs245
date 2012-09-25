package linkedList;

public class LList<T> implements ListIf<T> {

	// Nested helper class
	private class Node {
		// These are private, but LList can see them since Node is a nested class
		private T element;
		private Node next;

		public Node(T o) {
			element = o;
			next = null;
		}
	}

	// LList's instance variables
	private Node first;
	private int size;

	// Default constructor
	public LList() {
		first = null; // empty list
		size = 0;
	}

	// Added to the end
	public void add(T o) {
		add(size, o);
		// the other add we call will increment the size
	}

	// Added to the middle (or start)
	public void add(int index, T o) {

		Node nn = new Node(o);

		// Special case for adding to start
		if (index == 0) {
			nn.next = first;
			first = nn;

		} else { // works for middle and end cases

			// Find the node before index
			Node n = first;
			for (int i = 0; i < index - 1; i++) {
				n = n.next;
			}
			nn.next = n.next;
			n.next = nn;
		}

		size++;
	}

	// Get
	public T get(int index) {

		Node n = first;
		for (int i = 0; i < index; i++) {
			n = n.next;
		}
		return n.element;
	}

	// Remove
	public T remove(int index) {
		T result = null;
		
		// Special case for adding to start
		if (index == 0) {
			result = first.element;
			first = first.next;

		} else { // works for middle and end cases

			// Find the node before index
			Node n = first;
			for (int i = 0; i < index - 1; i++) {
				n = n.next;
			}
			result = n.next.element;
			n.next = n.next.next;
		}

		size--;
		
		return result;
	}

	@Override
	public void set(int index, T o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean remove(T o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
//		Node n = (Node)o;
//		int count = 0;
//		while(n != null){
//			count++;
//			n = n.next;
//		}
//		return count;
		return size;  //which of these is correct??
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean contains(T o) {
		Node n = (Node)o;
		
		while(n != null){
			if(((LList<T>) o).contains(o)){
				return true;
			}
			n = n.next;
		}
		
		
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int indexOf(T o) {
		Node n = (Node) o;
		int count = 0;
		while(n != null){
			if(((LList<T>) o).contains(n.element)){
				return count;
			}
			count++;
			n = n.next;
		}
		return -1;
	}
	
	public void toString(T o){
		@SuppressWarnings("unchecked")
		Node n = (Node)o;
		System.out.println("[");
		
		while(n != null){
			System.out.println(" " + n.element + " ");
			n = n.next;
		}
		
		System.out.println("]");
	}

}
