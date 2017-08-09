

public class my_Bitset {
public boolean[] arr;

private int size;
public void extend(int size_1) {
	boolean[] temp=new boolean[size];
	int old_size=size;
	for(int i=0;i<size;i++)
		temp[i]=arr[i];
	size=size_1;
	arr=new boolean[size];
	for(int i=0;i<old_size;i++)
		arr[i]=temp[i];
}
public void set(int index,boolean val) {
	if(index>size-1) 
		extend(index+size);	
	arr[index]=true;
}
public boolean get(int index) {
	if(index>size-1)
		 return false; 
	else
		return arr[index];
}
public int size() {
	return arr.length;
}

public my_Bitset() {
	arr=new boolean[4];
	size=4;
}

public my_Bitset(int size) {
	arr=new boolean[size];
	this.size=size;
}

}
