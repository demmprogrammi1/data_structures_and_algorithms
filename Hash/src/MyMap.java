import java.util.*;
import java.lang.*;
import java.io.*;
public class MyMap {
  
  private int size;
  
  public int size() {
	  return size;
  }
  private My_HashTable table;
  
  private boolean is(int a) {
	  if(a==0) 
		  return false;
	  for(int i=2;i<a;i++)
		  if(a%i==0)
			  return false;
	  return true;
  }
  private int func(int a) {
	  int temp=5*a;
	  while(!is(temp))
		  temp++;
	  return temp;
  }
  
  public MyMap(int size) {
	  table=new My_HashTable(func(size));
	  this.size=func(size);
	  for(int i=0;i<table.array.length;i++)
		  table.array[i]=null;
  }
  
  public void put(String key,int val) {
	  int k=1;
	  int p=hash(key)%size;
	  int temp=p;
	  if(table.array[temp]==null||table.array[temp].getKey().equals(key))
		  table.array[temp]=new entry(key,val);
	  else
		do {
			  if(table.array[(p+k*k)%size]==null||table.array[(p+k*k)%size].getKey().equals(key)) {
				  table.array[(p+k*k)%size]=new entry(key,val);
				  break;
			  }
			  k++;
		  } while(p!=temp);
  }
  
  public int get(String key) {
	  int p = hash(key)%size, k = 1;
      while (table.array[p] != null)
      {
          if (table.array[p].getKey().equals(key))
              return table.array[p].getValue();
          p = (p + k*k) %size;
          k++;
      }            
      return 0;
  }
  
  public void remove(String key) {
	  int k=0;
	  int p=(hash(key)%size);
	 if(get(key)==0) 
         return;
     while(!table.array[p].getKey().equals(key))
    	 p=(p+k*k++)%size;
     table.array[p].value=null;
     p=(p+k*k++)%size;
     while(table.array[p]!=null) {
    	 String str=table.array[p].getKey();
    	 int val=table.array[p].getValue();
    	 table.array[p]=null;
    	 put(str,val);
    	 p=(p+k*k++)%size;
     }
  }
  public int hash(String key) {
	  return table.hashcode(key);
  }
  
}
