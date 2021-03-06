package linkedList;

public class LList<T> implements ListIf<T> {

	// Nested helper class
	private class Node {
		// These are private, but LList can see them since Node is a nested
		// class
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

	public void set(int index, T o) {
		int runs = 0;
		Node n = first;
		
		while (n != null) {
			if (runs == index) {
				n.element = o;
			}
			runs++;
			n = n.next;
		}

	}

	@Override
	public boolean remove(T o) {
		int index = indexOf(o);

		if (index == -1) { // DNE
			return false;
		} else {
			remove(index);
		}
		return true;
	
	}

	@Override
	public int size() {

		return size;
	}

	@Override
	public boolean contains(T o) {
		Node n = first;

		while (n != null) {
			if (((String) n.element).contains((CharSequence) o)) {
				return true;
			}
			n = n.next;
		}

		return false;
	}

	@Override
	public int indexOf(T o) {
		Node n = first;
		// not Node n = (Node) o; ????
		int count = 0;
		while (n != null) {
			if(n.element.equals(o)){
			//if (((String) n.element).contains((CharSequence) o)) {
				return count;
			}
			count++;
			n = n.next;
		}
		return -1;
	}

	public String toString() {
		Node n = first;
		String result = ("[");

		while (n != null) {
			result +=(n.element + ", ");
			n = n.next;
		}
		if (result.length() > 2) {
			result = result.substring(0, result.length() - 2);
		}
		result += "]";
		
		
		return result;
	}

}
