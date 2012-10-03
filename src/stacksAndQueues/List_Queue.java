package stacksAndQueues;

import linkedList.*;

public class List_Queue<T> implements QueueInterface<T> {

	private LList<T> l;

	private int capacity;

	List_Queue(int capacity) {
		this.capacity = capacity;
		
		this.l = new LList<T>();

	}

	@Override
	public boolean isEmpty() {

		return l.size() == 0;
	}

	@Override
	public boolean isFull() {

		return l.size() == capacity;
	}

	@Override
	public int getSize() {

		return l.size();
	}

	@Override
	public T peek() {

			if(l.size() == 0){
				return null;
			}
			return l.get(0);
	}

	@Override
	public T dequeue() {

		return l.remove(0);
	}

	@Override
	public void enqueue(T o) {
		l.add(o);

	}

	@Override
	public String toString() {

		return l.toString();

	}
}
