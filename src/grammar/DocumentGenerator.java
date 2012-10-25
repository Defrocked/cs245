package grammar;

import java.io.FileNotFoundException;

public class DocumentGenerator {

	public static void main(String[] args) throws FileNotFoundException {
		//Read in Grammar
		//NOTE: MAKE SURE THE FILEPATH IS CHANGED FOR WHOEVER IS USING IT
//		Grammar g = new Grammar("C:\\Users\\Gavin\\Downloads\\CsAssign.grm.txt");          //gavin (Windows)
		Grammar g = new Grammar("/home/Perjury/workspace/sdfghj/CsAssign.grm");            //mikey (Fedora)
		
		//Generate random sentence from Grammar
		String sentence = g.generateSentence();
		
		System.out.println(sentence);
	}
}
