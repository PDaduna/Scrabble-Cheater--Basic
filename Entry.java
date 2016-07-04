public class Entry {
	private int key;
    private String value;
    private Entry next;

    Entry(int key, String value) {
          this.key = key;
          this.value = value;
          this.next = null;
    }

    public String getValue() {
          return value;
    }

    public void setValue(String value) {
          this.value = value;
    }

    public int getKey() {
          return key;
    }

    public Entry getNext() {
          return next;
    }

    public void setNext(Entry next) {
          this.next = next;
    }
    
    public String toStrings() {
        String result = value + " ";
        if (next != null) {
            result += next.toStrings();
        }
        return result;
    }
}