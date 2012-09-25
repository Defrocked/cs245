package listsLecture3;

public interface MyList<T> {
	public int size();
	public void add(T v);
	public void add(T v, int index);
	public T get(int index); 
}
 