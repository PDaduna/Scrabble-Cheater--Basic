

public class HashTable {
	private final static int TABLE_SIZE = 3000;
	 
    Entry[] table;

    HashTable() {
          table = new Entry[TABLE_SIZE];
          for (int i = 0; i < TABLE_SIZE; i++)
                table[i] = null;
    }

    public String get(int key) {
          if (table[key] == null)
                return null;
          else {
                Entry entry = table[key];
                while (entry != null && entry.getKey() != key)
                      entry = entry.getNext();
                	
                if (entry == null)
                      return null;
                else
                      return entry.getValue();
          }
    }

    public void put(int key, String value) {
       
          if (table[key] == null)
                table[key] = new Entry(key, value);
          else {
                Entry entry = table[key];
                while (entry.getNext() != null && entry.getKey() == key){
                      entry = entry.getNext();
                }
//                if (entry.getKey() == key)
//                      entry.setValue(value);
//                else
                  entry.setNext(new Entry(key, value));
          }
    }

    public void remove(int key) {
          if (table[key] != null) {
                Entry prevEntry = null;
                Entry entry = table[key];
                while (entry.getNext() != null && entry.getKey() != key) {
                      prevEntry = entry;
                      entry = entry.getNext();
                }
                if (entry.getKey() == key) {
                      if (prevEntry == null)
                           table[key] = entry.getNext();
                      else
                           prevEntry.setNext(entry.getNext());
                }
          }
    }
    
    public void display(){
        
        for(int i=0;i<TABLE_SIZE;i++){
        	Entry entry = table[i];
            if(table[i]!=null){
            	System.out.print("{"+entry.getKey()+"="+entry.getValue()+"}" +" ");
//                   while(entry.getValue()!=null){
//                         System.out.print("{"+entry.getKey()+"="+entry.getValue()+"}" +" ");
//                         entry=entry.getNext();
//                   }
            }
        }             
     
     }

    
    
    
}