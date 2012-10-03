package stacksAndQueues;

import linkedList.*;

public class List_Queue<T> implements QueueInterface<T> {
	{

	}

	@Override
	public boolean isEmpty() {
		
		return first == null;
	}

	@Override
	public boolean isFull() {
		
		return false;
	}

	@Override
	public int getSize() {
		
		return size;
	}

	@Override
	public T peek() {
		
		return first;
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enqueue(T o) {
		// TODO Auto-generated method stub

	}
}
