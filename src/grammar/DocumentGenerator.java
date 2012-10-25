package grammar;

import java.io.FileNotFoundException;

public class DocumentGenerator {

	public static void main(String[] args) throws FileNotFoundException {
		//Read in Grammar
		//Grammar g = new Grammar("C:\\Users\\Gavin\\Downloads\\CsAssign.grm.txt");
		Grammar g = new Grammar("/home/Perjury/workspace/sdfghj/CsAssign.grm");
		
		//Generate random sentence from Grammar
		String sentence = g.generateSentence();
		
		System.out.println(sentence);
	}
}
