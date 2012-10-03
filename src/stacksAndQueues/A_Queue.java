package stacksAndQueues;

public class A_Queue<T> implements QueueInterface<T> {
	private T[] queue = null;
	private int front;
	private int rear;
	private int size;
	private int capacity;


	@SuppressWarnings("unchecked")
	A_Queue(int capacity) {
		this.capacity = capacity;
		queue = (T[]) (new Object[capacity]);
	}

	@Override
	public boolean isEmpty() {

		return size == 0;
	}

	@Override
	public boolean isFull() {

		return size == capacity;
	}

	@Override
	public int getSize() {

		return size;
	}

	@Override
	public T peek() {

		return queue[front];
	}

	@Override
	public T dequeue() {
		T temp = queue[front];
		queue[front] = null;
		if (front == (capacity - 1)) {
			front = 0;
		} else {
			front++;
		}
		size--;
		return temp;

	}

	@Override
	public void enqueue(T o) {
		try {
			queue[rear] = o;

			if (rear == (capacity - 1)) {
				rear = 0;
			} else {
				rear++;
			}
			size++;
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new RuntimeException("QUEUE FULL: S O T P");
		}
	}

	@Override
	public String toString() {
		String result = "[";
		int i = 0;
		while (i < capacity) {
			if (queue[i] != null) {
				result += queue[i] + ", ";
			}

			i++;
		}
		
		if (result.length() > 2) {
			result = result.substring(0, result.length() - 2);
		}
		result += "]";

		return result;

	}

}