package lafore33;


import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
	public static void InsertSort(int[] ar) {
		int i=0,buf,point;
		while (ar[i]<=ar[i+1]) i++;
		//i++;
		while(i<=ar.length-1) {
			point=i;
			buf=ar[i];
			while(buf<=ar[point]&&point>0) {
			    ar[point]=ar[--point];
			
			}
			
			ar[++point]=buf;
			i++;
		}
	}
	public static void main(String[] arg) throws IOException {
		Scanner in=new Scanner(new FileReader("input.txt"));
		PrintWriter out=new PrintWriter(new FileWriter("output.txt"));
		Random rand=new Random();
		
		int[] array=new int[10];
		for(int i=0;i<array.length;i++) 
			array[i]=rand.nextInt(300);
		for(int i=0;i<array.length;i++) 
			out.println(array[i]);
		InsertSort(array);
		for(int i=0;i<array.length;i++) 
			out.println(array[i]);
		out.close();
	    
	}

}
