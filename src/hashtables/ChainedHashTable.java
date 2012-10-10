package hashtables;


import java.util.*;

public class ChainedHashTable<T> implements HashTable<T>{
	private ArrayList<LinkedList<T>> hashTable;

	
	public ChainedHashTable(int size){
		//System.out.println(size);
		
		hashTable = new ArrayList<LinkedList<T>>();
		
		
		for (int i = 0; i < size; i++){
			hashTable.add(new LinkedList<T>());
		}
		//System.out.println(hashTable.size());
		
	}

	@Override
	public boolean put(T element) {
		
		int hashCode = element.hashCode() % hashTable.size();
			hashTable.get(hashCode).add(element);

			return true;
	}
	@Override
	public boolean contains(T element) {
		int hashCode = element.hashCode() % hashTable.size();
		return hashTable.get(hashCode).contains(element);
	}
	@Override
	public boolean remove(T element) {
		int hashCode = element.hashCode() % hashTable.size();
		if (hashTable.get(hashCode).contains(element)){
			hashTable.get(hashCode).remove(element);
			return true;
		}
		
		return false;
	}
	
	public String toString(){
		String temp = "";
		for(int i = 0; i < hashTable.size(); i++){
			temp = temp + hashTable.get(i).toString();
		}
		
		return temp;
	}

}
