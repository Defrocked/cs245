package stacksAndQueues;

public class StackTest {
	public static void main(String[] args) {
		A_Stack<String> stack = new A_Stack<String>(10);
		System.out.println("top of an empty stack: " + stack.peek());
		stack.push("Joe");
		stack.push("Mark");
		stack.push("Jessica");
		System.out.println("top of non-empty stack: " + stack.peek());
		System.out.println("popped stack: " + stack.pop());
		System.out.println("popped stack: " + stack.pop());
		System.out.println("isFull: " + stack.isFull());
		System.out.println("isEmpty: " + stack.isEmpty());
		System.out.println("popped stack: " + stack.pop());
		System.out.println("isEmpty: " + stack.isEmpty());
		System.out.println("popped stack: " + stack.pop());
		System.out.println("isEmpty: " + stack.isEmpty());
		for(int i=0; i<10; i++) {
			stack.push("" + i);
		}
		System.out.println(stack.toString());
		// deliberately adding one too many objects to the stack
		stack.push("" + 10);
	}
}