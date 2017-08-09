
public class BinHeap {

	private int capacity;
	
	private int pointer=1;
	
	private app_entry[] items;
	
	public BinHeap(int numb) {
	    capacity=numb;
		items=new app_entry[capacity+1];
	}
	
	private void swap(int l,int r) {
		app_entry temp=items[l];
		items[l]=items[r];
		items[r]=temp;
	}
	
	private boolean compare(app_entry first,app_entry second) {
		if(first.getPriority()>second.getPriority())
			return true;
		return false;		
	}
	
	public boolean is_leaf(int pos) {
		if(pos>=pointer/2)
			return true;
		return false;
	}
	public void add(app_entry item) {
		items[pointer]=item;
		int p=pointer;
		while(p!=1) {
			if(compare(items[p],items[p/2]))
			  swap(p/2,p);
			else
				break;
			p/=2;
		}
		pointer++;
	}
	public void remove() {
		items[1]=items[pointer-1];
		int p=1;
		while(!is_leaf(p)) {
			if(compare(items[2*p],items[2*p+1]))
				p=2*p;
			else
				p=2*p+1;
			if(compare(items[p],items[p/2]))
				swap(p/2,p);
			else
				break;
		}
		pointer--;
	}
	public app_entry peek() {
		return items[1];
	}
	
	public boolean is_empty() {
		return pointer==1;
	}
}
