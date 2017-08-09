
public class ArrayList<E> {

	private int size;
	
	private int capacity;
	
	private final int default_size=20;
	
	public int size() {
		return size;
	}
	
	private E[] data;
	
	public ArrayList() {
		capacity=default_size;
		data=(E[]) new Object[capacity];
	}
	
	public ArrayList(int capacit) {
	  capacity=capacit;
	  data=(E[]) new Object[capacity];
	}
	
	public void set(E val,int index) {
		if(index>size||index<0) 
		try { throw new Exception(); } catch(Exception e) { System.out.print("bound exception"); }
		else
			data[index]=val;
	}
	
	public E get(int index) {
		if(index>size||index<0) try {
			throw new Exception(); } catch(Exception e) { System.out.print("bound exception"); return null; }
		else
			return data[index];
	}
	
	public void delete(int index) {
		if(index>size||index<0)
			 try {throw new Exception(); } catch(Exception e) { System.out.print("bound exception");}
		else {
			for(int i=index;i<size;i++)
				data[i]=data[i+1];
			data[size]=null;
			size--;
		}
	}
	
	public void add(E val) {
		if(size>=capacity-1) {
			E[] temp=(E[]) new Object[size+1];
			  for(int i=0;i<=size;i++)
				  temp[i]=data[i];
			  capacity*=2;
			  data=(E[]) new Object[capacity];
			  for(int i=0;i<capacity/2;i++)
				  data[i]=temp[i];
		}	else 
			data[size++]=val;
	}
	
	public boolean is_empty() {
		return (size==0);
	}
}
