package lafore26;

import java.util.Random;

public class ownM {
private int size;
private int[] array;
public ownM(int size){
	this.size=size;
	array=new int[size];
}
public void full() {
	Random rand=new Random();
	array[0]=rand.nextInt(50)+1;
	for(int i=1;i<size;i++)
		array[i]=array[i-1]+rand.nextInt(50)+1;
}
public int getsize() {
	return size;
}
public void set(int index,int value) {
	array[index]=value;
}
public int at(int index) {
	return array[index];
}
public ownM merge(ownM a,ownM b) {
ownM ans=new ownM(a.getsize()+b.getsize());
for(int i=0;i<b.getsize();i++) {
	for(int j=0;j<a.getsize();j++) {
		if(b.at(i)>a.at(j)) {}
		else { ans.set(j+i, b.at(i));
		break;
		}
		}
	}	
int pointer=0;
for(int i=0;i<a.getsize();i++) {
	while(ans.at(pointer)!=0) pointer++;
    ans.set(pointer,a.at(i));
}
return ans;
}
public void print() {
	for(int i=0;i<this.getsize();i++) {
		System.out.print(this.at(i));
	    System.out.print(" ");
	}
	System.out.println();
}
}
