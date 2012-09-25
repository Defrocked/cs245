package listsLecture3;

public class MyArrayList<T> implements MyList<T> {

	private T[] values;
	private int count;
	
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		this.values = (T[])(new Object[10]);
		this.count = 0;
	}
	
	public int size() {
		return count;
	}
	
	public void add(T v) {
		// check to make sure we still have open slots
		values[count] = v;
		count++;
		// add(v, count);
	}
	
	public void add(T v, int index) {
		
		for (int i=count; i>index; i--) {
			values[i] = values[i-1];
		}
		values[index] = v;
		count++;
		
	}
	
	public T get(int index) {
		// if (index < count)....
		return values[index];	
	}
	
	public String toString() {
		String result = "[";
		
		for (int i=0; i<count; i++) {
			result += values[i] + ", ";
		}
		result += "]";
		
		return result;
	}
}
