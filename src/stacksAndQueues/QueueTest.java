package stacksAndQueues;

public class QueueTest {
	public static void main(String[] args) {
		A_Queue<String> queue1 = new A_Queue<String>(5);
		System.out.println("top of an empty queue1: " + queue1.peek());
		queue1.enqueue("Joe");
		queue1.enqueue("Mark");
		queue1.enqueue("Jessica");
		System.out.println(queue1);
		System.out.println("top of non-empty queue1: " + queue1.peek());
		System.out.println("popped queue1: " + queue1.dequeue());
		System.out.println("popped queue1: " + queue1.dequeue());
		System.out.println(queue1);
		System.out.println("popped queue1: " + queue1.dequeue());
		System.out.println("isEmpty: " + queue1.isEmpty());
		System.out.println(queue1);
		queue1.enqueue("Jessica");
		queue1.enqueue("Joe");
		queue1.enqueue("Mark");
		queue1.enqueue("Joline");
		queue1.enqueue("Chris");
		System.out.println(queue1);
		System.out.println("isFull: " + queue1.isFull());
		System.out.println("isEmpty: " + queue1.isEmpty());
		System.out.println("popped queue1: " + queue1.dequeue());
		System.out.println("isEmpty: " + queue1.isEmpty());
		System.out.println("popped queue1: " + queue1.dequeue());
		System.out.println("isEmpty: " + queue1.isEmpty());
		System.out.println(queue1);
		
		A_Queue<Integer> queue2 = new A_Queue<Integer>(10);
		for(int i=0; i<10; i++) {
			queue2.enqueue(i);
		}
		System.out.println(queue2);
		queue2.enqueue(10);
	}
}
