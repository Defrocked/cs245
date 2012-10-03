package stacksAndQueues;

public class A_Stack<T> implements StackInterface<T> {
	private T[] stack = null;
	private int top = 0;

	@SuppressWarnings("unchecked")
	public A_Stack(int maxSize) {
		stack = (T[]) (new Object[maxSize]);
	}

	@Override
	public boolean isEmpty() {

		return top == 0;
	}

	@Override
	public boolean isFull() {

		return top == stack.length;
	}

	@Override
	public int getSize() {

		return top;
	}

	@Override
	public T peek() {

		return stack[top];
	}

	@Override
	public T pop() {
	 T temp = stack[top];
	 stack[top] = null;
	 top--;
	 
		return temp;
	}

	@Override
	public void push(T o) {
		try{
		stack[top + 1] = o;
		top++;
		} catch(ArrayIndexOutOfBoundsException e) {
			throw new RuntimeException("OVERFLOW, DAT STACK CRAY");
		}
		 
	}

	@Override
	public String toString() {
		String result = "[";

		for (int i = top; i >= 0; i--) {
			result += stack[i] + ", ";
		}
		
		result = result.substring(0, result.length() - 2);
		result += "]";

		return result;

	}
}
