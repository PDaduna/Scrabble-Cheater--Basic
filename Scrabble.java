
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
		hash = (hash < 0) ? hash * -1 : hash;
		return hash % 123 + 1;
	}

	public static void main(String[] args) throws IOException {
		Scrabble scrab = new Scrabble();
		HashTable hashT = new HashTable();

		scrab.readFileLines(
				"/Users/Duni/Documents/workspace/Scrabble Cheater, Basic Edition/src/Scrabble-Cheater--Basic/7words.txt");

		for (String word : scrab.lineList) {
			hashT.put(scrab.hash(word), word);
		}

		System.out.println(scrab.lookUp(hashT.table, "coolhal"));

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

	// if loot = null then there is no match
	private String lookUp(Entry[] table, String word) {
		int hash = hash(word);
		char[] letters = word.toLowerCase().toCharArray();
		Arrays.sort(letters);
		String loot = null;
		Entry entry = table[hash];
		System.out.println("Your letters are: " + word);
		if (table[hash] == null) {
			loot = "No match found!";
			return loot;
		} else {
			while (entry.getValue() != null) {
				char[] findWord = entry.getValue().toLowerCase().toCharArray();
				Arrays.sort(findWord);
				if (Arrays.equals(letters, findWord)) {
					loot = entry.getValue();
					loot = "You could use this word: " + entry.getValue();
					return loot;
				} else {
					if (entry.getNext() == null)
						break;
					entry = entry.getNext();
					findWord = entry.getValue().toLowerCase().toCharArray();
					Arrays.sort(findWord);
				}
			}
		}
		loot = "No match found!";
		return loot;
	}

}