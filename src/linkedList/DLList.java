package linkedList;



public class DLList<T> implements ListIf<T> {
	
	// Nested helper class
		private class Node {
			// These are private, but LList can see them since Node is a nested
			// class
			private T element;
			private Node next;
			private Node prev;

			public Node(T o) {
				element = o;
				next = null;
				prev = null;
			}
		}

		// LList's instance variables
		private Node last;
		private Node first;
		private int size;

		// Default constructor
		public DLList() {
			first = null; // empty list
			last = null;
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
				last = first.next; 											//CHANGE FOR DDL

			} else { // works for middle and end cases

				// Find the node before index
				Node n = first;
				for (int i = 0; i < index - 1; i++) {
					n = n.next;
				}
				result = n.next.element;
				n.prev = last;												 //CHANGE FOR DDL
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

					return count;
				}
				count++;
				n = n.next;
			}
			return -1;
		}

		public void toString(T o) {
			Node n = first;
			System.out.println("[");

			while (n != null) {
				System.out.println(" " + n.element + " ");
				n = n.next;
			}

			System.out.println("]");
		}

	}
