
public class heap {
private int numb;
private int pos=1;
private long[] arr;
public heap(int cap) {
	numb=cap;
	arr=new long[numb+1];
}
public boolean is_leaf(int p) {
	if(p>=pos/2+1)
		return true;
	return false;
}
public void add(long val) {
	arr[pos]=val;
	int p=pos;
	while(p!=1) {
		if(arr[p]>arr[p/2])
			swap(p,p/2);
		else
			break;
	}
	pos++;
}
public void remove() {
	pos--;
	arr[1]=arr[pos];
	int p=1;
	while(!is_leaf(p))
		if()
}
}
