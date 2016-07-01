
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Scrabble {

	private ArrayList<String> lineList;

	public int hash(String word) {
		int hash = 7;
		char[] letters = word.toLowerCase().toCharArray();
		Arrays.sort(letters);
		for (int i = 0; i < word.length(); i++) {
			hash = hash * 31 + letters[i];
		}
//		hash = hash%;
//		if(hash==0)
//			hash++;
		return hash % 300+1;
	}

	public static void main(String[] args) throws IOException {
		Scrabble scrab = new Scrabble();
		HashTable hashT = new HashTable();
		
		scrab.readFileLines(
				"/Users/Duni/Documents/workspace/Scrabble Cheater, Basic Edition/src/Scrabble-Cheater--Basic/words.txt");

		
		hashT.put(scrab.hash("vatu"), "vatu");
		System.out.println(scrab.hash("vatu"));
		System.out.println(hashT.table[96].toStrings());
		hashT.put(scrab.hash("java"), "java");
		System.out.println(hashT.table[96].toStrings());
		System.out.println(hashT.table[96].getNext().toStrings());
		

		System.out.println(scrab.lineList);

		for (String word : scrab.lineList) {
			hashT.put(scrab.hash(word), word);
		}

//		hashT.display();
		
		System.out.println(hashT.table[100].toStrings());
		
		System.out.println();
		for(int i=1;i<hashT.table.length;i++){
			System.out.println(hashT.table[i].toStrings());
		}
		
		
		
	}

	private void readFileLines(String textFile) throws IOException {
		FileReader fr = new FileReader(textFile);
		BufferedReader br = new BufferedReader(fr);
		lineList = new ArrayList<String>();
		String thisLine;
		while ((thisLine = br.readLine()) != null) {
			lineList.add(thisLine);
		}
		br.close();
	}
}