
public class My_HashTable {

	public entry[] array;
	
	public My_HashTable(int size) {
		array=new entry[size];
	}
	
	public int hashcode(String key) {
		return Math.abs(key.hashCode());
	}
	
}
