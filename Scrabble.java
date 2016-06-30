
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Scrabble {
	
	public int hash(String word){
		int hash = 7;
		for(int i=0;i<word.length();i++){
			hash = hash*31 + word.charAt(i);
		}
		return hash%1000+1;
	}
	

	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Scrabble scrab = new Scrabble();
		HashTable hashT = new HashTable();
		
	    File file = new File("/Users/Duni/Documents/workspace/Scrabble Cheater, Basic Edition/src/words.txt");
	    FileInputStream fis = null;
	    BufferedInputStream bis = null;
	    DataInputStream dis = null;
	 
	    System.out.println(scrab.hash("aajv"));
	    System.out.println(scrab.hash("jaav"));
	    
	    
	    try {
	      fis = new FileInputStream(file);
	 
	      // Here BufferedInputStream is added for fast reading.
	      bis = new BufferedInputStream(fis);
	      dis = new DataInputStream(bis);
	 
	      while(dis.readLine()!=null){
	    	  hashT.put(hashT.hash(dis.readLine()), dis.readLine());
	      }
	      hashT.display();
	      
	      int bla = 0;
	      // dis.available() returns 0 if the file does not have more lines.
	      while (dis.available() != 0) {
	    	  if(scrab.hash(dis.readLine())==0){
	    		  System.out.println("AAAAAAA");
	    		  break;
	    	  }
	    	 hashT.put(scrab.hash(dis.readLine()),dis.readLine());
	      // this statement reads the line from the file and print it to
	        // the console.
	        System.out.print(dis.readLine());
	        System.out.println("    " + hashT.hash(dis.readLine()));
	        if(bla < scrab.hash(dis.readLine())){
	        	bla = scrab.hash(dis.readLine());
	        }

		      System.out.println(bla);
	      }
	      // dispose all the resources after using them.
	      fis.close();
	      bis.close();
	      dis.close();
	 
	    } catch (FileNotFoundException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	  }

	}