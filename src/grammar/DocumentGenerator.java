package grammar;

public class DocumentGenerator {

	public static void main(String[] args) {
		Integer[] al;
		al = new Integer[5];
		al[0] = 1;
		al[2] = 2;
		al[3] = 3;
		for (int i = 0; i < al.length; i++) {
			System.out.print(al[i] + ", ");
		}
	}
}
