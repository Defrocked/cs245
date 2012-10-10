package hashtables;

import java.util.ArrayList;

public class ProbingHashTable<T> implements HashTable<T> {
	private ArrayList<T> hashTable;
	private ArrayList<String> keyCode;

	public ProbingHashTable(int size) {
		System.out.println(size);
		hashTable = new ArrayList<T>(size);
		keyCode = new ArrayList<String>(size);

		for (int i = 0; i < size; i++) {
			hashTable.add(null);
			keyCode.add("e");
		}
		System.out.println(hashTable.size());

	}

	public String toString() {
		String temp = "";
		temp = hashTable.toString();
		// System.out.println(keyCode.toString());

		return temp;
	}

	@Override
	public boolean put(T element) {
		if ((!keyCode.contains("e")) && (!keyCode.contains("r"))) {
			// System.out.println("ALL FULL");
			return false;
		}
		int i = 0;
		int hashCode = element.hashCode() % hashTable.size();
		if (keyCode.get(hashCode).equals("e") || keyCode.get(hashCode).equals("r")) {
			hashTable.set(hashCode, element);
			keyCode.set(hashCode, "f");
		} else {
			// System.out.println(keyCode.get(hashCode));
			while (keyCode.get(hashCode + i).equals("f")) {
				i++;
				// System.out.println("iterating: " + i);
				if ((hashCode + i) >= hashTable.size()) {
					hashCode = 0;
					i = 0;
				}
			}
			// System.out.println("probing called");
			// System.out.println(i);
			hashTable.set(hashCode + i, element);
			keyCode.set(hashCode + i, "f");
		}
		return true;
	}

	@Override
	public boolean contains(T element) {
		int hashCode = element.hashCode() % hashTable.size();
		int i = hashCode;
		int j = 0;
		while (hashTable.get(i) != null) {
			if (hashTable.get(i).equals(element)) {
				return true;
			}
			//special case for last hash spot
			if(hashTable.get(hashTable.size()-1) != null && hashTable.get(hashTable.size()-1).equals(element)){
				return true;
			}
			i++;
			if ((hashCode + i) >= hashTable.size()) {
				hashCode = 0;
				i = 0;
			}	
			if(j > 10){
				return false;
			}
			j++;
		}
		return false;
	}

	@Override
	public boolean remove(T element) {
		int i = 0;
		int hashCode = element.hashCode() % hashTable.size();
		if (keyCode.get(hashCode).equals("f") && hashTable.get(hashCode).equals(element)) {
			hashTable.set(hashCode, null);
			keyCode.set(hashCode, "r");
			return true;
		} else if (keyCode.get(hashCode).equals("r") || keyCode.get(hashCode).equals("f")) {
			if (keyCode.get(hashCode + i).equals("e")) {
				// System.out.println("cannot remove: not in the array");
				return false;
			}
			while (!(hashTable.get(hashCode + i).equals(element))) {
				// System.out.println("remove iterating: " + i);
				i++;
				if ((hashCode + i) >= hashTable.size()) {
					hashCode = 0;
					i = 0;
				}
			}
			// System.out.println("remove probing called");
			hashTable.set(hashCode + i, null);
			keyCode.set(hashCode + i, "r");
		}
		return true;
	}
}
