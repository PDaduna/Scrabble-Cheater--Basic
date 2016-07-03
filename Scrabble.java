
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class Scrabble {
	private ArrayList<String> lineList;

	public Scrabble() {

	}

	public int hash(String word) {
		int hash = 7;
		char[] letters = word.toLowerCase().toCharArray();
		Arrays.sort(letters);
		for (int i = 0; i < word.length(); i++) {
			hash = hash * 31 + letters[i];
		}
		// hash = hash%;
		// if(hash==0)
		// hash++;
		return hash % 300 + 1;
	}

	public static void main(String[] args) throws IOException {
		Scrabble scrab = new Scrabble();
		HashTable hashT = new HashTable();

		scrab.readFileLines(
				"/Users/Duni/Documents/workspace/Scrabble Cheater, Basic Edition/src/Scrabble-Cheater--Basic/words.txt");

//		hashT.put(scrab.hash("vatu"), "vatu");
//		System.out.println(scrab.hash("vatu"));
//		System.out.println(hashT.table[96].toStrings());
//		hashT.put(scrab.hash("java"), "java");
//		hashT.put(scrab.hash("boob"), "boob");
//		System.out.println(hashT.table[96].toStrings());
//		System.out.println(hashT.table[96].getValue());
//		System.out.println(hashT.table[96].getNext().getNext().getValue());

		// System.out.println(scrab.lineList);

		for (String word : scrab.lineList) {
			hashT.put(scrab.hash(word), word);
		}

		// hashT.display();
		//
		// System.out.println(scrab.lineList.size());
		// System.out.println();
		// for(int i=1;i<hashT.table.length;i++){
		// if(hashT.table[i].toStrings()==null) break;
		// else System.out.println(hashT.table[i].toStrings());
		// }

		System.out.println(scrab.lookUp(hashT.table, "oobb"));

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
	//	if loot = null then there is no match
	private String lookUp(Entry[] table, String word) {
		int hash = hash(word);
		char[] letters = word.toLowerCase().toCharArray();
		Arrays.sort(letters);
		String loot = null;
		Entry entry = table[hash];
		System.out.println("Your letters are: " + word);
		while (entry.getNext() != null) {
			char[] findWord = entry.getValue().toLowerCase().toCharArray();
			Arrays.sort(findWord);
			if (Arrays.equals(letters, findWord)) {
				loot = entry.getValue();
				System.out.print("You could use this word: ");
				return loot;
			} else {
				entry = entry.getNext();
				findWord = entry.getValue().toLowerCase().toCharArray();
				Arrays.sort(findWord);
			}
		}
		System.out.println("No match found!");
		return loot;
	}

}